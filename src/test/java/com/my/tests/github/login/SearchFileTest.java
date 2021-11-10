package com.my.tests.github.login;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.vadym.tests.driverManager.RemoteWebDriverProvider;
import com.vadym.tests.testgit.GitHubActions;
import com.vadym.tests.testgit.GitHubPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SearchFileTest {
    private GitHubActions actions;
    private GitHubPage page;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = RemoteWebDriverProvider.class.getName();
        Configuration.timeout = 30000;
        actions = new GitHubActions();
        page = new GitHubPage();
    }

    @BeforeMethod
    public void openGit() {
        open("https://github.com");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void userSelectRepository(){
        actions.goToSelenideTest();
        page.findGitignore().shouldHave(Condition.text(".gitignore"));
    }
}
