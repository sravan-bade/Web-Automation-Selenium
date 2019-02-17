package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import selenium.Choose;

public class SampleDownloadPage {
	WebDriver driver;

	public SampleDownloadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@data='1']")
	private WebElement tenkbfile;

	public void navigateTo_SampleDownloadPage() {
		driver.get("https://sample-videos.com/download-sample-text-file.php");
	}

	public void download10kbfile() throws InterruptedException, IOException {
		// tenkbfile.click();
		Choose.download(tenkbfile);
	}

	public void verifydownloadedfile(String fileName) {
		Choose.verifydownload(fileName);
	}

}