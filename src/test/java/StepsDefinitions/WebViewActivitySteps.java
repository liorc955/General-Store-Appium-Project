package StepsDefinitions;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Then;
import objects.MobileDevice;

public class WebViewActivitySteps {
	
	@Then("the user navigated to the web store")
	public void the_user_navigated_to_the_web_store() {
		assertTrue(MobileDevice.driver.currentActivity().contains("WebViewActivity"));
	}

}
