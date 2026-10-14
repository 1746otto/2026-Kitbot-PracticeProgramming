
package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class intakemotor {

    private final MotorController motor = new Spark(0);

    public void Intake(boolean buttonPressedForward,
                       boolean buttonPressedBackward) {

        if (buttonPressedForward) {
            motor.set(0.8);
        }
        else if (buttonPressedBackward) {
            motor.set(-0.8);
        }
        else {
            motor.set(0);
        }
    }
}
