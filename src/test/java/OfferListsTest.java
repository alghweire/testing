import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OfferListsTest extends BaseTest{

    @Test
     public void OfferListSizeTest () throws InterruptedException{
        offersLink();

        List<WebElement> cardLists = driver.findElements(By.cssSelector("[class*='card-shape']"));
        Assert.assertEquals(cardLists.size(),10);
        System.out.println( " There are exactly " + cardLists.size() + " cards");
    }
    @Test
     public void FilterByServiceTypeTest () throws InterruptedException {
        offersLink();
        select();
        threeDCaptureFromSelectDropDown();

          List<WebElement> serviceTypeCards = driver.findElements(By.cssSelector("[class*='service-type-flex']"));
            Assert.assertEquals(serviceTypeCards.size(),10);

          for(WebElement element: serviceTypeCards){
            Assert.assertEquals(element.getText(),"3D Capture");
          }
    }
      public void offersLink() {
         driver.get("https://kwidos.tk/offer/search");
     }
     //for(int i = 0 ; i<serviceTypeCards.size(); i++){// *** another way loop to access the list// System.out.println(serviceTypeCards.get(i));//}
      public void select(){
         driver.findElement(By.xpath("//label[contains(text(),'Service Type')]/../p-multiselect")).click();
     }
      public void threeDCaptureFromSelectDropDown(){
        driver.findElement(By.xpath("//label[contains(text(), '3D Capture')]")).click();
     }

    }


