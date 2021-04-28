package dude.test.acceptanceTests;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "dude.test.acceptanceTests", features = 
"src/test/java/dude/test/", monochrome = true)
public class TestRunner {

}
