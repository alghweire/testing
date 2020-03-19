import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OfferListsTest {
   WebDriver driver;
    //

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
    public void OfferListsSizeTest () throws InterruptedException {




    }
}

