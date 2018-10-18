import com.qualcomm.robotcore.hardware.HardwareMap;

public class motorHandler{
    motor leftDrive = new motor(hardwareMap.get("leftMotor"));
    motor rightDrive = new motor(hardwareMap.get("rightMotor"));
}
