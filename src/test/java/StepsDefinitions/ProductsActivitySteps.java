package StepsDefinitions;


import activitys.ProductsActivity;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import objects.ListOfProducts;
import objects.MobileDevice;
import objects.Product;

import static org.junit.Assert.*;

public class ProductsActivitySteps {
	
	ListOfProducts productsList = null;
	ProductsActivity productActivity = null;
	Product[] selectedProducts;
	int counterCart;
	
	@After
	public void teardown() {
		MobileDevice.driver.quit();
	}
	
	@Then("the user navigated to Product Activity")
	public void the_user_navigated_to_product_activity() {
	    productActivity = new ProductsActivity(MobileDevice.driver);
	    assertTrue(MobileDevice.driver.currentActivity().contains(productActivity.getActivityName()));
	    productsList = new ListOfProducts();
	    productsList.createListOfProducts();
	}

	@And("user adds product to cart")
	public void user_adds_product_to_cart() {
		counterCart = productActivity.getCounterCart();
		productActivity.addProduct(productsList.getProduct(8)); 
	}

	@Then("the number on the cart icon should increase by one")
	public void the_number_on_the_cart_icon_should_increase_by_one() {
	    assertTrue(productActivity.getCounterCart() == counterCart + 1);
	}

	@And("the ADDED TO CART button appears")
	public void the_added_to_cart_button_appears() {
		assertTrue(productActivity.isAddedToCartButtonDisplay(productsList.getProduct(8)));
	}


	@And("user removes product from cart")
	public void user_removes_product_from_cart() {
		counterCart = productActivity.getCounterCart();
		productActivity.removeProduct(productsList.getProduct(8));
	}

	@Then("the number on the cart icon should decrease by one")
	public void the_number_on_the_cart_icon_should_decrease_by_one() {
		assertTrue(productActivity.getCounterCart() == counterCart - 1);
	}

	@And("the Add to cart button appears")
	public void the_add_to_cart_button_appears() {
	   productActivity.isAddToCartButtonDisplay(productsList.getProduct(8));
	}

	@When("there is no number on the cart icon")
	public void there_is_no_number_on_the_cart_icon() {
		assertTrue(productActivity.getCounterCart() == 0);
	}

	@And("user clicks on the cart icon")
	public void user_clicks_on_the_cart_icon() {
	    productActivity.clickOnCartIcon();
	}

	@Then("the user has not navigated to Cart Activity")
	public void the_user_has_not_navigated_to_cart_activity() {
	    assertTrue(MobileDevice.driver.currentActivity().contains(productActivity.getActivityName()));
	}

	@And("please add some products at first message appears")
	public void please_add_some_products_at_first_message_appears() {
	   assertTrue(productActivity.cartErrorToastIsDisplay());
	}
	
	@When("user adds products to cart")
	public void user_adds_products_to_cart() {
		selectedProducts = new Product[]{productsList.getProduct(2), productsList.getProduct(5), productsList.getProduct(8)};
		for (Product product : selectedProducts) {
			productActivity.addProduct(product);
		}
		counterCart = selectedProducts.length;
	}

	@Then("the number on the cart icon increase by products amount")
	public void the_number_on_the_cart_icon_increase_by_products_amount() {
		assertTrue(productActivity.getCounterCart() == counterCart);
	}

	@When("user removes products")
	public void user_removes_products() {
		for (Product product : selectedProducts) {
			productActivity.removeProduct(product);
			counterCart--;
		}
	}

	@Then("the number on the cart icon decrease by products amount")
	public void the_number_on_the_cart_icon_decrease_by_products_amount() {
		assertTrue(productActivity.getCounterCart() == counterCart);
	}



}
