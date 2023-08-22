package pages;

import com.microsoft.playwright.*;

import java.io.IOException;

public class Dashboard {
    private final Browser browser;

    public Dashboard(boolean isHeadless) {
        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setHeadless(isHeadless);

        browser = browserType.launch(launchOptions);
    }

    public Page navigateTo(String url) {
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate(url);
        return page;
    }

    public void searchInput(String key, String isImage){
        System.out.println("Keyword = " + key);
        System.out.println("IsImage = " + isImage);
    }
}
