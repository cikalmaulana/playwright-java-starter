package pages;

import com.microsoft.playwright.*;

import java.io.IOException;

public class Dashboard {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    public void navigateTo(String url){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate(url);
    }

    public void sayHello(){
        System.out.println("Hello");
    }
}
