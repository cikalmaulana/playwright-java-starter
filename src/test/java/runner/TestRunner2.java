package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "steps",
        tags = "@SecondScenarios",
        features = "src/test/scenarios/secondTest.feature"
)
public class TestRunner2 {
    // Tidak ada implementasi tambahan yang diperlukan
}
