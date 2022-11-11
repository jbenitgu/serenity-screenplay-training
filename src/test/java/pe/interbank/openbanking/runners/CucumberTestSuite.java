package pe.interbank.openbanking.runners;


import environment.SystemEnvironmentVariables;
import io.cucumber.junit.CucumberOptions;
import mainframe.com.bdd.util.UtilMainframe;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.junit.runner.RunWith;
import pe.interbank.openbanking.utils.JiraXrayOperation;

import java.util.logging.Logger;

import static environment.ManageEnvironment.setEnvironment;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"json:target/build/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = "pe.interbank.openbanking.stepdefinitions",
        tags = "@XDI-8"
)
public class CucumberTestSuite {

    @BeforeClass
    public static void beforeExecution() {
        UtilMainframe.logger(CucumberTestSuite.class).info("BEFORE >>>");
        setEnvironment(SystemEnvironmentVariables.createEnvironmentVariables());
    }

    @BeforeClass
    public static void beforeAll(){
        Logger.getLogger(CucumberTestSuite.class.getName()).info("Before all execution >>>");
    }

//    @AfterClass
//    public static void afterAll(){
//        Logger.getLogger(CucumberTestSuite.class.getName()).info("After all execution >>>");
//        JiraXrayOperation.importCucumberResult("/target/build/cucumber.json");
//    }
}
