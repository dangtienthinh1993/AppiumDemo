package pages;

import org.testng.Assert;
import utils.MobileBrowser;
import org.openqa.selenium.By;

import static utils.MobileActions.*;

public class LoginPageMember extends MobileBrowser {
    private static final By btnLogin = By.xpath("//button[@class='btn-in-out mr-2']");
    private static final By txtUsername = By.name("username");
    private static final By txtPassword = By.name("password");
    private static final By btnLoginConfirm = By.xpath("//button[@class='btn-verification btn-confirm']");
    private static final By iconProfile = By.xpath("//i[@class='fas fa-user fa-2x']");
    private static final By lblErrorMsg = By.xpath("//app-login-popup//div[@class='row message-error']//span");
    public static void openLoginForm() {
        waitUntilElementIsPresent(btnLogin);
        clickElementBy(btnLogin);
    }

    public static void inputLoginInfo(String username, String password, boolean isLogin) {
        waitUntilElementIsPresent(txtUsername);
        clearAndSendKeys(txtUsername, username);
        clearAndSendKeys(txtPassword, password);
        if(isLogin) {
            clickElementBy(btnLoginConfirm);
        }
    }

    public static boolean isLoginSuccess() {
        if (driver.findElement(iconProfile).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public static void verifyLoginErrorMsgDisplay(String message) {
        Assert.assertEquals(getTextFromElement(lblErrorMsg), message, "FAILED! Error msg does not display correct");
    }

    public static void login(String username, String password) throws InterruptedException {
        openLoginForm();
        inputLoginInfo(username, password, true);
        Thread.sleep(3000);
    }
}
