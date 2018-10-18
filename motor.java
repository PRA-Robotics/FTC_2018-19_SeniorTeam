import com.qualcomm.robotcore.hardware.*;

public class motor{
    DcMotor motorID;
    public motor(DcMotor m){
        motorID = m;
    }

    public void initialize(){
        try{
            motorID.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorID.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }catch(Exception e){
            throw new Exception("Problem During Motor Initialization");
        }
    }

    public void turnOn(double power){
        try{
            motorID.setPower(power);
        }catch(Exception e){
            throw new Exception("Problem Setting Motor Power");
        }
    }

    public void getEncoder(){
        try{
            motorID.getCurrentPosition();
        }catch(Exception e){
            throw new Exception("Problem Getting Motor Encoder Values");
        }
    }
}
