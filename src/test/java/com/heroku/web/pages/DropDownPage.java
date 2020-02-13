package com.heroku.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.pages.PageObject;

//@NamedUrls(
//		{
//			@NamedUrl(name = "open.dropdown", url = "https://the-internet.herokuapp.com/{1}")
//		}		
//)

public class DropDownPage extends PageObject {
	
	@FindBy(id="dropdown")
    private WebElementFacade dropDown;
	
	public DropDownPage(WebDriver driver) {
	    super(driver);
	}

	public void selectOptionFromDropdown(String option) {
		dropDown.click();
		dropDown.findBy(By.xpath("//option[. = '"+option+"']")).click();
	}

	public String getDropdownSelectedValue() {
		return dropDown.getSelectedVisibleTextValue();
	}
	

}
