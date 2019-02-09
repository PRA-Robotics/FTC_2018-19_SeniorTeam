package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;

public class DeviceHandler{
    private Servo[] servos = new Servo[3];
    private DcMotor[] motors = new DcMotor[8];
    private CRServo[] crservos = new CRServo[4];
    private double motorPower = 0;
    public void init(HardwareMap hw, int mode){//mode represents Autonomous(0) or Teleop(1)
       motors[0] = hw.get(DcMotor.class, "leftDrive");
       motors[1] = hw.get(DcMotor.class, "rightDrive");
       motors[2] = hw.get(DcMotor.class, "beltRotate");
       motors[3] = hw.get(DcMotor.class, "leftOuttake");
       motors[4] = hw.get(DcMotor.class, "rightOuttake");
       motors[5] = hw.get(DcMotor.class, "intakeMotor");
       motors[6] = hw.get(DcMotor.class, "hangingMotor");
       motors[7] = hw.get(DcMotor.class, "extendingMotor");
       servos[0] = hw.get(Servo.class, "intakeRotationLeft");
       servos[1] = hw.get(Servo.class, "intakeRotationRight");
       servos[2] = hw.get(Servo.class, "marker");
       //servos[2] = hw.get(Servo.class, "netAngleServo");
       //servos[3] = hw.get(Servo.class, "unfoldingServo");
       //crservos[0] = hw.get(CRServo.class, "netRotation");
       crservos[0] = hw.get(CRServo.class, "unfoldLeft");
       crservos[1] = hw.get(CRServo.class, "unfoldRight");
       crservos[2] = hw.get(CRServo.class, "shovel");
       crservos[3] = hw.get(CRServo.class, "shovel2");
       for(int i = 0; i < motors.length; i++){
         motors[i].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
         motors[i].setTargetPosition(0);
       }
       //THIS IS IMPORTANT!!!
       if(mode == 0){
         motors[0].setMode(DcMotor.RunMode.RUN_TO_POSITION);
         motors[1].setMode(DcMotor.RunMode.RUN_TO_POSITION);
       }else{
         motors[0].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
         motors[1].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       }
       motors[5].setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
       motors[6].setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
       motors[7].setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
       motors[4].setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
       motors[3].setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
       motors[2].setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
       motors[0].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
       motors[1].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
       motors[3].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
       motors[4].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
       setServoPosition(0, 0.5106);
       setServoPosition(1, 0.4739);
    }

    public double getMotorPower(int m){
      return motors[m].getPower();
    }

    public void changeServoPosBy(int s, double position){
      servos[s].setPosition(servos[s].getPosition() + position);
    }

    public void moveTicks(int m, int ticks){//0 is left drive, 1 is right
      motors[m].setTargetPosition(motors[m].getTargetPosition() + ticks);
    }

    public void continousServoPower(int s, double power){
      crservos[s].setPower(power);
    }

    public void setServoPosition(int s, double position){
      servos[s].setPosition(position);
    }

    public double getServoPosition(int s){
      return servos[s].getPosition();
    }

    public double getMotorPosition(int m){
      return motors[m].getCurrentPosition();
    }

    public void runMotorsToTargets(int stupid){
      motorPower = 0;
      while(!shouldMoveOn()){
        if(motorPower < 0.5){
          motorPower += 0.01;
        }
        if(stupid == 1){
          motors[0].setPower(motorPower);
          if(true){
            motors[1].setPower(motorPower+0.1);
          }else{
            motors[1].setPower(motorPower);
          }
        }else if(stupid == 2){
          motors[1].setPower(motorPower);
          if(true){
            motors[0].setPower(motorPower+0.25);
          }else{
            motors[0].setPower(motorPower);
          }
        }else{
          for(int i = 0; i < 2; i++){
            motors[i].setPower(motorPower);
          }
        }
      }
      for(int i = 0; i < 2; i++){
        motors[i].setPower(0);
      }
      /*
      for(int i = 0; i < 2; i++){
        motors[i].setPower(0.5);
      }
      while(!shouldMoveOn()){

      }
      for(int i = 0; i < 2; i++){
        motors[i].setPower(0);
      }
      */
    }

    public boolean shouldMoveOn(){
      for(int i = 0; i < 2; i++){
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
