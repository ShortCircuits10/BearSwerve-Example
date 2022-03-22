// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Index;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IndexSub extends SubsystemBase {
  /** Creates a new IndexSub. */
  private CANSparkMax indexMotor;

  public IndexSub() {
    indexMotor = new CANSparkMax(Constants.DRIVE.INDEX_MOTOR, MotorType.kBrushless);
  }

  public void IndexUp(double speed){
    indexMotor.set(speed);
  }

  public void IndexDown(double speed){
    indexMotor.set(speed);
  }

  public void IndexOff(){
    indexMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
