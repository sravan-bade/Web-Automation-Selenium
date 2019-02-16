package stepDefinitions;

import java.io.IOException;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.SampleDownloadPage;

public class SampleDownloadPageSteps {

	TestContext testContext;
	SampleDownloadPage sampleDownloadPage;

	public SampleDownloadPageSteps(TestContext context) {
		testContext = context;
		sampleDownloadPage = testContext.getPageObjectManager().getSampleDownloadPage();
	}

	@Given("^user is on Sample videos page$")
	public void user_is_on_Yahoo_html_Page() {
		sampleDownloadPage.navigateTo_SampleDownloadPage();
	}

	@When("^he download the file$")
	public void he_download_the_file() throws InterruptedException, IOException {
		sampleDownloadPage.download10kbfile();
	}
	
	@Then("^file should be downloaded$")
	public void file_should_be_downloaded() {
		//homePage.perform_Search(product);
		String fileName = "SampleTextFile_10kb.txt";
		sampleDownloadPage.verifydownloadedfile(fileName);
	}

}