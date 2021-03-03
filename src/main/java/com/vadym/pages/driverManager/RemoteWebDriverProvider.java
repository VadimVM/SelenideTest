package com.vadym.pages.driverManager;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteWebDriverProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
//        var experimentalOption = new HashMap<>();
//        experimentalOption.put("download.default_directory", DOWNLOAD_FILES_FOLDER_PATH.toString());
//        experimentalOption.put("profile.default_content_setting_values.cookies", 1);
//        experimentalOption.put("profile.block_third_party_cookies", false);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("–no-sandbox");
//        options.setExperimentalOption("prefs", experimentalOption);
        RemoteWebDriver driver = null;
        try {
            var selenoidHost = System.getenv("selenium_remote_url");
            driver = new RemoteWebDriver(new URL(selenoidHost), options);
            driver.setFileDetector(new LocalFileDetector());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
