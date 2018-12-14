package org.firstinspires.ftc.teamcode;

public class Outtake{
  double servoChange = 0;
  public static final double SERVO_SPEED = 0.001;
  //public static final double ;
  public void update(){
    //Color Sensor and Sorting System
  }

  public void setAnglePower(DeviceHandler dh, double power){
    servoChange = power * SERVO_SPEED;
    dh.moveToPosition(1, dh.getServoPosition(1) - servoChange);
    dh.moveToPosition(2, dh.getServoPosition(2) + servoChange);
    //return (String) (dh.getServoPosition(1) + "+" +  dh.getServoPosition(2));
  }

  public void setUnfoldPower(DeviceHandler dh, double power){

  }
}
