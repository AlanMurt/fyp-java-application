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

      VideoCapture webcam1 = new VideoCapture(0);
          webcam1.open(0);
          if (webcam1.isOpened()) {
              System.out.println("Camera 1 Working");

              VideoCapture webcam2 = new VideoCapture(0);
              webcam2.open(1);
              if (webcam2.isOpened()) {
                  System.out.println("Camera 2 Working");


                  List<Mat> list1 = new ArrayList<Mat>();
                  List<Mat> list2 = new ArrayList<Mat>();

                  //Mat is the container for the image
                  Mat frame = new Mat();

          for (int i = 0; i <= 30; i++) {
              //stores frame taken in mat container
              webcam1.read(frame);
              //converts frame to gray
              Imgproc.cvtColor(frame, frame, Imgproc.COLOR_RGB2GRAY);
              // Imgcodecs.imwrite("frameCaptured" + i + ".jpg", grayFrame);
              list1.add(frame);
              Imgcodecs.imwrite("images/image + " + i + ".jpg", list1.get(i) );
          }

                  for (int j = 0; j <= 30; j++) {
                      //stores frame taken in mat container
                      webcam2.read(frame);
                      //converts frame to gray
                      Imgproc.cvtColor(frame, frame, Imgproc.COLOR_RGB2GRAY);
                      // Imgcodecs.imwrite("frameCaptured" + i + ".jpg", grayFrame);
                      list2.add(frame);
                      Imgcodecs.imwrite("images/image + " + j + ".jpg", list2.get(j) );
                  }

/*
          Mat diffFrame = new Mat();

          Core.subtract(list.get(1), list.get(0), diffFrame);
          */
         // Imgcodecs.imwrite("images/diffFrame.jpg", list.get(1) );


              }} else {
          System.out.println("Camera Error");
      }



      //Highgui - High level GUI media input and output
      //Highgui.imwrite("frameCaptured.jpg", frame);
      System.out.println("OK");
  }
}