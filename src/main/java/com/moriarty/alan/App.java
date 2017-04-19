package com.moriarty.alan;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.CvType;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import java.util.ArrayList;
import java.util.List;

public class App
{
  static{ System.loadLibrary("target/natives/opencv_java300"); }

  public static void main(String[] args) {

      System.out.println("Welcome to OpenCV " + Core.VERSION);

      VideoCapture webcam = new VideoCapture(0);
      webcam.open(0);
      if (webcam.isOpened()) {
          System.out.println("Camera Working");


          List<Mat> list = new ArrayList<Mat>();

          //Mat is the container for the image
          Mat frame = new Mat();

          for (int i = 0; i <= 30; i++) {
              //stores frame taken in mat container
              webcam.read(frame);
              //converts frame to gray
              Imgproc.cvtColor(frame, frame, Imgproc.COLOR_RGB2GRAY);
              // Imgcodecs.imwrite("frameCaptured" + i + ".jpg", grayFrame);
              list.add(frame);
          }


          Mat diffFrame = new Mat();

          Core.subtract(list.get(1), list.get(0), diffFrame);
          Imgcodecs.imwrite("images/diffFrame.jpg", diffFrame);


      } else {
          System.out.println("Camera Error");
      }



      //Highgui - High level GUI media input and output
      //Highgui.imwrite("frameCaptured.jpg", frame);
      System.out.println("OK");
  }
}