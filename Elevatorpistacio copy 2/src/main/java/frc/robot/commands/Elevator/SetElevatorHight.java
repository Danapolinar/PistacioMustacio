// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Elevator;

public class SetElevatorHight extends CommandBase {

  double m_position;
  Elevator m_elevator;
  boolean m_isFinished;
  
  public SetElevatorHight(double position, Elevator elevator) {
    addRequirements(m_elevator);

    m_elevator = elevator;
    m_position = position;
    m_isFinished = false;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_isFinished = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    double slope = (Constants.ELEVATOR_F_DOWN - Constants.ELEVATOR_ZERO_F) / (Constants.ELEVATOR_ZERO_NEUTRAL_POSITION - Constants.ELEVATOR_ZERO_NEUTRAL_POSITION_DEADBAND);
    double yIntercept = Constants.ELEVATOR_ZERO_F - (slope * Constants.ELEVATOR_ZERO_NEUTRAL_POSITION_DEADBAND);
    double linearF = slope * (Elevator.getInstance().getElevatorPosition()) + yIntercept;

    if (m_position > Constants.ELEVATOR_ZERO) {
      Elevator.getInstance().setElevatorPosition(m_position, Constants.ELEVATOR_F_UP);
      m_isFinished = true;
    }

    if (m_isFinished == false) {
      if (Elevator.getInstance().getElevatorPosition() > Constants.ELEVATOR_ZERO_NEUTRAL_POSITION) {
        Elevator.getInstance().setElevatorPosition(m_position, Constants.ELEVATOR_F_DOWN);
      }
      else {
        if (Elevator.getInstance().getElevatorPosition() < Constants.ELEVATOR_ZERO_NEUTRAL_POSITION_DEADBAND) {
          Elevator.getInstance().setElevatorPosition(m_position, Constants.ELEVATOR_ZERO_F);
          m_isFinished = true;
        }
        Elevator.getInstance().setElevatorPosition(m_position, linearF);
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_isFinished;
  }
}
