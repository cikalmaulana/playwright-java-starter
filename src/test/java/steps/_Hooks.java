package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import utils.TestBase;
import utils.TestContext;
import utils.TestDataContext;

import java.io.IOException;

public class _Hooks extends TestBase {

    private static Logger log = Logger.getLogger(_Hooks.class);

    @Before
    public void before(Scenario scenario){
        try {
            TestContext.setScenario(scenario);
            TestContext.log("Executing scenario: " + scenario.getName());
            initBrowser();
            navigateBrowser();
        }catch (Throwable e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
//
//    @After
//    public void after(){
//        page.context().browser().close();
//        browserContext.close();
//    }

    public void navigateBrowser() throws IOException{
        String url = TestDataContext.getEnvironmentUrl("SIT");
        page.navigate(url);
        page.waitForTimeout(5000);
        log.info("Page title = " + page.title().toLowerCase());
    }
}
