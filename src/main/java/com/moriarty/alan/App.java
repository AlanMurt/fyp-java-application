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

      //Welcome message
      System.out.println("Welcome to OpenCV " + Core.VERSION);

      //Instantiate and start cameras
      Camera cam1 = new Camera(0);
      Camera cam2 = new Camera(1);
      System.out.println(cam1.start());
      System.out.println(cam2.start());

      //Create a Mat object to act as the container for the image/frame
      Mat frame = new Mat();

     //Create two lists of type Mat, one for each camera to store the images/frames
      List<Mat> list1 = new ArrayList<Mat>();
      List<Mat> list2 = new ArrayList<Mat>();

      for (int i = 0; i <= 30; i++) {

          list1.add(cam1.readOneFrame());

      }

      for (int p = 0; p <= 30; p++) {

          list2.add(cam2.readOneFrame());
      }


      for(int j = 0; j <list1.size();j++) {
          Mat temp1Frame = new Mat();
          Imgproc.cvtColor( list1.get(j), temp1Frame, Imgproc.COLOR_RGB2GRAY);
          list1.set( j , temp1Frame);
          Imgcodecs.imwrite("images/image1 + " + j + ".jpg", list1.get(j));
      }

      for(int q = 0; q <list2.size();q++) {
          Mat temp2Frame = new Mat();
          Imgproc.cvtColor( list2.get(q), temp2Frame, Imgproc.COLOR_RGB2GRAY);
          list2.set( q , temp2Frame);
          Imgcodecs.imwrite("images/image2 + " + q + ".jpg", list2.get(q));
      }

      System.out.println("Done");
  }
}