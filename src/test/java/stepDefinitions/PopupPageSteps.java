package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.PopupPage;

public class PopupPageSteps {
	TestContext testContext;
	PopupPage popupPage;

	public PopupPageSteps(TestContext context) {
		testContext = context;
		popupPage = testContext.getPageObjectManager().getPopupPage();
	}

	@Given("^user is on Guru99 popup page$")
	public void user_is_on_Guru_popup_page() {
		popupPage.navigateTo_SampleDownloadPage();
	}

	@When("^clicks popup link$")
	public void clicks_popup_link() {
		popupPage.clickPopupLink();
	}

	@When("^submit form by entering email address as \"([^\"]*)\"$")
	public void submit_form_by_entering_email_address(String email) {
		popupPage.switchToPopupWindow();
		popupPage.enterEmail(email);
		popupPage.submitEmail();
	}

	@Then("^user should be displayed with access details$")
	public void user_should_be_displayed_with_access_details() {
		popupPage.getPopupText();
		popupPage.closePopupWindow();
		popupPage.switchToMainWindow();
	}
}
