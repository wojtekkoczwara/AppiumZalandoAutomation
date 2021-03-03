import DriverSetUp.AndroidDriverSetUp;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.SplashScreenPage;
import utilities.Constant;

import java.net.MalformedURLException;


public class LoginTest extends AndroidDriverSetUp {

    private static AndroidDriver<AndroidElement> driver;
    private static String keepAppDataSaved = "false";

    @BeforeTest
    public void setUp() throws MalformedURLException {

        driver = AndroidDriverSetUpMethod(driver, keepAppDataSaved);

    }


    @Test
    public void loginTest() {

        SplashScreenPage splashScreenPage = new SplashScreenPage(driver);

        splashScreenPage.loginButtonClick();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginCredentialsInsert(Constant.email, Constant.password);

        loginPage.loginSubmit();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.welcomePopUpCloseMethod();
        landingPage.personalLeftPanelActivation();

        Assert.assertTrue(landingPage.userNameTextView.isDisplayed(), "User not logged in");

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
