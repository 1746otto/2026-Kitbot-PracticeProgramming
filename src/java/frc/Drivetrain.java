package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.filter.SlewRateLimiter;

public class DriveTrain extends SubsystemBase {
    private final TalonFX leftFrontMotor = new TalonFX(0);
    private final TalonFX rightFrontMotor = new TalonFX(1);
    private final TalonFX leftBackMotor = new TalonFX(2);
    private final TalonFX rightBackMotor = new TalonFX(3);

    private final XboxController driverController = new XboxController(0);
    private final SlewRateLimiter forwardLimiter = new SlewRateLimiter(1.5);
    private final SlewRateLimiter turnLimiter = new SlewRateLimiter(2.0);

    public DriveTrain() {
    }

    public void driveWithController() {
        double forward = -driverController.getLeftY();
        double turn = driverController.getRightX();

        forward = forwardLimiter.calculate(forward); //Acceleration driving forward
        turn = turnLimiter.calculate(turn); //Acceleration during turning

        leftFrontMotor.set(forward + turn);
        leftBackMotor.set(forward + turn);

        rightFrontMotor.set(forward - turn);
        rightBackMotor.set(forward - turn);
    }

    public void stop() {
        leftFrontMotor.set(0);
        rightFrontMotor.set(0);
        leftBackMotor.set(0);
        rightBackMotor.set(0);
    }
}
