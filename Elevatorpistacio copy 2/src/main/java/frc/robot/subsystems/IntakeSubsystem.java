package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class IntakeSubsystem extends SubsystemBase {

    public static TalonFX intakeMotor = new TalonFX(99);
    

    public IntakeSubsystem() {
    }

    @Override
    public void periodic() {
    }

    public void setPosition(boolean open) {
        if (open) {
            intakeMotor.set(ControlMode.PercentOutput,0.5);
            
        } else {
            intakeMotor.set(ControlMode.PercentOutput,0.5);
            
        }
    }
}

