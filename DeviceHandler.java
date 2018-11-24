package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;

public class DeviceHandler{
    private DcMotor[] motors = new DcMotor[2];
    private static final double POWER = 0.3;
    public void init(HardwareMap hw){
       motors[0] = hw.get(DcMotor.class, "leftMotor");
       motors[1] = hw.get(DcMotor.class, "rightMotor");
       motors[0].setDirection(DcMotor.Direction.REVERSE);
       motors[1].setDirection(DcMotor.Direction.FORWARD);
       for(int i = 0; i < motors.length; i++){
         initMotor(motors[i]);
         motors[i].setTargetPosition(0);
       }
    }

    private void initMotor(DcMotor m){
      m.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      m.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void moveTicks(int m, int ticks){//0 is left drive, 1 is right
      motors[m].setTargetPosition(motors[m].getTargetPosition() + ticks);
    }

    public void runMotorsToTargets(){
      for(int i = 0; i < motors.length; i++){
        motors[i].setPower(POWER);
      }
      while(!shouldMoveOn()){

      }
      for(int i = 0; i < motors.length; i++){
        motors[i].setPower(0);
      }
    }

    public boolean shouldMoveOn(){
      for(int i = 0; i < motors.length; i++){
        if(motors[i].isBusy()){
          return false;
        }
      }
      return true;
    }

    public void moveMotor(int m, double p){
      motors[m].setPower(p);
    }
}
