import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AdvancedTests extends BaseTest{

    @Test
    public void multipleTabs(){
       driver.get("https://kwidos.tk/share");

        String mainwindow = driver.getWindowHandle();

        driver.findElement(By.xpath("//*[contains(text(), 'Twitter')")).click();

        String twitterWindow = driver.getWindowHandle();

        driver.switchTo().window(mainwindow); //to switch windows to main window.

        driver.switchTo().window(twitterWindow);

    }

    @Test
    public void scrollingTest() {
        driver.get("https://kwidos.tk/contractor/search");

        WebElement job = driver.findElement(By.xpath("//*[contains(text(), 'NEU')]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView()", job);

    }
    @Test
    public void KeysTest() {
        driver.get("https://kwidos.com/auth/login");

        WebElement element = driver.findElement(By.cssSelector("#email"));

        Actions builder = new Actions(driver);

        Action seriesOfAction = builder
                .moveToElement(element)
                .click()
                .sendKeys(element, "WHATSUP")
                .doubleClick(element)
                .contextClick()
                .build();

         seriesOfAction.perform();
    }
    @Test
    public void hoveringTest() {
        driver.get("https://chercher.tech/practice-pop-ups-selenium-webdriver");

        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.cssSelector("#sub-menu"));

        Action mouseOverHome = builder.moveToElement(element).build();
        mouseOverHome.perform();

        driver.findElement(By.cssSelector("#link2")).click();

    }

    //google-mapsExample
    @Test
    public void frames() {
        driver.get("https://testpro.io/");
        driver.switchTo().frame(0).findElement(By.cssSelector("#mapDiv"));

       }

    @Test
    public void clearCookiesTestExample() {
        driver.get("https://kwidos.tk");

        driver.manage().deleteAllCookies();

        driver.get("https://kwidos.tk");
    }

    }
