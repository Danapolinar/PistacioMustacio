package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class WristSubsystem extends SubsystemBase {

    public static TalonFX wristMotor = new TalonFX(102);
    

    public WristSubsystem() {
    }

    @Override
    public void periodic() {
    }

    public void setPosition(boolean open) {
        if (open) {
          wristMotor.set(ControlMode.PercentOutput,0.1);
            
        } else {
          wristMotor.set(ControlMode.PercentOutput,0.1);
            
        }
    }
}

