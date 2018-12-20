package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;

public class DeviceHandler{
    private Servo[] servos = new Servo[3];
    private DcMotor[] motors = new DcMotor[2];
    private static final double POWER = 0.3;
    public void init(HardwareMap hw, int mode){//mode represents Autonomous(0) or Teleop(1)
       motors[0] = hw.get(DcMotor.class, "leftOuttake");
       motors[1] = hw.get(DcMotor.class, "rightOuttake");
       //motors[2] = hw.get(DcMotor.class, "actuatorMotor");
       //motors[2] = hw.get(DcMotor.class, "extendingMotor");
       //motors[3] = hw.get(DcMotor.class, "intakeMotor");
       //motors[4] = hw.get(DcMotor.class, "elbowMotor");
       servos[0] = hw.get(Servo.class, "intakeRotation");
       servos[1] = hw.get(Servo.class, "netRotation");
       //servos[2] = hw.get(Servo.class, "netAngleServo");
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
       //motors[2].setMod(DcMotor.RunMode.RUN_TO_POSITION);
       //motors[2].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       //motors[2].setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void moveToPosition(int s, double position){
      servos[s].setPosition(position);
    }

    public void moveTicks(int m, double ticks){//0 is left drive, 1 is right
      motors[m].setTargetPosition(motors[m].getTargetPosition() + (int)ticks);
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
