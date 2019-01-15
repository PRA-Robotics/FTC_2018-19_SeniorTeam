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
      telemetry.addData("IM OVA HEA DAWG", "I See YA");
      telemetry.update();
      foo.init(hardwareMap, 1);
    }

    public void loop(){
      foo.moveMotor(0, gamepad1.left_stick_y * 0.5);
      foo.moveMotor(1, -gamepad1.right_stick_y * 0.5);
      lightyear.setAnglePower(foo, gamepad1.right_trigger - gamepad1.left_trigger);

      if(gamepad1.a){
        telemetry.addData("EEEEE", "AAAAA");
        foo.moveMotor(2, 1);
      }else{
        telemetry.addData("nope", "umm");
        foo.moveMotor(2, 0);
      }
      //lightyear.extend(foo, gamepad1.right_trigger, gamepad1.left_trigger);
      buzz.angleNet(foo, gamepad2.right_stick_y);
      buzz.rotateIntake(foo, gamepad2.right_trigger - gamepad2.left_trigger);
      buzz.fish(foo, gamepad2.left_stick_y);

      if(gamepad2.a){
        telemetry.addData("EEEEE", "AAAAA");
        buzz.spinOn(foo);
      }else{
        telemetry.addData("nope", "umm");
        buzz.spinOff(foo);
      }

      //foo.moveMotor(5, 1);
      telemetry.update();
      //foo.moveMotor(5, 1);
      //telemetry.addData("Current Position:", buzz.getPosition(foo));
      //telemetry.addData("Target Position:", buzz.getTargetPosition());
    }
}
