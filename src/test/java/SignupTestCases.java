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
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://kwidos.com/auth/register/contractor");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void serviceProviderRegistrationSignUpSuccess() throws InterruptedException {
        //random generator for different emails.
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);

        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[formcontrolname='firstName']")).sendKeys("Emad");
        driver.findElement(By.cssSelector("[formcontrolname='lastName']")).sendKeys("Alghweir");
        driver.findElement(By.cssSelector("[formcontrolname='businessName']")).sendKeys("Testpro");
        driver.findElement(By.cssSelector("[formcontrolname='phone']")).sendKeys("1234567890");
        driver.findElement(By.cssSelector("[formcontrolname='email']")).sendKeys("username" + randomInt + "@gmail.com");
        driver.findElement(By.cssSelector("[formcontrolname='password']")).sendKeys("Testing123456!");
        driver.findElement(By.cssSelector(".ui-chkbox")).click();
        driver.findElement(By.cssSelector("type*=submit")).click();
        String actualText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
        Assert.assertEquals(actualText, "Congratulations! Your account has been created successfully!");
    }

    @Test
    public void serviceProviderRegistrationSignUpWrongEmail() throws InterruptedException {
        //random generator for different emails.
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[formcontrolname='firstName']")).sendKeys("hello");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[formcontrolname='lastName']")).sendKeys("QA");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[formcontrolname='businessName']")).sendKeys("here");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[formcontrolname='phone']")).sendKeys("9876543210");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[formcontrolname='email']")).sendKeys("hellohellohellohellohellohellohellohellohellohellohellohellohello" + randomInt + "@1234567890101112131415.com");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[formcontrolname='password']")).click();
       // driver.findElement(By.cssSelector("type*=submit")).click();
       Thread.sleep(3000);
        String actualText = driver.findElement(By.xpath("//div/app-field-error-display/div//small")).getText();
        Assert.assertEquals(actualText, "Please enter your Email address");
    }

    @Test
    public void serviceProviderRegistrationSignUpSameCredentials() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[formcontrolname='firstName']")).sendKeys("");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[formcontrolname='lastName']")).sendKeys("");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[formcontrolname='businessName']")).sendKeys("");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[formcontrolname='phone']")).sendKeys("");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[formcontrolname='email']")).sendKeys("");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[formcontrolname='password']")).sendKeys("");
        Thread.sleep(1000);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("type*=submit")).click();
        String actualText = driver.findElement(By.cssSelector("type*=submit")).getText();
        Assert.assertEquals(actualText, false);

    }

}
