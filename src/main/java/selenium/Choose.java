package selenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

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
		String wget_command = null;
		String sourcelocation = downloadButtonElement.getAttribute("href");
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("mac")) {
			wget_command = "rm wget -P " + System.getProperty("user.dir") + "/target/ --no-check-certificate "
					+ sourcelocation;
			System.out.println(wget_command);
		} else if (os.contains("linux")) {
			wget_command = "wget -P " + System.getProperty("user.dir") + "/target/ --no-check-certificate "
					+ sourcelocation;
			System.out.println(wget_command);
		} else if (os.contains("windows")) {
			wget_command = "cmd /c wget -P " + System.getProperty("user.dir") + "/target/ --no-check-certificate "
					+ sourcelocation;
			System.out.println(wget_command);
		}
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

	public static void accept_alert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public static void dismiss_alert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public static String get_AlertText(WebDriver driver) {
		String alert_text = driver.switchTo().alert().getText();
		return alert_text;
	}
}