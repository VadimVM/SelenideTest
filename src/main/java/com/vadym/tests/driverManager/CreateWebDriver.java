package com.vadym.tests.driverManager;

import com.codeborne.selenide.Configuration;

public class CreateWebDriver {
    public static void createWebDriver() {
        Configuration.browser = String.format("com.vadym.tests.driverManager.%s",
                System.getProperty("remote", "LocalWebDriver"));
        Configuration.timeout = 30000;
        Configuration.startMaximized = true;
        Configuration.pollingInterval = 10;
        Configuration.reportsFolder = "test-result/reports";
    }
}
