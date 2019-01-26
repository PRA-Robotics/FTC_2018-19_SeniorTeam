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
      lightyear.setUnfoldPower(foo, (gamepad1.dpad_left ? 1 : 0) - (gamepad1.dpad_right ? 1 : 0));
      lightyear.extend(foo, (gamepad1.left_bumper ? 1 : 0) - (gamepad1.right_bumper ? 1 : 0));
      telemetry.addData("Servo Position 0:", foo.getServoPosition(0));
      telemetry.addData("Servo Position 1:", foo.getServoPosition(1));
      telemetry.update();
      if(gamepad1.a){
        foo.moveMotor(2, -1);
      }
      else if(gamepad1.y){
        foo.moveMotor(2,1);
      }else{
        foo.moveMotor(2, 0);
      }

      if(gamepad1.x){
        foo.moveMotor(6, 1);
      }else if(gamepad1.b){
        foo.moveMotor(6, -1);
      }else{
        foo.moveMotor(6, 0);
      }

      //Switches from gamepad 1 to gamepad 2

      buzz.angleNet(foo, gamepad2.right_stick_y);
      buzz.rotateIntake(foo, gamepad2.right_trigger - gamepad2.left_trigger);
      buzz.fish(foo, gamepad2.left_stick_y);

      if(gamepad2.a){
        buzz.spinOn(foo);
      }else{
        buzz.spinOff(foo);
      }
    }
}
