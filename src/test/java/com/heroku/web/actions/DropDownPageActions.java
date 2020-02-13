package com.heroku.web.actions;

import org.junit.Assert;
import com.heroku.web.pages.DropDownPage;

import net.thucydides.core.annotations.Step;


public class DropDownPageActions {
	DropDownPage dropDownPage;
	
//	@Step
//	public void openPath(String path) {
//		String[] param = {path};
//		dropDownPage.open("open.dropdown",param);
//	}
	
	@Step
	public void selectDropDown(String item) {
		dropDownPage.selectOptionFromDropdown(item);
	}
	
	@Step
	public void assertSelectedValue(String exp_option) {
		Assert.assertEquals(exp_option,dropDownPage.getDropdownSelectedValue());
	}


}
