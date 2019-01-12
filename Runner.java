package org.firstinspires.ftc.teamcode;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
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
      while(opModeIsActive()){
        //bar.Turn(90, foo);
        //bar.Forward(25, foo);
        telemetry.addData("Location:", yan.findGold());
        telemetry.update();
      }
    }
}
