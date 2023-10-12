package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.MobileBrowser;

import static utils.MobileActions.*;

public class HomePageMember extends MobileBrowser {
    public static void navigateToSport(String sportName) throws InterruptedException {
        String xpath = String.format("//app-sport-menu-bar//ul[@class='navbar-nav']//li//div[text()=' %s ']", sportName);
        By lblSport = By.xpath(xpath);
        clickElementBy(lblSport);
        Thread.sleep(3000);
    }

    public static void verifySportSelected(String sportName) {
        String xpath = String.format("//app-sport-menu-bar//ul[@class='navbar-nav']//div[text()=' %s ']//parent::a", sportName);
        By lblMenuSelected = By.xpath(xpath);
        WebElement element = driver.findElement(lblMenuSelected);
        String att = element.getAttribute("className");
        Assert.assertTrue(att.equals("nav-link selected-tab"), "FAILED! ");
    }

}
