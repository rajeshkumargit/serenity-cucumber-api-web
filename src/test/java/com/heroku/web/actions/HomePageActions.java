package com.heroku.web.actions;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.heroku.web.pages.HomePage;

//import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;
import static org.junit.matchers.JUnitMatchers.*;


public class HomePageActions {
	HomePage homePage;

	@Step
	public void openPath(String path) {
		String[] param = {path};
		homePage.open("open.disappear",param);
	}
	
	@Step
	public void clickOnHomeTab() {
		homePage.clickOnHomeTab();
	}
	
	@Step
	public void assertHomePageDisplayed(String homeTitle) {
		Assert.assertTrue(homePage.getPageTitle().contains(homeTitle));
	}

		
}
	
	
	
