package com.heroku.web.actions;

import org.junit.Assert;
import com.heroku.web.pages.DropDownPage;
import com.heroku.web.pages.IFramePage;

import net.thucydides.core.annotations.Step;

public class IFramePageActions {
	IFramePage iFramePage;
	
//	@Step
//	public void openPath(String path) {
//		String[] param = {path};
//		iFramePage.open("open.iframe",param);
//	}

	@Step
	public void selectFileMenu() {
		iFramePage.clickFileMenu();
	}
	
	@Step
	public void clickNewDocument() {
		iFramePage.clickOnNewDocument();
		
	}
	
	@Step
	public void typeOnTextArea(String text) {
		iFramePage.typeTextOnNewDocumentTextArea(text);
		
	}



}
