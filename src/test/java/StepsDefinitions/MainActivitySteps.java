package StepsDefinitions;



import activitys.MainActivity;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import objects.MobileDevice;
import objects.UserDetails;

public class MainActivitySteps {
	
	
	MainActivity mainActivity = null;
	UserDetails user = null;
	
	
	@After
	public void teardown() {
		MobileDevice.driver.quit();
	}
	
	@And("the app is on the Main Activity")
	public void the_app_is_on_the_Main_Activity() {
		mainActivity = new MainActivity(MobileDevice.driver);
		user = new UserDetails("Lior", "Aruba", "Male");
	}

	@When("user selects the country shop")
	public void user_selects_the_country_shop() {
		mainActivity.selectCountry(user.getCountry());
	}

	@And("selects a gender")
	public void selects_a_gender() {
	    mainActivity.selectGender(user.getGender());
	}

	
	

	@And("enters a name")
	public void enters_a_name() {
		mainActivity.typeName(user.getName());
	}

	@And("clicks on Lets Shop")
	public void clicks_on_lets_shop() {
	    mainActivity.clickOnSumbitButton();
	}
	

	@And("leaves the name field empty")
	public void leaves_the_name_field_empty() {
	    mainActivity.typeName("");
	}

	@Then("the user has not navigated to Product Activity")
	public void the_user_has_not_navigated_to_product_activity() {
		assertTrue(MobileDevice.driver.currentActivity().contains(mainActivity.getActivityName()));
	}

	@And("please enter your name error message appears.")
	public void please_enter_your_name_error_message_appears() {
		assertTrue(mainActivity.nameErrorToastIsDisplay());
	}

	@And("types numbers at the name field")
	public void types_numbers_at_the_name_field() {
	    mainActivity.typeName("123456");
	}

}
