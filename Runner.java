package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

@Autonomous(name="Autonomous")

public class Runner extends LinearOpMode{
    public static TensorFlow yan = new TensorFlow();
    public static DeviceHandler foo = new DeviceHandler();
    public static Drive bar = new Drive();

    @Override
    public void runOpMode(){
      foo.init(hardwareMap, 0);
      yan.init(hardwareMap);
      waitForStart();
      int gold = -1;
      while(gold == -1){
        gold = yan.findGold();
        telemetry.addData("Location:", gold);
        telemetry.update();
      }
      yan.shutdown();
      //Code goes here
    }
}
