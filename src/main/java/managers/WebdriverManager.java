package managers;

import enums.DriverType;
import enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.DriverManagerType.*;

;

public class WebdriverManager {
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private WebDriver driver;

    public WebdriverManager() {
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
    }

    public WebDriver getDriver() {
        if (driver == null)
            driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL:
                driver = createLocalDriver();
                break;
            case REMOTE:
                driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    @SuppressWarnings("deprecation")
    private WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX:
                WebDriverManager.getInstance(FIREFOX).setup();
                driver = new FirefoxDriver();
                break;
            case CHROME:
                WebDriverManager.getInstance(CHROME).setup();

                String downloadFilepath = System.getProperty("user.dir") + "\\target\\";
                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.default_directory", downloadFilepath);
                ChromeOptions options = new ChromeOptions();
                //options.add_argument("--window-size=1920,1080");

                //options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");
                options.setExperimentalOption("prefs", chromePrefs);

                DesiredCapabilities cap = DesiredCapabilities.chrome();
                cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                cap.setCapability(ChromeOptions.CAPABILITY, options);

                driver = new ChromeDriver(cap);

                //driver = new ChromeDriver();
                break;
            case EDGE:
                WebDriverManager.getInstance(EDGE).setup();
                driver = new EdgeDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            case INTERNETEXPLORER:
                WebDriverManager.getInstance(IEXPLORER).setup();
                driver = new InternetExplorerDriver();
                break;
            case OPERA:
                WebDriverManager.getInstance(OPERA).setup();
                driver = new OperaDriver();
                break;
            case PHANTOMJS:
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setJavascriptEnabled(true);
                // WebDriverManager.getInstance(PHANTOMJS).setup();
                capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                        System.getProperty("user.dir") + FileReaderManager.getInstance().getConfigReader().getDriverPath());
                driver = new PhantomJSDriver(capabilities);
                break;
            case CHROME_HEADLESS:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                WebDriverManager.getInstance(CHROME).setup();
                driver = new ChromeDriver(chromeOptions);
                break;
        }

        if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
            driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
                TimeUnit.SECONDS);
        return driver;
    }

    public void closeDriver() {
        driver.close();
    }

    public void quitDriver() {
        driver.quit();
    }

}