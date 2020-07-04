package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseAppiumTest {

    public AppiumDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if(AppiumConfigurations.platform.equalsIgnoreCase(AppiumConfigurations.ANDROID)) {

            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, AppiumConfigurations.ANDROID);
            capabilities.setCapability(MobileCapabilityType.VERSION, "8.1.0");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.android.calculator2.Calculator");
        }
        else{
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, AppiumConfigurations.IOS);
            capabilities.setCapability(MobileCapabilityType.VERSION, "13.2");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11 Pro Max");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.apple.MobileAddressBook");
        }
        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AppiumDriver<MobileElement>(url, capabilities);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        catch (Exception exc){
            System.out.println(exc);
        }

    }

    @AfterClass
    public void afterClass() {
        driver.quit();

    }
}
