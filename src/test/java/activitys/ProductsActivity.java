package activitys;





import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import objects.Product;
import objects.ProductsInCart;
import utils.UtilsElement;

public class ProductsActivity extends UtilsElement {

	@AndroidFindBy (id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private AndroidElement cartIcon;
	@AndroidFindBy (xpath = "//android.widget.Toast")
	private AndroidElement cartErrortoast;
	@AndroidFindBy (id = "com.androidsample.generalstore:id/counterText")
	private AndroidElement counterCart;
	private By addToCartButtonLocator = MobileBy.xpath("//android.widget.TextView[@text='ADD TO CART']");
	private By productPriceLocator = MobileBy.id("com.androidsample.generalstore:id/productPrice");
	private By addedToCartButtonLocator = MobileBy.xpath("//android.widget.TextView[@text='ADDED TO CART']");
	private String activityName;

	public ProductsActivity(AndroidDriver<AndroidElement> driver) {
		super(driver);
		activityName = "AllProductsActivity";
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	protected AndroidElement getSelectedProduct(String proudct) {
		AndroidElement productElement =null;
		try { // get the element's product on the app by UiSelector
			productElement = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
					+ ".className(\"android.support.v7.widget.RecyclerView\"))"
					+ ".getChildByText(new UiSelector()"
					+ ".className(\"android.widget.RelativeLayout\"), " + "\"" + proudct + "\")");
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return productElement;
		}
		return productElement;
	}


	public void addProduct(Product product) {
		getButtonFromProductElement(product, addToCartButtonLocator).click();
		ProductsInCart.products.add(product);
	}

	public void removeProduct(Product product) {
		getButtonFromProductElement(product, addedToCartButtonLocator).click();
		ProductsInCart.products.remove(product);
	}
	
	public boolean isAddedToCartButtonDisplay(Product product) {
		return isElementPresent(getButtonFromProductElement(product, addedToCartButtonLocator));
	}
	
	public boolean isAddToCartButtonDisplay(Product product) {
		return isElementPresent(getButtonFromProductElement(product, addToCartButtonLocator));
	}
	
	private MobileElement getButtonFromProductElement(Product product, By buttonLocator) {
		AndroidElement selectedProduct = getSelectedProduct(product.getName());
		MobileElement buttonElement = selectedProduct.findElement(buttonLocator);
		return buttonElement;
	}
	
	protected double getPriceOfProductOnApp(AndroidElement product) {
		String priceOfProduct = product.findElement(productPriceLocator).getText().split("[$]")[1];
		return Double.parseDouble(priceOfProduct);
	}
	

	public void clickOnCartIcon() {
		cartIcon.click();
	}

	public boolean cartErrorToastIsDisplay() {
		return cartErrortoast.getAttribute("name").equals("Please add some product at first");
	}

	public int getCounterCart() {
		return isElementPresent(counterCart) ? Integer.parseInt(counterCart.getText()) : 0;
	}

	public String getActivityName() {
		return activityName;
	}



}
