package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class TylerMotor{
    public DcMotor motorID = null;
    int doubleCall = 0;
    public TylerMotor(DcMotor m){
        motorID = m;
    }

    public void reverse(){
      motorID.setDirection(DcMotor.Direction.REVERSE);
    }

    public void initialize(){
      /*
        try{
            motorID.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorID.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }catch(Exception e){
            throw new Exception("Problem During Motor Initialization");
        }
        */
        motorID.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorID.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void turnOn(double power){
        /*
        try{
            motorID.setPower(power);
        }catch(Exception e){
            throw new Exception("Problem Setting Motor Power");
        }
        */
        motorID.setPower(power);
        doubleCall = (int)(10* power);
    }

    public int getDoubleCall(){
      return doubleCall;
    }

    public int getEncoder() throws Exception{
        try{
            return motorID.getCurrentPosition();
        }catch(Exception e){
            throw new Exception("Problem Getting Motor Encoder Values");
        }
    }
}
