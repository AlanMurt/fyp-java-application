package com.moriarty.alan;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import java.awt.*;

public class Camera {

    private VideoCapture cam;
    private Mat test;
    private int cameraNumber;

    public Camera(int cameraNumber){
        this.cameraNumber = cameraNumber;
        this.cam = new VideoCapture(this.cameraNumber);
    }


    public String start(){

        cam.open(this.cameraNumber);
        if(cam.isOpened()){
            return "Camera " + this.cameraNumber + ": Working.";
        }
        else{
            return "Camera " + this.cameraNumber + ": Error.";
            }
        }


    public Mat readOneFrame(){

        //Create Mat object to store frame
        Mat frame = new Mat();

        //Store frame from Camera in a Mat Object
        cam.read(frame);

        return frame;

    }

}
