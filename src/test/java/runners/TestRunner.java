package runners;

import com.cucumber.listener.Reporter;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.github.mkolisnyk.cucumber.runner.ExtendedParallelCucumber;
import cucumber.api.CucumberOptions;
import managers.FileReaderManager;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(ExtendedParallelCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
        threadsCount = 3,
        retryCount = 1, // Number of times retry should happen in case of failure
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        jsonUsageReport = "target/cucumber-usage.json",
        usageReport = true,
        toPDF = true,
        featureOverviewChart = true,
        coverageReport = true,
        screenShotLocation = "Screenshots/",
        screenShotSize = "300px",
        excludeCoverageTags = {""},//Tags which need to excluded from coveragesssssss Report
        includeCoverageTags = {"@passed"},//Tags which need to included into coverage Report
        outputFolder = "./target/")

@CucumberOptions(features = "src/test/resources/", tags = {"@healthCheck"},
        glue = {"stepDefinitions"}, dryRun = false, strict = true,
        plugin = {"junit:target/log.xml", "html:target/cucumber-html-report", "json:target/cucumber.json",
                "usage:target/cucumber-usage.json", "pretty:target/cucumber-pretty.txt",
                "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        monochrome = true)

public class TestRunner {
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", System.getProperty("os.name"));
        Reporter.setSystemInfo("Selenium", "3.7.0");
        Reporter.setSystemInfo("Maven", "3.6.0");
        Reporter.setSystemInfo("Java Version", System.getProperty("java.version"));
    }
}