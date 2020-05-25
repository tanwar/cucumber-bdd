package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestHooks {

	@Before("@SmokeTest")
	public void beforeTest(Scenario scenario) {
		System.out.println(scenario.getName() + " before hook");
	}

	@After("@NightlyTest")
	public void afterTest(Scenario scenario) {
		System.out.println(scenario.getName() + " after hook");
	}

}
