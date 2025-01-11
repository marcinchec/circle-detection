package org.example;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class CircleDetection {

    public void detectCircle() {
        Mat image = Imgcodecs.imread("in.png");

        Mat grayImage = new Mat();
        Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY);

        Mat blurredImage = new Mat();
        Imgproc.GaussianBlur(grayImage, blurredImage, new Size(3, 3), 2,2);

        Mat circles = new Mat();
        Imgproc.HoughCircles(blurredImage, circles, Imgproc.HOUGH_GRADIENT, 1, 100, 100, 30, 130, 140);

        if (circles.cols() > 0) {
            double[] circle = circles.get(0, 0);
            Point center = new Point(Math.round(circle[0]), Math.round(circle[1]));
            Imgproc.circle(image, center, (int) Math.round(circle[2]), new Scalar(0, 0, 255), 8);
        }

        Imgcodecs.imwrite("out.png", image);

        HighGui.imshow("Result", image);
        HighGui.waitKey();
    }
}
