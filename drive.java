package org.firstinspires.ftc.teamcode;

//import deviceHandler;
public class drive{
    public static final double DISTANCE_BETWEEN_WHEELS = 16.5;
    public static final double WHEEL_DIAMETER = 3.875;
    public static final int ENCODER_TICKS = 1120;

    public drive(){

    }

    public static void Forward(double power, DeviceHandler dh){
        //dh.turnOn(0, power);
        //dh.turnOn(1, power);
    }

    public void Turn(double degrees, DeviceHandler dh){
       double rotations = (DISTANCE_BETWEEN_WHEELS * degrees)/(360 * WHEEL_DIAMETER);
       int numTicks = (int)(rotations * ENCODER_TICKS);
       dh.moveTicks(0, -numTicks);
       dh.moveTicks(1, numTicks);
       //dh.runMotorsToTargets();
    }

}
