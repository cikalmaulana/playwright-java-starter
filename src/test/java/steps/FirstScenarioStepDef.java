package steps;

import io.cucumber.java.en.Given;
import pages.Dashboard;

public class FirstScenarioStepDef {
    Dashboard dashboard;

    public FirstScenarioStepDef(){
        dashboard = new Dashboard(false);
    }

    @Given("access google and search")
    public void accessGoogleAndSearch() {
        String keywordsParam = System.getenv("KEYWORDS_PARAM");
        String isImageParam = System.getenv("IS_IMAGE_PARAM");
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

    @Given("access google and search2")
    public void accessGoogleAndSearch2() {
        String keywordsParam = System.getenv("KEYWORDS_PARAM");
        String isImageParam = System.getenv("IS_IMAGE_PARAM");
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

    @Given("access google and search3")
    public void accessGoogleAndSearch3() {
        String keywordsParam = System.getenv("KEYWORDS_PARAM");
        String isImageParam = System.getenv("IS_IMAGE_PARAM");
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
