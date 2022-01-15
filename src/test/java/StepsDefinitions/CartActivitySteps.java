package StepsDefinitions;

import static org.junit.Assert.assertTrue;

import activitys.CartActivity;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import objects.ListOfProducts;
import objects.MobileDevice;

public class CartActivitySteps {
	
	
	CartActivity cartActivity = null;
	ListOfProducts productsList = null;
	
	@After
	public void teardown() {
		MobileDevice.driver.quit();
	}
	
	@Then("the app is on the Cart Activity")
	public void the_app_is_on_the_Cart_Activity() {
	    cartActivity = new CartActivity(MobileDevice.driver);
	    assertTrue(MobileDevice.driver.currentActivity().contains(cartActivity.getActivityName()));
	}

	@When("user clicks on send me discounts check box")
	public void user_clicks_on_send_me_discounts_check_box() {
		cartActivity.clickOnCheckBox();
	}
	
	@Then("the check box checked")
	public void the_check_box_checked() {
		assertTrue(cartActivity.isCheckBoxChecked());
	}

	@When("user clicks on Visit to the website to complete purchase button")
	public void user_clicks_on_visit_to_the_website_to_complete_purchase_button() {
		cartActivity.clickOnProceedButton();
	}
	
	@When("user clicks on Please read out terms of conditions button")
	public void user_clicks_on_please_read_out_terms_of_conditions_button() {
	    cartActivity.clickOnTermsButton();
	}

	@Then("popup with terms and conditions should appear")
	public void popup_with_terms_and_conditions_should_appear() {
		assertTrue(cartActivity.isPopUpDisplay()); 
	}
	
	@And("the products appear in the cart including title and price")
	public void the_products_appear_in_the_cart_including_title_and_price() {
	  assertTrue(cartActivity.validateProductsInCart());
	}

	@And("the total purchase amount should be calculated correctly")
	public void the_total_purchase_amount_should_be_calculated_correctly() {
	  assertTrue(cartActivity.validateTotalAmount());
	}
	
	@When("user clicks on the back button")
	public void user_clicks_on_the_back_button() {
		cartActivity.clickOnBackButton();
	}


	@Then("the product does not appear in the cart")
	public void the_product_does_not_appear_in_the_cart() {
		productsList = new ListOfProducts();
		productsList.createListOfProducts();
		assertTrue(!cartActivity.validateProductInCart(productsList.getProduct(8)));
	}



}
