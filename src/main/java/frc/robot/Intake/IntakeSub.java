// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Intake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSub extends SubsystemBase {
  /** Creates a new IntakeSub. */
  private CANSparkMax intakeMotor;
  public IntakeSub() {
    intakeMotor = new CANSparkMax(Constants.DRIVE.INTAKE_MOTOR, MotorType.kBrushless);
  }

  public void intakeIn(double speed){
    intakeMotor.set(speed);
  }

  public void intakeOut(double speed){
    intakeMotor.set(speed);
  }

  public void intakeOff(){
    intakeMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
