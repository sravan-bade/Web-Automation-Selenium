package selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import managers.FileReaderManager;

public class Choose {

	public static void dropdownByName(WebElement dropdownElement, String dropdownName) {
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByValue(dropdownName);
	}

	public static void dropdownByIndex(WebElement dropdownElement, int dropdownID) {
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByIndex(dropdownID);
	}

	public static void hoverOnElement(WebDriver driver, WebElement element) {
		Actions builder = new Actions(driver);
		Action hoverOnElement = builder.moveToElement(element).build();
		hoverOnElement.perform();
	}

	public static void download(WebElement downloadButtonElement) throws InterruptedException, IOException {
		String sourcelocation = downloadButtonElement.getAttribute("href");
		String wget_command = "wget -P " + System.getProperty("user.dir") + "/target/ --no-check-certificate "
				+ sourcelocation;
		System.out.println(wget_command);
		try {
			Process exec = Runtime.getRuntime().exec(wget_command);
			int exitVal = exec.waitFor();
			System.out.println("Exit value: " + exitVal);
		} catch (InterruptedException | IOException ex) {
			System.out.println(ex.toString());
		}
	}

	public static void verifydownload(String fileName) {
		String downloadPath = System.getProperty("user.dir") + "/target/";
		System.out.println(downloadPath);
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				// File has been found, it can now be deleted:
				System.out.println("File found");
				// dirContents[i].delete();
				// return true;
			}
		}
		// return false;
	}

}