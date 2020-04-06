import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class LoginTestCases extends BaseTest{

    @Test
    public void LoginCorrectCredentialsTest() throws InterruptedException {
        loginPage();
        enterEmail("ealghweir@yahoo.com");
        enterPassword("Testing123!");
        clickSubmitButton();

        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='title']"))).getText(); //Wont work because of captcha.
        Assert.assertEquals(actualText, "Let's get it started!");
    }
    @Test
    public void LoginEmptyCredentialsTest() throws InterruptedException {
        loginPage();
        enterEmail("");
        enterPassword("");
        clickSubmitButton();

        String emailErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email+div"))).getText();
        Assert.assertEquals(emailErrorMessage, "Email is required");

        String passwordErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#password+div+div"))).getText();
        Assert.assertEquals(passwordErrorMessage, "Password is required");
    }

    @Test
    public void LoginWrongCredentialsTest() throws InterruptedException {
        loginPage();
        enterEmail("wrong@email.com");
        enterPassword("wrongpassword");
        clickSubmitButton();

        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-danger"))).getText(); //Wont work because of captcha.
        Assert.assertEquals(actualText, "Username or password is incorrect");

    }
    @Test
    public void loginWrongCredentialsWrongEmailExistingPassword() throws InterruptedException {
        loginPage();
        enterEmail("wrong@email.com");
        enterPassword("Testing123!");
        clickSubmitButton();

        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-danger"))).getText(); //Wont work because of captcha.
        Assert.assertEquals(actualText, "Username or password is incorrect");
    }
    @Test
    public void LoginWrongCredentialsExistingEmailWrongPassword() throws InterruptedException {
        loginPage();
        enterEmail("ealghweir@yahoo.com");
        enterPassword("wrongpassword");
        clickSubmitButton();

        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-danger"))).getText(); //Wont work because of captcha.
        Assert.assertEquals(actualText, "Username or password is incorrect");
    }
    @Test
    public void LoginCredentialsCaseSensitiveAllCaps() throws InterruptedException {
        loginPage();
        enterEmail("EALGHWEIR@yahoo.com");
        enterPassword("Testing123!");
        clickSubmitButton();

        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='title']"))).getText(); //Wont work because of captcha.
        Assert.assertEquals(actualText, "Let's get it started!");
  }
   // @Test
   // public void clearCookiesTestExample() {
      //  loginPage();
       // enterEmail("ealghweir@yahoo.com");
       // enterPassword("Testing123!");
       // clickSubmitButton();

      //  driver.findElement(By.xpath("//*[contains(text(), 'NEU')]Go TO PROFILE"));
      //  driver.manage().deleteAllCookies();

      //  driver.get("https://kwidos.tk");

 // }
    public void loginPage(){

        driver.get("https://kwidos.com/auth/login");
  }
    public void enterEmail(String Email){

       // driver.findElement(By.cssSelector("#email")).sendKeys(Email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email"))).click();
  }
    public void enterPassword(String Password){

     //driver.findElement(By.cssSelector("#password")).sendKeys(Password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password"))).click();
  }
    public void clickSubmitButton() {

     //driver.findElement(By.cssSelector("[type='submit']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']"))).click();
  }

}