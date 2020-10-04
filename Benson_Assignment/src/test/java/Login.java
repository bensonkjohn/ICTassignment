import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private WebDriver driver;

    private By txtUserName=By.className ("_2zrpKA");
    private By txtPassword=By.xpath ("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input");
    private By txtLogin=By.xpath ("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button");
    public Login(WebDriver driver){
        this.driver=driver;
    }

    public void Login(String userName,String password){
        driver.findElement(txtUserName).sendKeys(userName);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(txtLogin).click();
    }


}
