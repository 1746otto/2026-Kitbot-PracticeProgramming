package frc.robot.subsystems;

import edu.wpi.first.wpilibj.TimedRobot;

public class DriveTrain extends SubsystemBase {
    private final TalonFX leftFrontMotor = new TalonFX(0);
    private final TalonFX rightFrontMotor = new TalonFX(1);
    private final TalonFX leftBackMotor = new TalonFX(2);
    private final TalonFX rightBackMotor = new TalonFX(3);

    public DriveTrain {
        leftBackMotor.setInverse(false);
        rightBackMotor.setInverse(false);
        leftFrontMotor.setInverse(false);
        rightFrontMotor.setInverse(false);
    }
    @Override

    public void teleopPeriodic {
        robotDrive.arcadeDrive(-driverController.getLeftY(), -driverController.getRightX());
    }
    // 676767676767676767
}
