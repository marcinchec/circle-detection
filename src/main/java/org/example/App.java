package org.example;

import nu.pattern.OpenCV;

public class App {
    public static void main(String[] args) {
        OpenCV.loadShared();
        CircleDetection circleDetection = new CircleDetection();
        circleDetection.detectCircle();
    }
}
