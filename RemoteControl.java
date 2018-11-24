package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

@Autonomous(name="runner")

public class RemoteControl extends LinearOpMode{
    public static DeviceHandler foo = new DeviceHandler();
    public static drive bar = new drive();

    @Override
    public void runOpMode(){
      foo.init(hardwareMap);
      waitForStart();
      while(opModeIsActive()){
        dh.moveMotor(0, gamepad1.left_stick_y);
        dh.moveMotor(1, gamepad1.right_stick_y);
      }
    }
}
