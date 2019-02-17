package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pageObjects.DeleteCustomerPage;

public class DeleteCustomerPageSteps {
	TestContext testContext;
	DeleteCustomerPage deleteCustomerPage;

	public DeleteCustomerPageSteps(TestContext context) {
		testContext = context;
		deleteCustomerPage = testContext.getPageObjectManager().getDeleteCustomerPage();
	}

	@Given("^user is on Demoguru99 delete customer page$")
	public void user_is_on_Demoguru99_delete_customer_page() {
		deleteCustomerPage.navigateTo_Demo99_DeleteCustomerPage();
	}

	@When("^he tries to delete the customer id \"([^\"]*)\"$")
	public void he_tries_to_delete_the_customer_id(String customerid) {
		deleteCustomerPage.enter_CustomerId(customerid);
		deleteCustomerPage.click_Submit();
	}

	@When("^cancel the alert$")
	public void cancel_the_alert() {
		deleteCustomerPage.dismiss_alert();
	}

	@When("^modify the customer id to \"([^\"]*)\"$")
	public void modify_the_customer_id(String customerid) {
		deleteCustomerPage.clear_CustomerId();
		deleteCustomerPage.enter_CustomerId(customerid);
		deleteCustomerPage.click_Submit();
	}

	@When("^accept the alert$")
	public void accept_the_alert() {
		deleteCustomerPage.accept_alert();
	}

	@Then("^confirmation alert should be displayed$")
	public void confirmation_alert_should_be_displayed() {
		String alertText = "Customer Successfully Delete!";
		deleteCustomerPage.validate_AlertText(alertText);
		deleteCustomerPage.accept_alert();
	}

}
