import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class C4_AddProduct extends ReportMethod{

    @Test(priority = 0)
    public void verification() throws InterruptedException, IOException
    {
        ReportResult = bensonreport.createTest ("cartcountverification");
        WebDriver driver = Driver.openBrowser ("chrome", "https://www.flipkart.com/");
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (40, TimeUnit.SECONDS);
        driver.findElement (By.className ("_29YdH8")).click ();
        driver.findElement (By.xpath (" //*[@id='container']/div/div[1]/div[1]/div[2]/div[5]/div/div/a")).click ();
        String ExpectedCart="My Cart";
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        String Actualcart=  wait1.until (ExpectedConditions.presenceOfElementLocated (By.xpath ("//div[contains(text(),'My Cart')]"))).getText ();
        Assert.assertEquals (Actualcart,ExpectedCart);
        Driver.closeBrowser ();
        bensonreport.flush ();
    }
    @Test(priority = 1)
    public void cartadd()throws IOException {
        ReportResult = bensonreport.createTest ("cartadditem");
        WebDriver driver = Driver.openBrowser ("chrome", "https://www.flipkart.com/");
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (40, TimeUnit.SECONDS);
        driver.findElement (By.className ("_29YdH8")).click ();
        driver.findElement (By.name ("q")).sendKeys ("flower" + Keys.ENTER);
        driver.manage ().timeouts ().implicitlyWait (40, TimeUnit.SECONDS);

        driver.findElement (By.xpath ("//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div[1]/div/a[2]")).click ();
        Set<String> ids = driver.getWindowHandles ();
        Iterator<String> it = ids.iterator ();
        String parentId = it.next ();
        String childId = it.next ();
        driver.switchTo ().window (childId);
        driver.findElement (By.xpath ("//*[@id='container']/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")).click ();
        driver.findElement (By.xpath ("//div[contains(text(),'My Cart (1)')]"));
        Driver.closeBrowser ();
        bensonreport.flush ();
    }}
