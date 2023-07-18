package steps;

import io.cucumber.java.en.Given;
import pages.Dashboard;

public class FirstScenarioStepDef {
    Dashboard dashboard;

    public FirstScenarioStepDef(){
        dashboard = new Dashboard();
    }

    @Given("access google")
    public void accessGoogle() {
        dashboard.sayHello();
    }
}
