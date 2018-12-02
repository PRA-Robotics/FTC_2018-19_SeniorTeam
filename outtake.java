package org.firstinspires.ftc.teamcode;

public class Outtake{
  double servoPosition = 0;
  public static final double SERVO_SPEED = 0.1;
  public void update(){
    //Color Sensor and Sorting System
  }

  public void setExtendPower(DeviceHandler dh, double power){
    servoPosition += power * SERVO_SPEED;
    dh.moveToPosition(1, servoPosition);
    dh.moveToPosition(2, servoPosition);
  }

  public void setUnfoldPower(){

  }
}
