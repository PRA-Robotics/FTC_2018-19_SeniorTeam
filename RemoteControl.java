package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

@TeleOp(name="Remote Control")

public class RemoteControl extends OpMode{
    public static DeviceHandler foo = new DeviceHandler();
    public static Drive bar = new Drive();
    public static Intake buzz = new Intake();
    public void init(){
      foo.init(hardwareMap, 1);
    }

    public void loop(){
      //foo.moveMotor(0, -gamepad1.left_stick_y);
      //foo.moveMotor(1, -gamepad1.right_stick_y);
      buzz.setExtendPower(gamepad1.left_stick_y);
    }
}
