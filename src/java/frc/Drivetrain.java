package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    private final TalonFX leftFrontMotor = new TalonFX(0);
    private final TalonFX rightFrontMotor = new TalonFX(1);
    private final TalonFX leftBackMotor = new TalonFX(2);
    private final TalonFX rightBackMotor = new TalonFX(3);

    private final XboxController driverController =
        new XboxController(0);

    public DriveTrain() {
    }

    public void driveWithController() {

        double forward = inverse(driverController.getLeftY());
        double turn = inverse(driverController.getRightX());

        if (driverController.getRightTriggerAxis()) {

            leftFrontMotor.set(0.8);
            rightFrontMotor.set(0.8);
            leftBackMotor.set(0.8);
            rightBackMotor.set(0.8);

        } else if (driverController.getRightBumper()) {

            leftFrontMotor.set(-0.8);
            rightFrontMotor.set(-0.8);
            leftBackMotor.set(-0.8);
            rightBackMotor.set(-0.8);

        } else {

            leftFrontMotor.set(forward + turn);
            leftBackMotor.set(forward + turn);

            rightFrontMotor.set(forward - turn);
            rightBackMotor.set(forward - turn);
        }
    }

    public void stop() {
        leftFrontMotor.set(0);
        rightFrontMotor.set(0);
        leftBackMotor.set(0);
        rightBackMotor.set(0);
    }
}
