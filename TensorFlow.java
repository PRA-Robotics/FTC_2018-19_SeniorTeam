/* Copyright (c) 2018 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;
import java.util.List;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

public class TensorFlow{
    private static final String TFOD_MODEL_ASSET = "RoverRuckus.tflite";
    private static final String LABEL_GOLD_MINERAL = "Gold Mineral";
    private static final String LABEL_SILVER_MINERAL = "Silver Mineral";

    private static final String VUFORIA_KEY = "AXs1rYv/////AAAAGbV7hdUOV0FzqZxxpYmdgBVclCGOL6r7xpAKtArteRkKfNWZMHVfHPVDUVJ5OeFOC5yhzlMSwSZLX0m4ypOUq6JHS6DjcVjW34B4GXnE7zD1brWZ2WtCEpekJFfJGaUNZYkrA4LpAAXYD406YnWkh5QPn8WsMr8H8UjFXxsep/m6hC89X42b6iSssviRoJsHuFexeXuHzr9xJ9DJWjBQ2sVxWLLxSrVnzVn40KjcIK3z8TVwIzmFExKIiJeeFS9rri5lv3+4Gvk7Le9OUsLf5xRk201pvoR1QprB7eqFaM7ATvaViR3vj4Ke1x8Sx5EqG+QBB2f0HIqMKH0xv7VuaTljMNCle4pPSK5ZDsHMw4mv";

    private VuforiaLocalizer vuforia;

    private TFObjectDetector tfod;

    public void init(HardwareMap hardwareMap){
      VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

      parameters.vuforiaLicenseKey = VUFORIA_KEY;
      parameters.cameraDirection = CameraDirection.BACK;

      vuforia = ClassFactory.getInstance().createVuforia(parameters);

      if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_GOLD_MINERAL, LABEL_SILVER_MINERAL);
      }
    }

    public int findGold() {
        if (tfod != null) {
            tfod.activate();
        }

        if (tfod != null) {
          List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
          if (updatedRecognitions != null) {
            if (updatedRecognitions.size() == 2) {
              if(updatedRecognitions.get(0).getLabel().equals(LABEL_GOLD_MINERAL)){
                tfod.shutdown();
                return 0;
              }else if(updatedRecognitions.get(1).getLabel().equals(LABEL_GOLD_MINERAL)){
                tfod.shutdown();
                return 1;
              }else{
                tfod.shutdown();
                return 2;
              }
            }
            tfod.shutdown();
            return -1;
          }
        }
    }
}
