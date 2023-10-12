import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

import base.BaseTest;
import pages.LoginPageAgent;
import pages.LoginPageMember;

public class LoginTest extends BaseTest {

    @Test(groups = { "member"})
	@Parameters({"username", "password"})
    public static void loginMemberTest_01(String username, String password) {
        log("Open Login Form");
		LoginPageMember.openLoginForm();
        log("Input username/password and click login button");
        LoginPageMember.inputLoginInfo(username, password, true);
        log("Verify login successfully");
        Assert.assertTrue(LoginPageMember.isLoginSuccess());
    }

    @Test(groups = { "member"})
    @Parameters({"username"})
    public static void loginMemberTest_02(String username) {
        log("Open Login Form");
        LoginPageMember.openLoginForm();
        log("Input invalid username/password and click login button");
        LoginPageMember.inputLoginInfo(username, "1234qwer", true);
        log("Verify login unsuccessfully");
        LoginPageMember.verifyLoginErrorMsgDisplay("Invalid Username OR Password.");
    }

    @Test(groups = { "agent"})
    @Parameters({"username", "password"})
    public static void loginAgentTest_01(String username, String password) {
        log("Input username/password and click login button");
        LoginPageAgent.inputLoginInfo(username, password, true);
        log("Verify login unsuccessfully");
        LoginPageAgent.verifyLoginErrorMsgDisplay("Invalid captcha.");
    }
}
