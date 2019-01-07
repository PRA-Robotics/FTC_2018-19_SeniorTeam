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
      foo.initialize(hardwareMap, 1);
    }

    public void loop(){
      foo.moveMotor(0, gamepad1.left_stick_y * 0.5);
      foo.moveMotor(1, -gamepad1.right_stick_y * 0.5);
      //buzz.rotateIntake(foo, gamepad1.left_stick_y);
      lightyear.setAnglePower(foo, gamepad1.right_trigger - gamepad1.left_trigger);
      //lightyear.extend(foo, gamepad1.right_trigger, gamepad1.left_trigger);
      buzz.angleNet(foo, gamepad2.right_stick_y);
      buzz.rotateIntake(foo, gamepad2.right_trigger, gamepad2.left_trigger);
      buzz.fish(foo, gamepad2.left_stick_y);
      //if(gamepad2.a){
      //  buzz.spinOn(foo);
      //}else{
        //buzz.spinOff(foo);
      //}
      //foo.moveMotor(5, 1);
      //telemetry.addData("Current Position:", buzz.getPosition(foo));
      //telemetry.addData("Target Position:", buzz.getTargetPosition());
      telemetry.addData("power/location:", foo.getServoPosition(0));
      telemetry.update();

    }
}
