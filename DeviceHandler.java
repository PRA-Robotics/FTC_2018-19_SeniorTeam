package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;

public class DeviceHandler{
    private Servo[] servos = new Servo[4];
    private DcMotor[] motors = new DcMotor[8];
    private CRServo[] crservos = new CRServo[1];
    private static final double POWER = 0.3;
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
       servos[2] = hw.get(Servo.class, "netAngleServo");
       servos[3] = hw.get(Servo.class, "unfoldingServo");
       crservos[0] = hw.get(CRServo.class, "netRotation");
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
       motors[4].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       motors[3].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       motors[2].setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
       motors[3].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
       motors[4].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
       setServoPosition(0, getServoPosition(0));
       setServoPosition(3, 0);
       setServoPosition(1, getServoPosition(1));
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

    public void runMotorsToTargets(){
      for(int i = 0; i < 2; i++){
        motors[i].setPower(POWER);
      }
      while(!shouldMoveOn()){

      }
      for(int i = 0; i < 2; i++){
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
