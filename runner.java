package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

@TeleOp(name="runner")

public class runner extends OpMode{
    public static DeviceHandler foo = new DeviceHandler();
    public static drive bar = new drive();
    @Override
    public void init(){
      foo.init(hardwareMap);
    }

    @Override
    public void start(){

    }

    @Override
    public void loop(){
      bar.LeftMotor(-gamepad1.left_stick_y, foo);
      bar.RightMotor(-gamepad1.right_stick_y, foo);
    }
}
