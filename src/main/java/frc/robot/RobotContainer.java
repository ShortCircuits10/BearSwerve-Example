// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Feeder.FeederSub;
import frc.robot.Index.IndexSub;
import frc.robot.Intake.IntakeSub;
import frc.robot.Shooter.ShooterSub;
import frc.robot.commands.DefaultDriveCommand;
import frc.robot.commands.MoveForward;
import frc.robot.commands.SemiCircle;
import frc.swervelib.SwerveDrivetrainModel;
import frc.swervelib.SwerveSubsystem;

public class RobotContainer {
  private static SwerveDrivetrainModel dt;
  private static SwerveSubsystem m_swerveSubsystem;


  private ShooterSub m_shooter;
  private IntakeSub m_intake;
  private IndexSub m_index;
  private FeederSub m_feeder;

  private static final XboxController m_controller = new XboxController(0);
  private static final XboxController m_controller_sec = new XboxController(1);

  private static final SendableChooser<Command> autoChooser = new SendableChooser<>();

  public RobotContainer() {
    dt = BearSwerveHelper.createBearSwerve();
    m_swerveSubsystem = BearSwerveHelper.createSwerveSubsystem(dt);
    // Set up the default command for the drivetrain.
    // The controls are defined in the command but use both sticks and the triggers on the driver controller
    m_swerveSubsystem.setDefaultCommand(new DefaultDriveCommand(
            m_swerveSubsystem,
            m_controller
    ));

    // Populate Auto Chooser
    autoChooser.setDefaultOption("Move Forward", new MoveForward(m_swerveSubsystem));
    autoChooser.addOption("Semi-Circle", new SemiCircle(m_swerveSubsystem));
    SmartDashboard.putData("Auto Chooser", autoChooser);

    // Configure the button bindings
    configureButtonBindings();



  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Back button zeros the gyroscope
    // No requirements because we don't need to interrupt anything
    JoystickButton backButton = new JoystickButton(m_controller, Button.kBack.value);
    backButton.whenPressed(m_swerveSubsystem.dt::zeroGyroscope);


    if(m_controller_sec.getRawAxis(0) > 0.5){
      m_intake.intakeIn(m_controller_sec.getRawAxis(1));
    }
    else if(m_controller_sec.getRawAxis(1) < -0.5){
      m_intake.intakeOut(m_controller_sec.getRawAxis(1) * -1);
    }
    else{
      m_intake.intakeOff();
    }


    if(m_controller_sec.getRawAxis(2) > 0.5){
      m_feeder.FeederUp(m_controller_sec.getRawAxis(2));
      m_index.IndexUp(m_controller_sec.getRawAxis(2));
    }
    else if(m_controller_sec.getRawAxis(3) < -0.5){
      m_feeder.FeederDown(m_controller_sec.getRawAxis(3) * -1);
      m_index.IndexDown(m_controller_sec.getRawAxis(3) * -1);
    }
    else{
      m_feeder.FeederOff();
      m_index.IndexOff();
    }



    if(m_controller_sec.getAButtonPressed()){
      m_shooter.Green();
    } 
    else if(m_controller_sec.getBButtonPressed()){
      m_shooter.Lime();  
    }
    else if(m_controller_sec.getYButtonPressed()){
      m_shooter.Yellow();
    }
    else {
      m_shooter.Red();
    }







  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return autoChooser.getSelected();
  }
}
