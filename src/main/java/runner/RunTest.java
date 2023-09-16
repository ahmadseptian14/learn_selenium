package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "StepDef",
        tags = "@Github and @Positive and @CreateRepository",
        plugin = {"pretty", "html:target/RegressionReport.html"}

)
public final class RunTest {

}
