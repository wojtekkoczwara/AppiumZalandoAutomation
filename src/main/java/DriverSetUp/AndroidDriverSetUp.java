package DriverSetUp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.Constant;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidDriverSetUp {

    private static AndroidDriver<AndroidElement> driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    public AndroidDriver<AndroidElement> AndroidDriverSetUpMethod (AndroidDriver<AndroidElement> driver, String keepAppDataSaved) throws MalformedURLException {

//        Do uzupełnienia z lapka służbowego
//        Boolean clearMemory = true;
//
//        if (clearMemory == true){
//
//        }

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Constant.deviceName);
        capabilities.setCapability(MobileCapabilityType.UDID, Constant.deviceUDID);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability("appPackage", Constant.appPackage);
        capabilities.setCapability("appActivity", Constant.appActivity);
        capabilities.setCapability(MobileCapabilityType.ORIENTATION, Constant.screenOrientation);
        //capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("skipUnlock", Constant.skipUnlock);
        capabilities.setCapability("unlockType", Constant.unlockType);
        capabilities.setCapability("unlockKey", Constant.unlockKey);
        capabilities.setCapability("language", "pl");
        capabilities.setCapability("locale", "PL");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, keepAppDataSaved);
        driver = new AndroidDriver<AndroidElement>(new URL(Constant.appiumPortAddress), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }
}
