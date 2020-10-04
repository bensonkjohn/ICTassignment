import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class C3_SearchProdct extends ReportMethod{

    @Test
    public void searchProduct()throws IOException {
        ReportResult = bensonreport.createTest ("searchAndSelectProduct");
        WebDriver driver = Driver.openBrowser ("chrome", "https://www.flipkart.com/");
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
        driver.findElement (By.className ("_29YdH8")).click ();
        driver.findElement (By.name ("q")).sendKeys ("flower" + Keys.ENTER);
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.presenceOfElementLocated (By.xpath ("//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/div[3]/a")));
        ReportResult.addScreenCaptureFromPath (Driver.takeScreenshot ());
        Driver.closeBrowser ();
        bensonreport.flush ();
    }

}
