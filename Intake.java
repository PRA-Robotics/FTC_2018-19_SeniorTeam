package org.firstinspires.ftc.teamcode;

public class Intake{
    public static final double SPIN_POWER = 0.5;
    double servoPosition = 0;
    public static final double SERVO_SPEED = 0.1;
    public void init(DeviceHandler dh){
      servoPosition = dh.getServoPosition(0);
    }

    public void spinOn(DeviceHandler dh){
      dh.moveMotor(3, SPIN_POWER);
    }

    public void spinOff(DeviceHandler dh){
      dh.moveMotor(3, 0);
    }

    public void rotateIntake(DeviceHandler dh, double power){
      servoPosition += power * SERVO_SPEED;
      dh.moveToPosition(0, servoPosition);
    }
}
