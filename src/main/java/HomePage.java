import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;

    @FindBy(id = "hplogo")
    WebElement logo;

    @FindBy(name = "q")
    WebElement barreRecherche;

    @FindBy(css = ".lsb")
    WebElement buttonRecherche;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ResultsPage rechercheAvecEntree(String text)
    {
        barreRecherche.sendKeys(text);
        barreRecherche.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"md_15\"]/div/div/span[1]/a")));

        return new ResultsPage(driver);
    }

    public ResultsPage rechercheAvecClick(String text)
    {
        barreRecherche.sendKeys(text);
        buttonRecherche.click();
        return new ResultsPage(driver);
    }
}
