package frc.robot;
import edu.wpi.first.wpilibj.XboxController;

public class robot extends TimedRobot {

    private final XboxController controller =
        new XboxController(0);

    private final intakemotor intake =
        new intakemotor();

    @Override
    public void teleopPeriodic() {
        intake.Intake(
            controller.getAButton(),
            controller.getBButton()
        );
    }
}
