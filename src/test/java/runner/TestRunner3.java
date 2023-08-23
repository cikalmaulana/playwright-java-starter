package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "steps",
        tags = "@ThirdScenarios",
        features = "src/test/scenarios/thirdTest.feature"
)
public class TestRunner3 {
    // Tidak ada implementasi tambahan yang diperlukan
}
