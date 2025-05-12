import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HerokuappLoginPageTest extends BaseTest {

    @Test
    public void LoginPageСorrect () {
        browser.get("https://the-internet.herokuapp.com/login");
        browser.findElement(By.id("username")).sendKeys("tomsmith");
        browser.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        browser.findElement(By.cssSelector(".radius")).click();
        assertEquals(browser.findElement(By.cssSelector(".subheader")).getText(),"Welcome to the Secure Area. When you are done click logout below.");
    }

    @Test
    public void LoginPageIncorrect () {
        browser.get("https://the-internet.herokuapp.com/login");
        browser.findElement(By.id("username")).sendKeys("tomsmith1");
        browser.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        browser.findElement(By.cssSelector(".radius")).click();
        boolean flashError = browser.findElement(By.cssSelector(".flash")).isDisplayed();
        assertTrue(flashError);
    }
}
