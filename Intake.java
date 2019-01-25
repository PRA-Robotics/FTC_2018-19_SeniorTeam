package org.firstinspires.ftc.teamcode;

public class Intake{
    public static final double SPIN_POWER = 1;
    double servoChange = 0;
    public static final double SERVO_SPEED = 0.001;

    public void spinOn(DeviceHandler dh){
      dh.moveMotor(5, -1);
    }

    public void spinOff(DeviceHandler dh){
      dh.moveMotor(5, 0);
    }

    public void rotateIntake(DeviceHandler dh, double power){
      dh.changeServoPosBy(0, power * SERVO_SPEED);
      dh.changeServoPosBy(1, -power * SERVO_SPEED);
    }

    public void fish(DeviceHandler dh, double power){
      dh.continousServoPower(0, (power*0.7));
    }

    public void angleNet(DeviceHandler dh, double power){
      dh.setServoPosition(2, (power/2) + 0.5);
    }
  }
