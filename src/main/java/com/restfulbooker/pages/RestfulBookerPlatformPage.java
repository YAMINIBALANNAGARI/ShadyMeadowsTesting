package com.restfulbooker.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RestfulBookerPlatformPage {
	
	WebDriver driver;
	
	private By buttonLetMeHack = By.xpath("//button[text()='Let me hack!']");
	private By logo = By.xpath("//img[@class='hotel-logoUrl']");
	By headerRooms = By.xpath("//h2[text()='Rooms']");
	By roomType = By.xpath("//h3[text()='single']");
	By buttonBookThisRoom = By.xpath("//button[text()='Book this room']");
	By buttonToday = By.xpath("//button[text()='Today']");
	By buttonBack = By.xpath("//button[text()='Back']");
	By buttonNext = By.xpath("//button[text()='Next']");
	private By textDefaultMonth = By.xpath("//span[@class='rbc-toolbar-label']");
	private By calDefaultDate = By.xpath("//div[@class='rbc-day-bg rbc-today']/../following::div[@class='rbc-date-cell rbc-now rbc-current']/button");
	//WebElement calSelectDate = driver.findElement(By.xpath("//div[@class='rbc-date-cell']/button[@class='rbc-button-link' and text()='']"));
	By inputBookingFirstName = By.xpath("//input[@name='firstname']");
	By inputBookingLastName = By.xpath("//input[@name='lastname']");
	By inputBookingEmail = By.xpath("//input[@name='email']");
	By inputBookingPhone = By.xpath("//input[@name='phone']");
	By buttonBook = By.xpath("//button[text()='Book']");
	By buttonCancel = By.xpath("//button[text()='Cancel']");
	By inputContactName = By.xpath("//div[@class='row contact']//input[@id='name']");
	By inputContactEmail = By.xpath("//div[@class='row contact']//input[@id='email']");
	By inputContactPhone = By.xpath("//div[@class='row contact']//input[@id='phone']");
	By inputContactSubject = By.xpath("//div[@class='row contact']//input[@id='subject']");
	By inputContactMessage = By.xpath("//div[@class='row contact']//textarea[@id='description']");
	By textAddress = By.xpath("//div[@class='col-sm-5']//p[text()='Shady Meadows B&B']");
	By buttonSubmit = By.xpath("//button[text()='Submit']");
	By mapPosition = By.xpath("//div[@class='pigeon-overlays']/div[@class='pigeon-click-block']");

	private WebElement calSelectDate;
	
	public RestfulBookerPlatformPage(WebDriver driver){
	        this.driver = driver;
	    }
	
	public String getDefaultDate(){
	     return driver.findElement(getCalDefaultDate()).getText();
	    }
	
	public String getDefaultMonth(){
	     return driver.findElement(getTextDefaultMonth()).getText();
	    }
	
	public void setBookingFirstName(String strFirstName){
        driver.findElement(inputBookingFirstName).sendKeys(strFirstName);
	    }
	
	public void setBookingLastName(String strLastName){
        driver.findElement(inputBookingLastName).sendKeys(strLastName);
	    }
	
	public void setBookingEmail(String strBookingEmail){
        driver.findElement(inputBookingEmail).sendKeys(strBookingEmail);
	    }
	
	public void setBookingPhone(String strBookingPhone){
        driver.findElement(inputBookingPhone).sendKeys(strBookingPhone);
	    }
	
	public void clickLetMeHack(){
        driver.findElement(getButtonLetMeHack()).click();
		}
	
	public void clickBook(){
        driver.findElement(buttonBook).click();
		}
	
	public void clickBookThisRoom(){
        driver.findElement(buttonBookThisRoom).click();
		}
	
	public void clickCancel(){
        driver.findElement(buttonCancel).click();
		}

	public By getButtonLetMeHack() {
		return buttonLetMeHack;
	}

	public By getLogo() {
		return logo;
	}

	public By getTextDefaultMonth() {
		return textDefaultMonth;
	}

	public By getCalDefaultDate() {
		return calDefaultDate;
	}

	public WebElement getCalSelectDate() {
		return calSelectDate;
	}

	public WebElement setCalSelectDate(int calSelectDate) {
		this.calSelectDate = driver.findElement(By.xpath("//div/button[@class='rbc-button-link' and text()="+ "'"+calSelectDate+"'"+"]/.."));
		return getCalSelectDate(); 
	}

 
        
}
