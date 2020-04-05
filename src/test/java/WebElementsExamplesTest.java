import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;

public class WebElementsExamplesTest extends BaseTest {

    @Test

    public void dropDownExample() throws InterruptedException {

        driver.get("http://demo.guru99.com/test/newtours/register.php");

        Select dropdown = new Select(driver.findElement(By.cssSelector("[name='country']")));

        //  dropdown.selectByVisibleText("ARGENTINA");
          dropdown.selectByIndex(5); //this is will select the sixth element of the drop down.


        WebElement option = dropdown.getFirstSelectedOption();
        System.out.println(option.getText());

        List<WebElement> options = dropdown.getOptions();

        for ( WebElement singleOption: options) {
            System.out.println(singleOption.getText());
        }


    }

    @Test
    public void checkBoxExample() throws InterruptedException {

        driver.get("http://demo.guru99.com/test/radio.html");


        WebElement checkbox =  driver.findElement(By.id("vfb-6-1"));

        driver.findElement(By.id("vfb-6-1")).click();

     // driver.findElement(By.cssSelector("#vfb-6-1"));
     //  driver.findElement(By.xpath("//*[@id='vfb-6-1']"));

        checkbox.click();

        Assert.assertTrue(checkbox.isSelected());

    }

    @Test
    public void alertExample() throws InterruptedException {

        driver.get("http://demo.guru99.com/test/delete_customer.php");

        driver.findElement(By.cssSelector("[name='submit']")).click();

        driver.switchTo().alert().dismiss(); //this is to select the cancel button.

      //  driver.switchTo().alert().accept(); //This is to select okay or accept form the alert pop-up.

       // driver.switchTo().alert().getText(); //This is to capture the alert message.

      // driver.switchTo().alert().sendKeys("put whatever you want here"); //This is to send some data to the alert box





    }

    }



