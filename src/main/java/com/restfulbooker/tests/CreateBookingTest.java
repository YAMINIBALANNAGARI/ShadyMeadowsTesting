package com.restfulbooker.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.restfulbooker.pages.RestfulBookerPlatformPage;

public class CreateBookingTest {
	
	WebDriver driver = new ChromeDriver();
	Properties prop = new Properties();
	RestfulBookerPlatformPage objPage = new RestfulBookerPlatformPage(driver);
	LocalDate currentDate = LocalDate.now();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	Actions builder = new Actions(driver);

	  
	  @BeforeTest
	  public void beforeTest() throws FileNotFoundException, IOException {
		  
		  prop.load(new FileInputStream("E:\\Restful_Booker\\ShadyMeadowsTesting\\configs\\Configuration.properties"));
		  String chromeDriverPath = prop.getProperty("driverPath");
		  System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		  driver.manage().window().maximize(); 
		  driver.get(prop.getProperty("url"));
		  wait.until(ExpectedConditions.elementToBeClickable(objPage.getButtonLetMeHack()));
		  objPage.clickLetMeHack();
	  }
	  
	  @Test(priority=0)
	  public void waitToLoad() throws InterruptedException {		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(objPage.getLogo()));
		  objPage.clickBookThisRoom();
	  }

	  @Test(priority=1)
	  public void verDefaultMonth() {
		  wait.until(ExpectedConditions.visibilityOfElementLocated(objPage.getTextDefaultMonth()));
		  Assert.assertTrue(objPage.getDefaultMonth().equalsIgnoreCase(currentDate.getMonth()+" "+currentDate.getYear()));
	  }
	  
	  @Test(priority=2)
	  public void verDefaultDate() {
		  wait.until(ExpectedConditions.visibilityOfElementLocated(objPage.getCalDefaultDate()));
		  Assert.assertEquals(String.valueOf(currentDate.getDayOfMonth()), objPage.getDefaultDate());
	  }
	  	  
	  @Test(priority=3)
	  public void roomBooking() {		  
		  /*Action mouseOverHome = builder
                  .dragAndDrop((WebElement) objPage.setCalSelectDate(27), (WebElement) objPage.setCalSelectDate(28))
                  .build();
		  mouseOverHome.perform();*/
		  //builder.moveToElement((WebElement) objPage.setCalSelectDate(27)).click().perform();
		  
		 /* builder.moveToElement(objPage.setCalSelectDate(27))
          .pause(Duration.ofSeconds(1))
          .clickAndHold(objPage.setCalSelectDate(27))
          .pause(Duration.ofSeconds(1))
          .moveToElement(objPage.setCalSelectDate(28))
          .pause(Duration.ofSeconds(1))
          .release().build().perform();*/
		  
		 /* builder.clickAndHold(objPage.setCalSelectDate(27))
				    .moveToElement(objPage.setCalSelectDate(28))
				    .release()
				    .build().perform(); */
		// None of the above snippets are working for drag and drop
		  
	  }
	  
	  @AfterTest
	  public void afterTest() {
		  //driver.quit(); commented to stop browser from closing and to see if the dates were actually selected on calander
	  }

}
