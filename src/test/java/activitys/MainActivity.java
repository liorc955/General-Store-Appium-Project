package activitys;

import java.util.List;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.UtilsElement;

public class MainActivity extends UtilsElement {
	
	
	@AndroidFindBy (id = "com.androidsample.generalstore:id/spinnerCountry")
	private AndroidElement countrySelect;
	@AndroidFindBy (className = "android.widget.TextView")
	private List<AndroidElement> countryOptions;
	@AndroidFindBy (id = "com.androidsample.generalstore:id/nameField")
	private AndroidElement nameInputField;
	@AndroidFindBy (id = "com.androidsample.generalstore:id/radioMale")
	private AndroidElement radioButtonMale;
	@AndroidFindBy (id = "com.androidsample.generalstore:id/radioFemale")
	private AndroidElement radioButtonFemale;
	@AndroidFindBy (id = "com.androidsample.generalstore:id/btnLetsShop")
	private AndroidElement submitButton;
	@AndroidFindBy (xpath = "//android.widget.Toast")
	private AndroidElement nameErrortoast;
	private String activityName;
	
	public MainActivity(AndroidDriver<AndroidElement> driver) {
		super(driver);
		activityName = "MainActivity";
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void selectCountry(String country) {
		countrySelect.click();
		scrollToElement(country).click();
	}
	    
	
	public void typeName(String name) {
		nameInputField.sendKeys(name);
	}
	
	public void selectGender(String gender) {
		if (gender.equalsIgnoreCase("Male")) {
			radioButtonMale.click();
		} else if (gender.equals("Female")) {
			radioButtonFemale.click();
		}
	}
	
	public void clickOnSumbitButton() {
		submitButton.click();
	}
	
	public boolean nameErrorToastIsDisplay() {
		return nameErrortoast.getAttribute("name").equals("Please enter your name");
	}

	public String getActivityName() {
		return activityName;
	}
	
}
