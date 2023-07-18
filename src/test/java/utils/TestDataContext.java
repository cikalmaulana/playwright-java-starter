package utils;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class TestDataContext {

    private static Logger log = Logger.getLogger(TestDataContext.class);
    private static GenLib genLib = new GenLib();

    public static String getEnvironmentProfile(String env) throws IOException{
        Properties env_properties = genLib.getPropertiesFromFile("application.properties");
        String testingEnvironment = env_properties.getProperty(env);
        return testingEnvironment;
    }

    public static String getEnvironmentUrl(String env) throws IOException{
        String finalUrl = "";
        Properties url_properties = genLib.getPropertiesFromFile("url.properties");
        finalUrl = url_properties.getProperty(env);
        log.info("URL = " + finalUrl);
        return finalUrl;
    }

    public static String getBrowserName() throws IOException{
        Properties app_properties = genLib.getPropertiesFromFile("application.properties");
        String browserTesting = app_properties.getProperty("browser");
        log.info("Browser: " + browserTesting);
        return browserTesting;
    }

    public static boolean getHeadless() throws IOException{
        Properties app_properties = genLib.getPropertiesFromFile("application.properties");
        boolean headless = Boolean.parseBoolean(app_properties.getProperty("headless"));
        log.info("Headless: " + headless);
        return headless;
    }

    public static String getTimeout() throws IOException{
        Properties app_properties = genLib.getPropertiesFromFile("application.properties");
        String timeout = app_properties.getProperty("timeout");
        log.info("Timeout: " + timeout);
        return timeout;
    }

    public static boolean getRecordingVideos() throws IOException{
        Properties app_properties = genLib.getPropertiesFromFile("application.properties");
        boolean recording = Boolean.parseBoolean(app_properties.getProperty("recordingVideos"));
        return recording;
    }
}
