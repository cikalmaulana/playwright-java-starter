package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "steps",
        tags = "@FirstScenarios",
        features = "src/test/scenarios/firstTest.feature"
)
public class TestRunner1 {
    // Tidak ada implementasi tambahan yang diperlukan
}
