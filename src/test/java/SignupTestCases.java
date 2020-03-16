import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SignupTestCases {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://kwidos.com/auth/register/contractor");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void TearDown() {
        driver.quit();
    }

    @Test
    public void serviceProviderRegistrationSignUpFlowTest() throws InterruptedException {
        //random generator for different emails.
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(10000);

        Thread.sleep(4000);
        driver.findElement(By.cssSelector("[formcontrolname='firstName']")).sendKeys("Emad");
        driver.findElement(By.cssSelector("[formcontrolname='lastName']")).sendKeys("Alghweir");
        driver.findElement(By.cssSelector("[formcontrolname='businessName']")).sendKeys("Testpro");
        driver.findElement(By.cssSelector("[formcontrolname='phone']")).sendKeys("1234567890");
        driver.findElement(By.cssSelector("[formcontrolname='email']")).sendKeys("username" + randomInt + "@gmail.com");
        driver.findElement(By.cssSelector("[formcontrolname='password']")).sendKeys("Testing123456!");
        driver.findElement(By.cssSelector(".ui-chkbox")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("type*=submit")).click();
        String actualText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
        Assert.assertEquals(actualText, "Congratulations! Your account has been created successfully!");
    }

    @Test
    public void serviceProviderRegistrationSignUpFirstNameWithANumber() throws InterruptedException {
        //random generator for different emails.
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(10000);

        Thread.sleep(4000);
        driver.findElement(By.cssSelector("[formcontrolname='firstName']")).sendKeys("" + randomInt);
        driver.findElement(By.cssSelector("[formcontrolname='firstName']")).sendKeys();
        String actualText = driver.findElement(By.cssSelector("[class='form-control ng-touched ng-dirty ng-invalid']")).getText();
        Assert.assertEquals(actualText, "Please enter your First name");
    }

    @Test
    public void serviceProviderRegistrationSignUpWithSameCredentials() throws InterruptedException {
        //random generator for different emails.
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("[formcontrolname='firstName']")).sendKeys("Emad");
        driver.findElement(By.cssSelector("[formcontrolname='lastName']")).sendKeys("Alghweir");
        driver.findElement(By.cssSelector("[formcontrolname='businessName']")).sendKeys("TestingThis");
        driver.findElement(By.cssSelector("[formcontrolname='phone']")).sendKeys("1234567890");
        driver.findElement(By.cssSelector("[formcontrolname='email']")).sendKeys("testing@test.com");
        driver.findElement(By.cssSelector("[formcontrolname='password']")).sendKeys("Testing123456!");
        driver.findElement(By.cssSelector(".ui-chkbox")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("type*=submit")).click();
        String actualText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
        Assert.assertEquals(actualText, "User already exists");

    }

}
