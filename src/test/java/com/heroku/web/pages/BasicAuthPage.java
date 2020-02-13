package com.heroku.web.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.Pages;

//@DefaultUrl("http://the-internet.herokuapp.com/")
public class BasicAuthPage extends PageObject {
	
    @FindBy(xpath="//div/p")
    private WebElement authMsg;

	
	public BasicAuthPage(WebDriver driver) {
	    super(driver);
	}
	
	
	public void launchAppWithBasicAuth(String username,String password){
		Pages pages = new Pages();
		String url= pages.getConfiguration().getEnvironmentVariables().getProperty(ThucydidesSystemProperty.WEBDRIVER_BASE_URL.getPropertyName());
		String urlSplit = url.split("http://")[1];
		String launchURL = String.format("http://%s:%s@%s/basic_auth",username,password,urlSplit);
		getDriver().get(launchURL);
	}
	
	public String getAuthMsg() {
		String msgText = element (authMsg).getText();
		return msgText;
	}

}

