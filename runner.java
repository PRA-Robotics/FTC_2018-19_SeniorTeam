package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.hardware.*;

@Autonomous(name="runner")

public class runner extends OpMode{
    public static DeviceHandler foo = new DeviceHandler();
    public static drive bar = new drive();
    @Override
    public void init(){
      foo.init(hardwareMap);
    }

    @Override
    public void start(){
      bar.Turn(90, foo);
    }

    @Override
    public void loop(){
      
    }
}
