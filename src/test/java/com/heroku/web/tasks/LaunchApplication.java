package com.heroku.web.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class LaunchApplication {
	public static Performable onThehomePage() {
		return Task.where("{0} opens the application",
				Open.url("http://the-internet.herokuapp.com/"));
	}

}
