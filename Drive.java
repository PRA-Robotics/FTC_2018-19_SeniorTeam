package org.firstinspires.ftc.teamcode;

public class Drive{
    public static final double DISTANCE_BETWEEN_WHEELS = 42.6;
    public static final double WHEEL_DIAMETER = 9.9;
    public static final int ENCODER_TICKS = 1120;

    public static void forward(double distance, DeviceHandler dh){//cm
        double rotations = (distance/(Math.PI * WHEEL_DIAMETER));
        int numTicks = (int)(rotations * ENCODER_TICKS);
        dh.moveTicks(0, -numTicks);
        dh.moveTicks(1, numTicks);
        dh.runMotorsToTargets();
    }

    public void turn(double degrees, DeviceHandler dh){
       double rotations = (DISTANCE_BETWEEN_WHEELS * degrees)/(360 * WHEEL_DIAMETER);
       int numTicks = (int)(rotations * ENCODER_TICKS);
       dh.moveTicks(0, numTicks);
       dh.moveTicks(1, numTicks);
       dh.runMotorsToTargets();
    }
}
