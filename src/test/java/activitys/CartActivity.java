package activitys;







import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import objects.Product;
import objects.ProductsInCart;

public class CartActivity extends ProductsActivity {

	
	@AndroidFindBy (id = "com.androidsample.generalstore:id/btnProceed")
	private AndroidElement proceedButton;
	@AndroidFindBy (className = "android.widget.CheckBox")
	private AndroidElement discountsCheckBox;
	@AndroidFindBy (id ="com.androidsample.generalstore:id/popUp")
	private AndroidElement popUpWindow;
	@AndroidFindBy (id = "com.androidsample.generalstore:id/termsButton")
	private AndroidElement termsButton;
	@AndroidFindBy (id = "com.androidsample.generalstore:id/totalAmountLbl")
	private AndroidElement totalAmountLbl;
	@AndroidFindBy (id= "com.androidsample.generalstore:id/appbar_btn_back")
	private AndroidElement backButton;
	private String activityName;


	public CartActivity(AndroidDriver<AndroidElement> driver) {
		super(driver);
		activityName = "CartActivity";
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickOnCheckBox() {
		discountsCheckBox.click();
	}

	public boolean isCheckBoxChecked() {
		return Boolean.parseBoolean(discountsCheckBox.getAttribute("checked"));
	}

	public void clickOnProceedButton() {
		proceedButton.click();
	}

	public boolean isPopUpDisplay() {
		return isElementPresent(popUpWindow);

	}

	public void clickOnTermsButton() {
		termsButton.click();
	}
	
// Check if all the products I added from products activity are displayed in the cart app
	public boolean validateProductsInCart() { 
		for (Product product : ProductsInCart.products) {
			if(!validateProductInCart(product)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean validateProductInCart(Product product) {
		AndroidElement productElementOnApp = getSelectedProduct(product.getName());
		if (productElementOnApp != null ) {
			double priceOfProductOnApp = getPriceOfProductOnApp(productElementOnApp);
			if (priceOfProductOnApp == product.getPrice()) {
				return true;
			}
		}
		return false;
	}

	public boolean validateTotalAmount() {
		double totalAmountOnList = 0;
		double totalAmountOnElementApp = Double.parseDouble(totalAmountLbl.getText().split("[$]")[1]);
		for (int i=0; i<ProductsInCart.products.size(); i++) {
			totalAmountOnList += ProductsInCart.products.get(i).getPrice();
		}
		return totalAmountOnList == totalAmountOnElementApp;
	}
	
	public void clickOnBackButton() {
		backButton.click();
	}
	
	public String getActivityName() {
		return activityName;
	}

}
