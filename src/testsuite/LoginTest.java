package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    @Before
    public void openingBrowser() {
        browserSetup("https://courses.ultimateqa.com/", "Chrome");
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Clicking on 'Sign In' link
        clickOnTheElement(By.xpath("//section[@class='header__user-menu']/ul//li"));

        String expectedText = "Welcome Back!";
        String actualText = verifyText(By.xpath("//h1[@class='page__heading']"));
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyTheErrorMessage() {
        //Clicking on 'Sign In' link
        clickOnTheElement(By.xpath("//section[@class='header__user-menu']/ul//li"));

        enterTextInElement(By.id("user[email]"), "abcd");
        enterTextInElement(By.name("user[password]"), "aw34");

        clickOnTheElement(By.xpath("//input[@class='button button-primary g-recaptcha']"));

        String expectedText = "Invalid email or password.";
        String actualText = verifyText(By.xpath("//div[@class='notice__form-error']/ul/li"));
        Assert.assertEquals(expectedText, actualText);

    }

    @After
    public void closeTheBrowser() {
        closingTheBrowser();
    }
}
