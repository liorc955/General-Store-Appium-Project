package TestRunners;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.http.ContentType;
import utils.UtilsFile;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/MainActivity.feature", glue= {"StepsDefinitions"},
monochrome = true, plugin = {"json:src/test/resources/JSONTestResults/MainActivityTestResult.json"})
public class TestRunnerForMainActivity {
	
    @AfterClass
    public static void teardown() {
    	baseURI = "http://localhost:4000";
        UtilsFile mainActivityFile = new UtilsFile("/src/test/resources/JSONTestResults/MainActivityTestResult.json");
        given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(mainActivityFile.getFile()).
		when().
		post("/mainActivityTests").
		then().
		statusCode(201);
    }

}
