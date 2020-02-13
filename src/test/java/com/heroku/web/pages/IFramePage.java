package com.heroku.web.pages;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Switch;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.pages.PageObject;

//@NamedUrls(
//		{
//			@NamedUrl(name = "open.iframe", url = "https://the-internet.herokuapp.com/{1}")
//		}		
//)
public class IFramePage extends PageObject{

	@FindBy(xpath="//span[text()='File']")
	private WebElementFacade fileMenu;
	
	@FindBy(xpath="//span[text()='New document']")
	private WebElementFacade newDocumentSubMenu;
	
	@FindBy(id="tinymce")
	private WebElementFacade documentTextArea;	

	public IFramePage(WebDriver driver) {
	    super(driver);
	}
	
	public void clickFileMenu() {
		fileMenu.click();
		
	}

	public void clickOnNewDocument() {
		newDocumentSubMenu.click();
	}

	public void typeTextOnNewDocumentTextArea(String text) {
		getDriver().switchTo().frame(0);		
		evaluateJavascript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '" + text +"' }", documentTextArea);
		getDriver().switchTo().parentFrame();
	}


}
