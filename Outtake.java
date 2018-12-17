package org.firstinspires.ftc.teamcode;

public class Outtake{
  double motorChange = 0;
  public static final double MOTOR_SPEED = 0.001;
  //public static final double ;
  public void update(){
    //Color Sensor and Sorting System
  }

  public void setAnglePower(DeviceHandler dh, double power){
    motorChange = power * MOTOR_SPEED;
    dh.moveTicks(0, motorChange);
    dh.moveTicks(1, -motorChange);
    dh.runMotorsToTargets();
    //return (String) (dh.getServoPosition(1) + "+" +  dh.getServoPosition(2));
  }

  public void extend(DeviceHandler dh, double powerUp, double powerDown){
    if(powerUp > 0){
      motorChange = power * MOTOR_SPEED;
    }else{
      motorChange = -power * MOTOR_SPEED;
    }
    dh.moveTicks(2, motorChange);
    dh.runMotorsToTargets();
  }

  public void setUnfoldPower(DeviceHandler dh, double power){

  }
}
