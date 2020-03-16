import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class LoginTestCases {
    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        driver.get("https://kwidos.com/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

    @Test
    public void LoginCorrectCredentialsTest() throws InterruptedException {

        //email locator
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#email")).sendKeys("ealghweir@yahoo.com");
        //password locator
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#password")).sendKeys("Testing123!");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[type='submit']")).click();

        String actualText = driver.findElement(By.xpath("//*[@class= 'title']")).getText(); //Wont work because of captcha.
        Assert.assertEquals(actualText, "Let's get it started!");

    }
    @Test
    public void LoginEmptyCredentialsTest() throws InterruptedException {

        //email locator
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#email")).sendKeys("");
        //password locator
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#password")).sendKeys("");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[type='submit']")).click();

        String emailErrorMessage = driver.findElement(By.cssSelector("input#email+div")).getText();
        Assert.assertEquals(emailErrorMessage, "Email is required");

        String passwordErrorMessage = driver.findElement(By.cssSelector("input#password+div+div")).getText();
        Assert.assertEquals(passwordErrorMessage, "Password is required");

    }
    @Test
    public void LoginWrongCredentialsTest() throws InterruptedException {

        //email locator
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#email")).sendKeys("wrong@email.com");
        //password locator
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#password")).sendKeys("wrongpassword");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[type='submit']")).click();

        String actualText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText(); //Wont work because of captcha.
        Assert.assertEquals(actualText, "Username or password is incorrect");

    }

    @Test
    public void loginWrongCredentialsWrongEmailExistingPassword() throws InterruptedException {

        //email locator
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#email")).sendKeys("wrong@email.com");
        //password locator
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#password")).sendKeys("Testing123!"); //using an existing password
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[type='submit']")).click();

        String actualText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText(); //Wont work because of captcha.
        Assert.assertEquals(actualText, "Username or password is incorrect");
        driver.quit();
    }

    @Test
    public void LoginWrongCredentialsExistingEmailWrongPassword() throws InterruptedException {

        //email locator
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#email")).sendKeys("ealghweir@yahoo.com");
        //password locator
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#password")).sendKeys("wrongpassword");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[type='submit']")).click();

        String actualText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText(); //Wont work because of captcha.
        Assert.assertEquals(actualText, "Username or password is incorrect");
        driver.quit();
    }
    @Test
    public void LoginCredentialsCaseSensitiveAllCaps() throws InterruptedException {

        //email locator
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#email")).sendKeys("EALGHWEIR@yahoo.com");
        //password locator
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#password")).sendKeys("Testing123!");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[type='submit']")).click();

        String actualText = driver.findElement(By.xpath("//*[@class= 'title']")).getText(); //Wont work because of captcha.
        Assert.assertEquals(actualText, "Let's get it started!");
        driver.quit();
    }


}