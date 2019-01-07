package org.firstinspires.ftc.teamcode;

public class Intake{
    public static final double SPIN_POWER = 1;
    double servoChange = 0;
    public static final double SERVO_SPEED = 0.001;

    public void spinOn(DeviceHandler dh){
      dh.moveMotor(5, SPIN_POWER);
    }

    public void spinOff(DeviceHandler dh){
      dh.moveMotor(5, 0);
    }

    public void rotateIntake(DeviceHandler dh, double powerUp, double powerDown){
      dh.changeServoPosBy(0, (powerUp - powerDown) * SERVO_SPEED);
    }

    public void fish(DeviceHandler dh, double power){
      dh.continousServoPower(1, (power/2) + 0.5);
    }

    public void angleNet(DeviceHandler dh, double power){
      dh.continousServoPower(2, (power/2) + 0.5);
    }
  }
