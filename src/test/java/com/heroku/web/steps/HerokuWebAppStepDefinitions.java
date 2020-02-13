package com.heroku.web.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import com.heroku.web.actions.*;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

public class HerokuWebAppStepDefinitions {
	@Steps
	BasicAuthPageActions authPageActions;
	@Steps
	HomePageActions homePageActions;
	@Steps
	DropDownPageActions dropDownPageActions;
	@Steps
	IFramePageActions iFramePageActions;
	
	@Given("application is launched with basic auth {string},{string}")
	public void application_is_launched_with_basic_auth(String username, String password) {
		authPageActions.openHerokuHomePage(username,password);
	}

	@Then("validate the authentication message {string}")
	public void validate_the_authentication_message(String expMsg) {
		authPageActions.assertAuthMsg(expMsg);
	}
	
	@Given("application is launched with path {string}")
	public void application_is_launched_with_path(String path) {
	    homePageActions.openPath(path);
	}

	@When("user clicks on the Home link")
	public void user_clicks_on_the_Home_link() {
		homePageActions.clickOnHomeTab();
	}

	@Then("user gets redirected to Home page {string}")
	public void user_gets_redirected_to_Home_page(String title) {
	    homePageActions.assertHomePageDisplayed(title);
	}

	@When("user selects the dropdown option {string}")
	public void user_selects_the_dropdown_option(String item) {
		dropDownPageActions.selectDropDown(item);
	}

	@Then("selected item appears with the option {string}")
	public void selected_item_appears_with_the_option(String option) {
		dropDownPageActions.assertSelectedValue(option);
	}

	@When("user selects the File menu")
	public void user_selects_the_File_menu() {
	    iFramePageActions.selectFileMenu();
	}

	@When("clicks on the New Document sub-menu")
	public void clicks_on_the_New_Document_sub_menu() {
		iFramePageActions.clickNewDocument();
	}

	@Then("user could type {string} on the text area")
	public void user_could_type_on_the_text_area(String text) {
		iFramePageActions.typeOnTextArea(text);
	}
	


}
