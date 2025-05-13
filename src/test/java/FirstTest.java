import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstTest extends BaseTest {

    @Test
    public void zipCode4DigitsCheck() {
        // 1. открыть браузер
        // 2. Зайти на сайт
        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("1234");
        browser.findElement(By.xpath("//*[@value='Continue']")).click();
        assertEquals(browser.findElement(By.cssSelector(".error_message")).getText(), "Oops, error on page. ZIP code should have 5 digits", "ZIP code should have 5 digits");
    }

    @Test
    public void zipCode5DigitsCheck() {
        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("12345");
        browser.findElement(By.xpath("//*[@value='Continue']")).click();
        boolean regBtnIsPresent = browser.findElement(By.xpath("//*[@value='Register']")).isDisplayed();
        assertTrue(regBtnIsPresent);
    }
}
