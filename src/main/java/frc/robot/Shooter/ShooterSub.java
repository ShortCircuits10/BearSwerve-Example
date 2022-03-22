// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Shooter;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class ShooterSub extends SubsystemBase {
  /** Creates a new ShooterSub. */
  private CANSparkMax shooterMotor;
  public ShooterSub() {
    shooterMotor =  new CANSparkMax(Constants.DRIVE.SHOOTER_MOTOR, MotorType.kBrushless);
  }

  
  public void Green(){
    shooterMotor.set(1);
  }

  public void Lime(){
    shooterMotor.set(0.75);
  }
  public void Yellow(){
    shooterMotor.set(0.5);
  }
  public void Red(){
    shooterMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
