
public class drive{
    public static final double DISTANCE_BETWEEN_WHEELS = 1;
    public static final double WHEEL_DIAMETER = 1;
    public static final int ENCODER_TICKS = 720; //?
    public drive(){

    }

    public void TurnOn(double power){
        //deviceHandler.leftDrive.turnOn(power);
        //deviceHandler.rightDrive.turnOn(power);
    }

    public void turn(double degrees){
       double rotations = (WHEEL_DIAMETER * degrees)/(360 * DISTANCE_BETWEEN_WHEELS);
       int numTicks = (int)(rotations * ENCODER_TICKS);
    }
}
