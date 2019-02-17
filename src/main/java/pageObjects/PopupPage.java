package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import selenium.Choose;

public class PopupPage {
	WebDriver driver;
	String MainWindow = null;

	public PopupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[contains(@href,'popup.php')]")
	private WebElement popup_link;

	@FindBy(how = How.NAME, using = "emailid")
	private WebElement txtbx_emailID;

	@FindBy(how = How.NAME, using = "btnLogin")
	private WebElement btn_submit;

	@FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr[4]/td[2]")
	private WebElement get_userID;

	@FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr[5]/td[2]")
	private WebElement get_Password;

	public void navigateTo_SampleDownloadPage() {
		driver.get("http://demo.guru99.com/popup.php");
	}

	public void clickPopupLink() {
		popup_link.click();
		MainWindow = Choose.MainWindowHandle(driver);
	}

	public void switchToPopupWindow() {
		Choose.PopWindowHandle(driver, MainWindow);
	}

	public void enterEmail(String email) {
		txtbx_emailID.sendKeys(email);
	}

	public void submitEmail() {
		btn_submit.click();
	}

	public void getPopupText() {
		String username = get_userID.getText();
		String password = get_Password.getText();
		System.out.println(username);
		System.out.println(password);
	}

	public void closePopupWindow() {
		Choose.closePopup(driver);
	}

	public void switchToMainWindow() {
		Choose.SwitchToMainWindow(driver, MainWindow);
	}
}
