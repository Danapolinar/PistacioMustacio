package frc.robot.commands.Wrist;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.WristSubsystem;

public class WristSetCmd extends CommandBase {

    private final WristSubsystem wristSubsystem;
    private final boolean open;

    public WristSetCmd(WristSubsystem wristSubsystem, boolean open) {
        this.open = open;
        this.wristSubsystem = wristSubsystem;
        addRequirements(wristSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("WristSetCmd started!");
    }

    @Override
    public void execute() {
      wristSubsystem.setPosition(open);
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("WristSetCmd ended!");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
