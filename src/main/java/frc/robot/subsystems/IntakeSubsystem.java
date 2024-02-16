
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import frc.robot.Constants;
import frc.robot.Constants.IntakeConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeSubsystem extends SubsystemBase {

  /** Creates a new Intake. */

  // Motor Controllers
  private CANSparkMax intakeMotor = new CANSparkMax(Constants.IntakeConstants.kIntakeMotorCanId, MotorType.kBrushless);

  // stores the speed of the intake motor
  private float intakeRingSpeed = 0.50f;
  // private float lowSpeed = 0.65f;

  public IntakeSubsystem() {
    // Reset the motors
    intakeMotor.restoreFactoryDefaults();

    // Sets the right side motors to be inverted
    intakeMotor.setInverted(false);

    // Sets idle mode of the motor controllers to brake mode
    intakeMotor.setIdleMode(IntakeConstants.kIntakeIdleMode);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    int num = (int) (intakeRingSpeed * 100);
    String percent = String.valueOf(num);
    SmartDashboard.putString("Intake Motors Speed", percent + "%");
    // SmartDashboard.putNumber("Average intake Encoder Position",
    // getAverageIntakeEncoderDistance());
  }

  public void startIntake() {
    intakeMotor.set(intakeRingSpeed);
    // intakeMotor2.set(intakeRingSpeed);
  }

  public void ReverseIntake() {
    intakeMotor.set(-intakeRingSpeed);

  }

  public void stopIntake() {
    intakeMotor.set(0.0);
  }

}
