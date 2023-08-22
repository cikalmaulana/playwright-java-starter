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

    @Given("^access google and search:$")
    public void accessGoogleAndSearch(DataTable param) {
        List<Map<String,String>> data = param.asMaps(String.class, String.class);
        for(Map<String,String> searchData : data){
            String keyword = searchData.get("keywords");
            String isImage = searchData.get("isImage");

            String keywordsParam = System.getProperty("KEYWORDS_PARAM");
            if (keywordsParam != null && !keywordsParam.isEmpty()) {
                String[] keywords = keywordsParam.split(",");
                for (String key : keywords) {
                    dashboard.navigateTo("https://www.google.com/");
                    dashboard.searchInput(key, isImage);
                }
            } else {
                // Handle the case when KEYWORDS_PARAM is not provided
            }
        }
    }
}
