package org.firstinspires.ftc.teamcode;

public class Outtake{
  double motorChange = 0;
  public static final double MOTOR_SPEED = 1;
  public void update(){
    //Color Sensor and Sorting System
  }

  public void setAnglePower(DeviceHandler dh, double power){
    dh.moveMotor(3, power*0.5);
    dh.moveMotor(4, power*0.5);
  }

  public void extend(DeviceHandler dh, double power){
    dh.moveMotor(7, power);
  }

  public void setUnfoldPower(DeviceHandler dh, double power){
      dh.continousServoPower(0, (power/2));
      dh.continousServoPower(1, (-power/2));
      //dh.continousServoPower(1, -1);
  }
}
