package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

@Autonomous(name="Crater")

public class Runner2 extends LinearOpMode{
    public static TensorFlow yan = new TensorFlow();
    public static DeviceHandler foo = new DeviceHandler();
    public static Drive bar = new Drive();

    @Override
    //work or i will murder you
    public void runOpMode(){
      yan.init(hardwareMap);
      waitForStart();
      foo.moveMotor(6, 1);
      sleep(14000);
      foo.moveMotor(6, 0);
      bar.forward(-10, foo);
      bar.turn(-10, foo);
      int gold = -1;
      while(gold == -1){
        gold = yan.findGold();
        telemetry.addData("It there:", gold);
        telemetry.update();
      }
      yan.shutdown();
      bar.turn(10, foo);
      bar.forward((gold - 1) * 39, foo);
      bar.turn(-90, foo);
      bar.forward(10, foo);
      bar.turn(90, foo);
      bar.forward(-(gold - 1) * 39, foo);
      bar.turn(-90, foo);
      bar.turn(-90,foo);
      bar.forward(110,foo);
      bar.turn(45,foo);
      bar.forward(139,foo);
      bar.forward(-150,foo);
    }
}
