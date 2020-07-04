package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;

import java.time.Duration;
import java.util.HashMap;

public class TouchWrapper {

    public static final String UP = "up";
    public static final String DOWN = "down";
    public static final String LEFT = "left";
    public static final String RIGHT = "right";

    public static void swipe(AppiumDriver driver, String direction) {
        HashMap<String, String> arguments = new HashMap<>();
        arguments.put("direction", direction);
        driver.executeScript("mobile: swipe", arguments);
    }

    public static void scroll(AppiumDriver driver,String direction){
        HashMap<String,String> arguments = new HashMap<>();
        arguments.put("direction", direction);
        driver.executeScript("mobile: scroll", arguments);
    }

    public static void zoomIn(AppiumDriver driver, int scale){
        HashMap<String, Integer> arguments = new HashMap<>();
        arguments.put("scale", scale);
        driver.executeScript("mobile: pinch", arguments);
    }


    public static void slideUpXTimes(AppiumDriver driver, int xTimes) {
        for (int i = 0; i < xTimes; i++) {
            slide(driver,100, 100, 100, 1000);
        }
    }

    public static void slideDownXTimes(AppiumDriver driver, int xTimes) {
        for (int i = 0; i < xTimes; i++) {
            slide(driver, 100, 1000, 100, 100);
        }
    }

    public static void slideToLeftXTimes(AppiumDriver driver, int xTimes){
        for (int i = 0; i < xTimes; i++){
            slide(driver, 700,100,100, 100);
        }
    }
    public static void slideToRightXTimes(AppiumDriver driver,int xTimes){
        for(int i = 0; i < xTimes; i++){
            slide(driver, 100, 100, 700, 100);
        }
    }

    public static void slide(AppiumDriver driver,int fromX,int fromY,int toX,int toY){
        TouchAction action = new TouchAction(driver);
        PointOption fromPointOption = PointOption.point(fromX,fromY);
        PointOption toPointOption = PointOption.point(toX,toY);
        action.press(fromPointOption);
        action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)));
        action.moveTo(toPointOption);
        action.release();
        action.perform();


    }
}
