import com.qualcomm.robotcore.hardware.*;

public class motor{
    DcMotor motorID;
    public motor(DcMotor m){
        motorID = m;
    }

    public void initialize() throws Exception{
        try{
            motorID.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorID.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }catch(Exception e){
            throw new Exception("Problem During Motor Initialization");
        }
    }

    public void turnOn(double power) throws Exception{
        try{
            motorID.setPower(power);
        }catch(Exception e){
            throw new Exception("Problem Setting Motor Power");
        }
    }

    public int getEncoder() throws Exception{
        try{
            return motorID.getCurrentPosition();
        }catch(Exception e){
            throw new Exception("Problem Getting Motor Encoder Values");
        }
    }
}
