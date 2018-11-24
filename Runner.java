package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

@Autonomous(name="Autonomous")

public class Runner extends LinearOpMode{
    public static DeviceHandler foo = new DeviceHandler();
    public static drive bar = new drive();

    @Override
    public void runOpMode(){
      foo.init(hardwareMap);
      waitForStart();
      while(opModeIsActive()){
        bar.Turn(90, foo);
        bar.Forward(25, foo);
      }
    }
}
