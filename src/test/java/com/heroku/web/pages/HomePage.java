package com.heroku.web.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.WhenPageOpens;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.Pages;

import static org.junit.Assert.assertTrue;

import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://the-internet.herokuapp.com/")

@NamedUrls(
		{
			@NamedUrl(name = "open.disappear", url = "https://the-internet.herokuapp.com/{1}")
		}		
)
public class HomePage extends PageObject{
	@FindBy(linkText = "Home")
	private WebElement homeTab;
	
	@FindBy(css = ".heading")
	private WebElement pageTitle;
	
	public HomePage(WebDriver driver) {
	    super(driver);
	}
	
	public void clickOnHomeTab() {
		element(homeTab).click();
	}
	
	public String getPageTitle() {
		return element(pageTitle).getText();
	}
	


}
