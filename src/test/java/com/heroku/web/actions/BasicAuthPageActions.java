package com.heroku.web.actions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.heroku.web.pages.BasicAuthPage;

import net.thucydides.core.annotations.Step;

public class BasicAuthPageActions {
	BasicAuthPage authPage;

	@Step
	public void openHerokuHomePage(String username,String password) {
		authPage.launchAppWithBasicAuth(username,password);
	}

	@Step	
	public void assertAuthMsg(String expMsg) {
		Assert.assertTrue(authPage.getAuthMsg().contains(expMsg));
	}
	
}