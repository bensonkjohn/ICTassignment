import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class C1_ValidCredentials extends ReportMethod
{
    @Test

    public void Verifydisplay()throws InterruptedException,IOException
    {
        ReportResult = bensonreport.createTest ("verifyhellosign");
        WebDriver driver = Driver.openBrowser ("chrome", "https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Reporter.log ("Flipkart is open");
        String Actual = driver.getTitle();
        String Expected = "Hello Sign";
        Assert.assertEquals(Expected, Actual);
        Driver.closeBrowser ();
    }

    @Test(priority = 1)
    public void LoginTest() throws IOException
    {
        ReportResult = bensonreport.createTest ("LoginTest");
        WebDriver driver = Driver.openBrowser ("chrome", "https://www.flipkart.com/");
        Login loginPage = new Login (driver);
        loginPage.Login ("9633878335", "Bens@12345");
        WebDriverWait wait1 = new WebDriverWait (driver, 40);
        wait1.until (ExpectedConditions.presenceOfElementLocated (By.xpath ("//*[@id='container']/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")));
        ReportResult.addScreenCaptureFromPath (Driver.takeScreenshot ());
        Driver.closeBrowser ();
        bensonreport.flush ();

    }
}

