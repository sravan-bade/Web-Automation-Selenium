package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import selenium.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SampleDownloadPage {
    WebDriver driver;
    @FindBy(how = How.XPATH, using = "//a[@data='1']")
    private WebElement tenkbfile;

    public SampleDownloadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo_SampleDownloadPage() {
        driver.get("https://sample-videos.com/download-sample-text-file.php");
    }

    public void download10kbfile() throws InterruptedException, IOException {
        //tenkbfile.click();
        Utils.download(tenkbfile);
    }

    public void verifydownloadedfile(String fileName) throws FileNotFoundException {
        Utils.verifydownload(fileName);
    }

}