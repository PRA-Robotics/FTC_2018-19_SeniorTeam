package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;

public class DeviceHandler{
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private static final double POWER = 1;
    public void init(HardwareMap hw){
       leftDrive = hw.get(DcMotor.class, "leftMotor");
       leftDrive.setDirection(DcMotor.Direction.REVERSE);
       rightDrive = hw.get(DcMotor.class, "rightMotor");
       rightDrive.setDirection(DcMotor.Direction.FORWARD);
       initMotor(leftDrive);
       initMotor(rightDrive);
       leftDrive.setTargetPosition(0);
       rightDrive.setTargetPosition(0);
    }

    private void initMotor(DcMotor m){
      m.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      m.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void moveTicks(int m, int ticks){//0 is left drive, 1 is right
      switch(m){
        case 0:
          leftDrive.setTargetPosition(leftDrive.getTargetPosition() + ticks);
          leftDrive.setPower(0.1);
          break;
        case 1:
          rightDrive.setTargetPosition(rightDrive.getTargetPosition() + ticks);
          rightDrive.setPower(0.1);
          break;
      }
    }

    public void runMotorsToTargets(){
      leftDrive.setPower(POWER);
      rightDrive.setPower(POWER);
      while(!shouldMoveOn(0) || !shouldMoveOn(1)){

      }
      leftDrive.setPower(0);
      rightDrive.setPower(0);
    }

    public boolean shouldMoveOn(int m){
      boolean returnVal;
      switch(m){
        case 0:
          returnVal = (10 < Math.abs(leftDrive.getCurrentPosition() - leftDrive.getTargetPosition()));
          break;
        case 1:
          returnVal = (10 < Math.abs(rightDrive.getCurrentPosition() - rightDrive.getTargetPosition()));
          break;
        default:
          returnVal = true;
      }
      return returnVal;
    }
    //motor outtakeBelt = new motor(hardwareMap.get("outtakeBelt"));
    //motor outtakeActuator = new motor(hardwareMap.get("outtakeActuator"));
    //motor intakeSpin = new motor(hardwareMap.get("intakeSpin"));
    //motor intakeMove = new motor(hardwareMap.get("intakeMove"));
}
