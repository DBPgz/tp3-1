import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.transform.Result;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;

public class TestTP3 {

    WebDriver driver;

    @Before
    public void setup()
    {
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void closeBrowser()
    {
        driver.quit();
    }

    @Test
    public void testEnter() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(menu);
        actions.perform();

        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-flyout-accountList")));

        driver.findElement(By.xpath("//*[@id=\"nav-al-your-account\"]/a[1]/span")).click();

        Thread.sleep(2000);
    }
}
