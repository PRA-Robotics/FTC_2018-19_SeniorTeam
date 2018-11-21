package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;

public class DeviceHandler{
    public static TylerMotor leftDrive = null;
    public static TylerMotor rightDrive = null;
    public void init(HardwareMap hw){
       leftDrive = new TylerMotor(hw.get(DcMotor.class, "leftMotor"));
       rightDrive = new TylerMotor(hw.get(DcMotor.class, "rightMotor"));
    }
    //motor outtakeBelt = new motor(hardwareMap.get("outtakeBelt"));
    //motor outtakeActuator = new motor(hardwareMap.get("outtakeActuator"));
    //motor intakeSpin = new motor(hardwareMap.get("intakeSpin"));
    //motor intakeMove = new motor(hardwareMap.get("intakeMove"));
}
