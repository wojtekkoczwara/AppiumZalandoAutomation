package utilities;

public class Constant {

    //webDriver definition
    public static final String webDriverKey = "webdriver.chrome.driver";
    public static final String webDriverPath = "src/main/resources/chromedriver.exe";

    //Desired capabilities definition



    //Demanded URL
    public static final String URL = "https://zalando.co.uk";


    //Device definition
    public static final String deviceName = "Xiaomi";
    public static final String deviceUDID = "5268275";

    //Main App Activity & Appium port address
    public static final String appiumPortAddress = "http://127.0.0.1:4723/wd/hub";
    public static final String appPackage = "de.zalando.mobile";
    public static final String appActivity = "de.zalando.mobile.ui.start.SplashActivity";

    //Other Capabilities
    public static final String screenOrientation = "PORTRAIT";
    public static final String skipUnlock = "true";
    public static final String unlockType = "pattern";
    public static final String unlockKey = "3578";

    //loginData
    public static final String email = "wojtektester@niepodam.pl";
    public static final String password = "Niepodam.pl1";

    //Product to be searched


    //Customer and order data
    public static final String firstName = "Ferdynand";
    public static final String lastName = "Kiepski";
    public static final String address = "  ";
    public static final String postalCode = "44-444";
    public static final String city = "Babkowa renta";
    public static final String phone = "500333444";
    public static final String paymentMethodChosen = "Google Pay";
}
