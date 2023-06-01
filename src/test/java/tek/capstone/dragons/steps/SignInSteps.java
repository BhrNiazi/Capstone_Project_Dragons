package tek.capstone.dragons.steps;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import tek.capstone.dragons.pages.POMFactory;
import tek.capstone.dragons.utilities.CommonUtility;
import tek.capstone.dragons.utilities.DataGenerator;

public class SignInSteps extends CommonUtility {

	POMFactory factory = new POMFactory();

	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String expectedTitle = "React App";
		String actualTitle = getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		logger.info("User is on retail website");

	}

	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
		click(factory.retailsigninpage().singInOption);
		logger.info("User clicked on signin option successfully");

	}

	@When("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String email, String password) {
		// sendText(WebElement element, String value)
		sendText(factory.retailsigninpage().emailInput, email);
		sendText(factory.retailsigninpage().passwordInput, password);
		logger.info(email + "email was entered successfully");
		logger.info(password + "password was entered successfully");

	}

	@When("User click on login button")
	public void userClickOnLoginButton() {
		click(factory.retailsigninpage().loginBttn);
		logger.info("user was able to login successfully");
	}

	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
		waitTillPresence(factory.retailsigninpage().logoutOption);
		waitTillPresence(factory.retailsigninpage().accountBttn);
		Assert.assertTrue(isElementDisplayed(factory.retailsigninpage().logoutOption));
		Assert.assertTrue(isElementDisplayed(factory.retailsigninpage().accountBttn));
		logger.info("user was able to see the Account and lohout option");

		/*String pageTitleExpected = "React App";
		String pageTitleActual = getTitle();
		Assert.assertEquals(pageTitleExpected, pageTitleActual);
		logger.info("User logged in into the account");*/
		
}

	@Then("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(factory.retailsigninpage().newAccountBttn);
		logger.info("New account button was clicked");
	}

	@Then("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			
			String email = DataGenerator.getEmail();
			sendText(factory.retailsigninpage().nameField, row.get("name"));
			sendText(factory.retailsigninpage().emailField, email);
			sendText(factory.retailsigninpage().passwordField, row.get("password"));
			sendText(factory.retailsigninpage().passConfirmField, row.get("confirmPassword"));
			logger.info("Registration info entered");
		}
	}

	@Then("User click on SignUp button")
	public void userClickOnSignUpButton() {
		click(factory.retailsigninpage().signUPBttn);
		logger.info("Sign up button was clicked");
	}

	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() {
		waitTillPresence(factory.retailsigninpage().logoutOption);
		waitTillPresence(factory.retailsigninpage().accountBttn);
		Assert.assertTrue(isElementDisplayed(factory.retailsigninpage().logoutOption));
		Assert.assertTrue(isElementDisplayed(factory.retailsigninpage().accountBttn));
		logger.info("user was able to see the Account and logout option");

	}
}