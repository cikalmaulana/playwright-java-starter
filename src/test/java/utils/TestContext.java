package utils;

import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;

public class TestContext extends TestBase{
    private static Logger log = Logger.getLogger(TestContext.class);
    private static Scenario scenario;

    public static void setScenario(Scenario scenario) {
        TestContext.scenario = scenario;
    }

    public static Scenario getScenario(){
        return TestContext.scenario;
    }

    public static void log(String msg){
        log.info(msg);
        scenario.log(msg);
    }
}
