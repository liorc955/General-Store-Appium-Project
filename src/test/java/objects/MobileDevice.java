package objects;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import utils.UtilsFile;

public class MobileDevice extends UtilsFile {
	
	DesiredCapabilities caps = null;
	public static AndroidDriver<AndroidElement> driver = null;
	
	public MobileDevice() {
		super("/Configuration/MobileConfig.xml");
		String projectPath = System.getProperty("user.dir");
		caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, getDataFromXml("DEVICE_NAME"));
		caps.setCapability(MobileCapabilityType.UDID, getDataFromXml("UDID"));
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, getDataFromXml("PLATFORM_NAME"));
		caps.setCapability(MobileCapabilityType.VERSION, getDataFromXml("VERSION"));
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, getDataFromXml("NEW_COMMAND_TIMEOUT"));
		caps.setCapability("app", projectPath + getDataFromXml("apkPath"));
		caps.setCapability("noReset", Boolean.parseBoolean(getDataFromXml("noReset")));
		URL url = null;
		try {
			url = new URL(getDataFromXml("URL"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		MobileDevice.driver = new  AndroidDriver<AndroidElement>(url, caps);
		MobileDevice.driver.manage().timeouts().implicitlyWait(Long.parseLong(getDataFromXml("TimeOut")), TimeUnit.SECONDS);
	}
}