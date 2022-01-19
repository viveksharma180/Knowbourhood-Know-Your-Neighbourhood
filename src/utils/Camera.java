/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import org.bytedeco.javacv.*;
import org.bytedeco.opencv.opencv_core.IplImage;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

import static org.bytedeco.opencv.global.opencv_core.cvFlip;
import static org.bytedeco.opencv.helper.opencv_imgcodecs.cvSaveImage;

/**
 *
 * @author prath
 */
public class Camera {

    //final int INTERVAL = 5000;///you may use interval
    CanvasFrame canvas = new CanvasFrame("Web Cam");
    public boolean flag = true;

    public boolean isFlag() {
        return flag;
    }
    
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Camera() {
        canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    }

    public void run(String username) {

        new File("src/ui/screens/admin/images").mkdir();

        FrameGrabber grabber = new OpenCVFrameGrabber(0); // 1 for next camera
        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
        IplImage img;
        try {
            grabber.start();

            while (flag) {
                Frame frame = grabber.grab();

                img = converter.convert(frame);

                //the grabbed frame will be flipped, re-flip to make it right
                cvFlip(img, img, 1);// l-r = 90_degrees_steps_anti_clockwise

                //save
                cvSaveImage("src/ui/screens/admin/images" + File.separator + username + ".jpg", img);

                canvas.showImage(converter.convert(img));

                Thread th = new Thread();
                flag = false;
                
                ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
                Runnable task1 = () -> closeWindow();
                executorService.schedule(task1, 3000, TimeUnit.MILLISECONDS);
                
                new Saving();

//                frame.close();
//                th.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void closeWindow() {
        canvas.setVisible(false);
        JOptionPane.showMessageDialog(null, "Awesome click! Looking gorgeous as usual!!!");
    }
    
    public static void main(String[] args) {
        Camera gs = new Camera();
        Thread th = new Thread((Runnable) gs);
        th.start();
    }
}
