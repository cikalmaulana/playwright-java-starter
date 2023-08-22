package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import pages.Dashboard;

import java.util.List;
import java.util.Map;

public class FirstScenarioStepDef {
    Dashboard dashboard;

    public FirstScenarioStepDef(){
        dashboard = new Dashboard();
    }

    @Given("access google and search")
    public void accessGoogleAndSearch() {
        String keywordsParam = System.getProperty("KEYWORDS_PARAM");
        String isImageParam = System.getProperty("IS_IMAGE_PARAM");
        System.out.println("keywordsParam = " + keywordsParam);
        if (keywordsParam != null && !keywordsParam.isEmpty()) {
            String[] keywords = keywordsParam.split(",");
            for (String key : keywords) {
                dashboard.navigateTo("https://www.google.com/");
                dashboard.searchInput(key, isImageParam);
            }
        } else {
            // Handle the case when KEYWORDS_PARAM is not provided
            System.out.println("Keyword & Image is null!");
        }
    }
}
