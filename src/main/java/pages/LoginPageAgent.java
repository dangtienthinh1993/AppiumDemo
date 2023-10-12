package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.MobileBrowser;

import static utils.MobileActions.*;

public class LoginPageAgent extends MobileBrowser {
    private static final By btnLogin = By.xpath("//span[text()='Login']");
    private static final By txtUsername = By.name("username");
    private static final By txtPassword = By.name("password");
    private static final By lblErrorMsg = By.xpath("//app-landing-dialog//span");
    public static void inputLoginInfo(String username, String password, boolean isLogin) {
        waitUntilElementIsPresent(txtUsername);
        clearAndSendKeys(txtUsername, username);
        clearAndSendKeys(txtPassword, password);
        if(isLogin) {
            clickElementBy(btnLogin);
        }
    }

    public static void verifyLoginErrorMsgDisplay(String message) {
        Assert.assertEquals(getTextFromElement(lblErrorMsg), message, "FAILED! Error msg does not display correct");
    }
}
