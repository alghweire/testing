import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class HomePageTest {
     WebDriver  driver;

    @BeforeMethod
    public void setup (){
        driver = new ChromeDriver();
        driver.get("https://kwidos.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    @Test
    public void titleTest() throws InterruptedException {
        //  go to home page https://kwidos.com/
        // verify title is equal to kwidos.

        String title = driver.getTitle();
        Assert.assertEquals(title, "Kwidos");

    }


    @Test
    public void LoginWrongCredentialsTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://kwidos.com/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //email locator
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#email")).sendKeys("wrong@email.com");
        //password locator
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#password")).sendKeys("wrongpassword");

        driver.findElement(By.cssSelector("[type='submit']")).click();

        String actualText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText(); //Wont work becasue of captcha.
        Assert.assertEquals(actualText, "Username or password is incorrect");
    }

    @Test
    public void ServiceProviderRegistrationTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://kwidos.com/auth/register/contractor");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //email locator


        //random generator for different emails.
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(10000);

        Thread.sleep(4000);
        driver.findElement(By.cssSelector("[formcontrolname='firstName']")).sendKeys("Emad");
        driver.findElement(By.cssSelector("[formcontrolname='lastName']")).sendKeys("Alghweir");
        driver.findElement(By.cssSelector("[formcontrolname='businessName']")).sendKeys("Testpro");
        driver.findElement(By.cssSelector("[formcontrolname='phone']")).sendKeys("1234567890");
        driver.findElement(By.cssSelector("[formcontrolname='email']")).sendKeys("username"+ randomInt +"@gmail.com");
        driver.findElement(By.cssSelector("[formcontrolname='password']")).sendKeys("Testing123456!");
        driver.findElement(By.cssSelector(".ui-chkbox")).click();
        driver.findElement(By.cssSelector(".btn.btn-fill.btn-danger.btn-wd")).click();

        String actualText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
        Assert.assertEquals(actualText, "Username or password is incorrect");
    }

}
