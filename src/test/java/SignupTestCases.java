import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class SignupTestCases extends BaseTest{
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(1000);

    @Test
    public void serviceProviderRegistrationSignUpSuccess() throws InterruptedException {
        serviceProviderSignUpPageLink();
        firstName("Emad");
        lastName("Alghweir");
        businessName("Testpro");
        phoneNumber("1234567890");
        email("username" + randomInt + "@ gmail.com");
        passwordInput("Testing123456!");
        checkBox();
        createAccountButton();

       // String actualText = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-danger"))).getText();
        Assert.assertEquals(actualText, "Congratulations! Your account has been created successfully!");
    }

    @Test
    public void serviceProviderRegistrationSignUpWrongEmail() throws InterruptedException {
        serviceProviderSignUpPageLink();
        firstName("hello");
        lastName("QA");
        businessName("here");
        phoneNumber("9876543210");
        email("hellohellohellohellohellohellohellohellohellohellohellohellohello" + randomInt + "@1234567890101112131415.com");
        password();

        //String actualText = driver.findElement(By.xpath("//div/app-field-error-display/div//small")).getText();
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/app-field-error-display/div//small"))).getText();
        Assert.assertEquals(actualText, "Please enter your Email address");
    }

    @Test
    public void serviceProviderRegistrationSignUpEmptyCredentials() throws InterruptedException {

        serviceProviderSignUpPageLink();
        firstName("");
        lastName("");
        businessName("");
        phoneNumber("");
        email("");
        passwordInput("");
        createAccountButton();

       //String actualText = driver.findElement(By.cssSelector("type*=submit")).getText();
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("type*=submit"))).getText();
        Assert.assertEquals(actualText, false);

    }

      public void serviceProviderSignUpPageLink(){

        driver.get("https://kwidos.com/auth/register/contractor");
    }
      public void firstName(String firstName){

         // driver.findElement(By.cssSelector("[formcontrolname='firstName']")).sendKeys(firstName);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='firstName']"))).sendKeys(firstName);
    }
    public void lastName(String lastName){

     //driver.findElement(By.cssSelector("[formcontrolname='lastName']")).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='lastName']"))).sendKeys(lastName);

    }
    public void businessName(String businessName){

       // driver.findElement(By.cssSelector("[formcontrolname='businessName']")).sendKeys(businessName);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='businessName']"))).sendKeys(businessName);
    }
    public void phoneNumber(String PhoneNumber){

        //driver.findElement(By.cssSelector("[formcontrolname='phone']")).sendKeys(PhoneNumber);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='phone']"))).sendKeys(PhoneNumber);
    }
      public void email(String Email){

       // driver.findElement(By.cssSelector("[formcontrolname='email']")).sendKeys(Email);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='email']"))).sendKeys(Email);
    }
      public void password(){

      //  driver.findElement(By.cssSelector("[formcontrolname='password']")).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='password']"))).click();
    }
      public void passwordInput(String Password){

         // driver.findElement(By.cssSelector("[formcontrolname='password']")).sendKeys(Password);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='password']"))).sendKeys(Password);
      }
      public void checkBox(){

      //  driver.findElement(By.cssSelector("[class*='ui-chkbox ui']")).click();
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='ui-chkbox ui']"))).click();

    }
      public void createAccountButton(){

      //  driver.findElement(By.cssSelector("type*=submit")).click();
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("type*=submit"))).click();

    }

}

