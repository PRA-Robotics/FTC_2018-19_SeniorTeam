package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;

public class DeviceHandler{
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    public void init(HardwareMap hw){
       leftDrive = hw.get(DcMotor.class, "leftMotor");
       leftDrive.setDirection(DcMotor.Direction.FORWARD);
       rightDrive = hw.get(DcMotor.class, "rightMotor");
       rightDrive.setDirection(DcMotor.Direction.REVERSE);
       initMotor(leftDrive);
       initMotor(rightDrive);
    }

    private void initMotor(DcMotor m){
      m.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      m.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void turnOn(int m, double power){//0 is left drive, 1 is right
      switch(m){
        case 0:
          leftDrive.setPower(power);
          break;
        case 1:
          rightDrive.setPower(power);
          break;
      }
    }
    //motor outtakeBelt = new motor(hardwareMap.get("outtakeBelt"));
    //motor outtakeActuator = new motor(hardwareMap.get("outtakeActuator"));
    //motor intakeSpin = new motor(hardwareMap.get("intakeSpin"));
    //motor intakeMove = new motor(hardwareMap.get("intakeMove"));
}
