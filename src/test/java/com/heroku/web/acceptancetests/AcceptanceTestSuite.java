package com.heroku.web.acceptancetests;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/", glue= {"com.heroku.web.steps","com.dummy.api.steps"}, tags= {"@all-web,@rest-all"})
public class AcceptanceTestSuite {

}
