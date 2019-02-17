package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import org.junit.Assert;

import selenium.Choose;

public class DeleteCustomerPage {
	WebDriver driver;

	public DeleteCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.NAME, using = "cusid")
	private WebElement txtbx_custID;

	@FindBy(how = How.NAME, using = "submit")
	private WebElement btn_submit;

	public void navigateTo_Demo99_DeleteCustomerPage() {
		driver.get("http://demo.guru99.com/test/delete_customer.php");
	}

	public void enter_CustomerId(String custid) {
		txtbx_custID.sendKeys(custid);
	}

	public void clear_CustomerId() {
		txtbx_custID.clear();
	}

	public void click_Submit() {
		btn_submit.click();
	}

	public void dismiss_alert() {
		Choose.dismiss_alert(driver);
	}

	public void accept_alert() {
		Choose.accept_alert(driver);
	}

	public void validate_AlertText(String alertText) {
		String actual = Choose.get_AlertText(driver);
		Assert.assertEquals(actual, alertText);
	}
}