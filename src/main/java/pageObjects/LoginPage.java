package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Constant;

import java.util.List;

public class LoginPage {

    private static AndroidDriver<AndroidElement> driver;

    public LoginPage(AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy (id = "de.zalando.mobile:id/zds_text_field_edit_text")
    List<WebElement> credentialsInputField;

    @AndroidFindBy(id = "de.zalando.mobile:id/login_button_label")
    WebElement loginSubmitButton;

    public void loginCredentialsInsert(String email, String password){
        credentialsInputField.get(0).sendKeys(Constant.email);
        credentialsInputField.get(1).sendKeys(Constant.password);
    }

    public void loginSubmit(){
        loginSubmitButton.click();
    }

}
