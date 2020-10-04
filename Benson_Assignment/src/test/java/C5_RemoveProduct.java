import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class C5_RemoveProduct extends ReportMethod {
    @Test
    public void Remove() throws IOException {
        ReportResult = bensonreport.createTest ("RemoveFromCart");
        WebDriver driver = Driver.openBrowser ("chrome", "https://www.flipkart.com/");
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (40, TimeUnit.SECONDS);
        driver.findElement (By.className ("_29YdH8")).click ();
        driver.findElement (By.name ("q")).sendKeys ("flower" + Keys.ENTER);
        driver.findElement (By.xpath ("//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div[1]/div/a[2]")).click ();
        Set<String> ids = driver.getWindowHandles ();
        Iterator<String> it = ids.iterator ();
        String parentId = it.next ();
        String childId = it.next ();
        driver.switchTo ().window (childId);
        driver.findElement (By.xpath ("//*[@id='container']/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")).click ();
        WebDriverWait wait1 = new WebDriverWait (driver, 40);
        wait1.until (ExpectedConditions.presenceOfElementLocated (By.xpath ("//div[contains(text(),'My Cart (1)')]")));
        driver.findElement (By.xpath ("//*[@id='container']/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div[2]/div[2]")).click ();
        driver.findElement (By.xpath ("//*[@id='container']/div/div[1]/div/div[3]/div/div[2]")).click ();
        Driver.closeBrowser ();
        bensonreport.flush ();
    }
}
