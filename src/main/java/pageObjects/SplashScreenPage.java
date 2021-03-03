package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

public class SplashScreenPage {

    private static AndroidDriver<AndroidElement> driver;

    public SplashScreenPage(AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy (id = "de.zalando.mobile:id/zds_button_title")
    WebElement loginButton;

    public void loginButtonClick(){
        loginButton.click();
    }

}
