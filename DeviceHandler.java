package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;

public class DeviceHandler{
    private Servo[] servos = new Servo[0];
    private DcMotor[] motors = new DcMotor[2];
    private static final double POWER = 0.3;
    public void init(HardwareMap hw, int mode){//mode represents Autonomous(0) or Teleop(1)
       motors[0] = hw.get(DcMotor.class, "leftOuttakeMotor");
       motors[1] = hw.get(DcMotor.class, "rightOuttakeMotor");
       motors[2] = hw.get(DcMotor.class, "actuatorMotor");
       //motors[2] = hw.get(DcMotor.class, "extendingMotor");
       //motors[3] = hw.get(DcMotor.class, "intakeMotor");
       //servos[0] = hw.get(Servo.class, "intakeServo");
       //servos[1] = hw.get(Servo.class, "outakeServoL");
       //servos[2] = hw.get(Servo.class, "outakeServoR");
       //motors[0].setDirection(DcMotor.Direction.REVERSE);
       //motors[1].setDirection(DcMotor.Direction.FORWARD);

       for(int i = 0; i < motors.length; i++){
         motors[i].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
         motors[i].setTargetPosition(0);
       }

       motors[0].setMode(DcMotor.RunMode.RUN_TO_POSITION);
       motors[1].setMode(DcMotor.RunMode.RUN_TO_POSITION);
       motors[2].setMod(DcMotor.RunMode.RUN_TO_POSITION);
       //motors[2].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       //motors[2].setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void moveToPosition(int s, double position){
      servos[s].setPosition(position);
    }

    public void moveTicks(int m, int ticks){//0 is left drive, 1 is right
      motors[m].setTargetPosition(motors[m].getTargetPosition() + ticks);
    }

    public double getServoPosition(int s){
      return servos[s].getPosition();
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
