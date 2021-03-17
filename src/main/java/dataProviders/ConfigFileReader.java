package dataProviders;

import enums.DriverType;
import enums.EnvironmentType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private final String propertyFilePath = "configs//Configuration.properties";
    private Properties properties;

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getDriverPath() {
        String driverPath = null;
        String os = System.getProperty("os.name").toLowerCase();
        String browserName = properties.getProperty("browser");
        if (os.contains("mac")) {
            if (browserName.equals("phantomjs")) {
                driverPath = properties.getProperty("macPhantomJSPath");
                return driverPath;
            } else {
                throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
            }
        } else if (os.contains("windows")) {
            if (browserName.equals("phantomjs")) {
                driverPath = properties.getProperty("windowsPhantomJSPath");
                return driverPath;
            } else {
                throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
            }
        } else if (os.contains("linux") || os.contains("ubuntu")) {
            if (browserName.equals("phantomjs")) {
                driverPath = properties.getProperty("linuxPhantomJSPath");
                return driverPath;
            } else {
                throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
            }
        } else
            throw new RuntimeException("PhantomJS driverPath Configured for Windows, Mac and Linux.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) {
            try {
                return Long.parseLong(implicitlyWait);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
            }
        }
        return 30;
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null)
            return url;
        else
            throw new RuntimeException(
                    "Application Url not specified in the Configuration.properties file for the Key:url");
    }

    public DriverType getBrowser() {
        String browserName = properties.getProperty("browser");
        if (browserName == null || browserName.equals("chrome"))
            return DriverType.CHROME;
        else if (browserName.equalsIgnoreCase("firefox"))
            return DriverType.FIREFOX;
        else if (browserName.equals("iexplorer"))
            return DriverType.INTERNETEXPLORER;
        else if (browserName.equals("edge"))
            return DriverType.EDGE;
        else if (browserName.equals("safari"))
            return DriverType.SAFARI;
        else if (browserName.equals("opera"))
            return DriverType.OPERA;
        else if (browserName.equals("phantomjs"))
            return DriverType.PHANTOMJS;
        else if (browserName.equals("chrome_headless"))
            return DriverType.CHROME_HEADLESS;

        else
            throw new RuntimeException(
                    "Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }

    public EnvironmentType getEnvironment() {
        String environmentName = properties.getProperty("environment");
        if (environmentName == null || environmentName.equalsIgnoreCase("local"))
            return EnvironmentType.LOCAL;
        else if (environmentName.equals("remote"))
            return EnvironmentType.REMOTE;
        else
            throw new RuntimeException(
                    "Environment Type Key value in Configuration.properties is not matched : " + environmentName);
    }

    public Boolean getBrowserWindowSize() {
        String windowSize = properties.getProperty("windowMaximize");
        if (windowSize != null)
            return Boolean.valueOf(windowSize);
        return true;
    }

    public String getTestDataResourcePath() {
        String testDataResourcePath = properties.getProperty("testDataResourcePath");
        if (testDataResourcePath != null)
            return System.getProperty("user.dir") + testDataResourcePath;
        else
            throw new RuntimeException(
                    "Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    public String getReportConfigPath() {
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if (reportConfigPath != null)
            return System.getProperty("user.dir") + reportConfigPath;
        else
            throw new RuntimeException(
                    "Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }
}