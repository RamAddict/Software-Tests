package br.ufsc.solidity.testing.acceptanceTests;

import org.junit.runner.RunWith;

import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "br.ufsc.solidity.testing.acceptanceTests.cucumberSteps", 
                 features = "src/test/java/br/ufsc/solidity/testing/acceptanceTests/features", 
                 monochrome = true)

public class TestRunner {

}



