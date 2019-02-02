package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

@Autonomous(name="Depot")

public class Runner extends LinearOpMode{
    public static TensorFlow yan = new TensorFlow();
    public static DeviceHandler foo = new DeviceHandler();
    public static Drive bar = new Drive();

    @Override
    public void runOpMode(){
      foo.init(hardwareMap, 0);
      yan.init(hardwareMap);
      waitForStart();
      foo.moveMotor(6, 1);
      sleep(10000);//14000
      foo.moveMotor(6, 0);
      //foo.moveMotor(6, 1);
      //sleep(14000);
      //foo.moveMotor(6, 0);
      //bar.turn(90, foo);
      /*
      int gold = -1;
      while(gold == -1){
        gold = yan.findGold();
        telemetry.addData("Location:", gold);
        telemetry.update();
      }
      yan.shutdown();
      */
      /*
      bar.turn(10, foo);
      bar.forward((gold - 1) * 39, foo);
      bar.turn(-90, foo);
      bar.forward(10, foo);
      bar.turn(90, foo);
      bar.forward(-(gold - 1) * 39, foo);
      bar.turn(-90, foo);
      */
      //blah blah blah
      /*
      bar.turn(70,foo);
      bar.forward(85,foo);
      bar.turn(-80,foo);
      bar.forward(139,foo);
      bar.forward(-150,foo);
      */
    }
}
