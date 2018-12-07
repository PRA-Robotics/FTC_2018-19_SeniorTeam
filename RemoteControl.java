package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

@TeleOp(name="Remote Control")

public class RemoteControl extends OpMode{
    public static DeviceHandler foo = new DeviceHandler();
    public static Drive bar = new Drive();
    public static Intake buzz = new Intake();
    public static Outtake lightyear = new Outtake();
    public void init(){
      foo.init(hardwareMap, 1);
      buzz.init(foo);
      lightyear.init(foo);
    }

    public void loop(){
      //foo.moveMotor(0, -gamepad1.left_stick_y);
      //foo.moveMotor(1, -gamepad1.right_stick_y);
      buzz.rotateIntake(foo, gamepad1.left_stick_y);
      lightyear.setAnglePower(foo, gamepad1.right_stick_y);
      telemetry.addData("Current Position:", buzz.getPosition(foo));
      telemetry.addData("Target Position:", buzz.getTargetPosition());
      telemetry.update();
    }
}
