package org.firstinspires.ftc.teamcode;

public class Outtake{
  double motorChange = 0;
  public static final double MOTOR_SPEED = 1;
  //public static final double ;
  public void update(){
    //Color Sensor and Sorting System
  }

  public void setAnglePower(DeviceHandler dh, double power){
    //motorChange += power * MOTOR_SPEED;
    dh.moveMotor(3, power);
    dh.moveMotor(4, power);
    //return (String) (dh.getServoPosition(1) + "+" +  dh.getServoPosition(2));
  }

  public void extend(DeviceHandler dh, double powerUp, double powerDown){
    //dh.moveMotor(6, powerUp - powerDown);
  }

  public void setUnfoldPower(DeviceHandler dh, double power){
    double unfoldPower = power * MOTOR_SPEED;
    /*dh.movrTicks(4, unfoldPower);
    dh.runMotorsToTargets();*/
    //return (String) (dh.getMotorPosition(4));
  }
}
