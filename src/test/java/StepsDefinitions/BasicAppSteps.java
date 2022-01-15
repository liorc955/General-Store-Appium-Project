package StepsDefinitions;

import java.net.MalformedURLException;

import org.apache.log4j.PropertyConfigurator;

import io.cucumber.java.en.Given;
import objects.MobileDevice;

public class BasicAppSteps {
	
	@Given("app is open")
	public void app_is_open() throws MalformedURLException, InterruptedException {
		String log4jConfPath = "src/test/resources/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		new MobileDevice();
	}

}
