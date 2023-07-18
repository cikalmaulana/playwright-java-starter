package utils;

import com.microsoft.playwright.*;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Paths;

public class TestBase {
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext browserContext;
    public static Page page;

    public void initBrowser() throws IOException{
        playwright = Playwright.create();

        String browserName = TestDataContext.getBrowserName();
        boolean headless = TestDataContext.getHeadless();
        boolean recordingVideos = TestDataContext.getRecordingVideos();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        switch (browserName.toLowerCase()){
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "edge":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;

            default:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
        }

        if(recordingVideos){
            browserContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")).setRecordVideoSize(800,600));
        }else{
            browserContext = browser.newContext(new Browser.NewContextOptions());
        }
        page = browserContext.newPage();
        page.setDefaultTimeout(Double.parseDouble(TestDataContext.getTimeout()));
    }
}
