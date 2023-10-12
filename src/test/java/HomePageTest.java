import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePageMember;
import pages.LoginPageAgent;
import pages.LoginPageMember;

public class HomePageTest extends BaseTest {

    @Test(groups = { "member"})
	@Parameters({"username", "password"})
    public static void homeMemberTest_01(String username, String password) throws InterruptedException {
        log("Login to member site");
		LoginPageMember.login(username, password);
        log("Navigate to Soccer");
        HomePageMember.navigateToSport("Soccer");
        HomePageMember.verifySportSelected("Soccer");
    }

}
