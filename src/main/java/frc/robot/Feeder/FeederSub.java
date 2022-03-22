// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Feeder;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DRIVE;

public class FeederSub extends SubsystemBase {
  /** Creates a new Feeder. */
  private CANSparkMax FeederMotor;
  public FeederSub() {
    FeederMotor = new CANSparkMax(Constants.DRIVE.FEEDER_MOTOR, MotorType.kBrushless);
  }

  public void FeederUp(double speed){
    FeederMotor.set(speed);
  }

  public void FeederDown(double speed){
    FeederMotor.set(speed);
  }

  public void FeederOff(){
    FeederMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
