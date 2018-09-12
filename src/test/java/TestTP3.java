import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.core.Is.is;

public class TestTP3 {

    WebDriver driver;

    @Before
    public void setup()
    {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser()
    {
        driver.quit();
    }

    @Test
    public void test1()
    {
        HomePage homePage = new HomePage();
        homePage.recherche("Bordeaux");

        ResultsPage resultsPage = new ResultsPage();
        Assert.assertThat(resultsPage.getResult(0), is("Site officiel de la ville de Bordeaux | Bordeaux"));
    }
}
