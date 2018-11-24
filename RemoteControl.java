package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

@TeleOp(name="Remote Control")

public class RemoteControl extends LinearOpMode{
    public static DeviceHandler foo = new DeviceHandler();
    public static Drive bar = new Drive();

    @Override
    public void runOpMode(){
      foo.init(hardwareMap);
      waitForStart();
      while(opModeIsActive()){
        foo.moveMotor(0, gamepad1.left_stick_y);
        foo.moveMotor(1, gamepad1.right_stick_y);
      }
    }
}
