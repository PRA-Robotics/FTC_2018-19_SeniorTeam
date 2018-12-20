package org.firstinspires.ftc.teamcode;

public class Intake{
    public static final double SPIN_POWER = 0.5;
    double servoPosition = 0;
    public static final double SERVO_SPEED = 0.01;
    public void init(DeviceHandler dh){
      servoPosition = dh.getServoPosition(0);
    }

    public void spinOn(DeviceHandler dh){
      dh.moveMotor(3, SPIN_POWER);
    }

    public void spinOff(DeviceHandler dh){
      dh.moveMotor(3, 0);
    }

    public void rotateIntake(DeviceHandler dh, double powerUp, double powerDown){
      if(powerUp > 0){
        servoPosition = powerUp * SERVO_SPEED;
      } else {
        servoPosition = -powerDown * SERVO_SPEED;
      }
      dh.moveToPosition(0, servoPosition);
    }

    public double getPosition(DeviceHandler dh){
      return dh.getServoPosition(0);
    }

    public double getTargetPosition(){
      return servoPosition;
    }

    public void fish(DeviceHandler dh, double power){
      servoPosition += power * SERVO_SPEED * 2;
      dh.moveToPosition(1,servoPosition);
    }

    public void open(DeviceHandler dh, double power){
      servoPosition += power * SERVO_SPEED;
      dh.moveToPosition(2,servoPosition);
    }
  }
