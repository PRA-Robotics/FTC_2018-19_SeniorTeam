package org.firstinspires.ftc.teamcode;

public class Intake{
    public static final double SPIN_POWER = 0.5;
    double servoPosition = 0;
    public static final double SERVO_SPEED = 0.1;
    public void spinOn(DeviceHandler dh){
      dh.moveMotor(3, SPIN_POWER);
    }

    public void spinOff(){
      dh.moveMotor(3, 0);
    }

    public void rotateIntake(DeviceHandler dh, double power){
      position += power * SERVO_SPEED;
      dh.moveToPosition(0, position);
    }
}
