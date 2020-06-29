package Screen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class SignIn extends BaseScreen {

    public SignIn(AndroidDriver driver) {
        super(driver);
    }

    //Mobile element
    @AndroidFindBy(accessibility = "com.glowie.staging:id/btnRegisterNew")
    private MobileElement btnRegisterNew;

    @AndroidFindBy(accessibility = "com.glowie.staging:id/btnSignUpFaceBook")
    private MobileElement btnSignUpFaceBook;

    @AndroidFindBy(accessibility = "com.glowie.staging:id/txtHaveAnAccount")
    private MobileElement txtHaveAnAccount;


}
