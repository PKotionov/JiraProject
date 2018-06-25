package com.epam.ta.utils;

import com.epam.ta.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Utils {
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random rnd = new Random();
    private static String PATH_TO_SAVE_SCREENSHOTS = "target\\screenshots";

    public static String getRandomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }


    public static String getRandomEmail() {
        return Utils.getRandomString(5) + "@" + Utils.getRandomString(2) + "." + Utils.getRandomString(2);
    }

    public static void makeScreenshot(Logger logger) {
        try {
            File screenshot = ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
            File filePath = new File(PATH_TO_SAVE_SCREENSHOTS);
            filePath.mkdirs();
            FileUtils.copyFileToDirectory(screenshot, filePath);
            logger.info("You can find screenshot in: " + filePath.getAbsolutePath() + "\\" + screenshot.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
