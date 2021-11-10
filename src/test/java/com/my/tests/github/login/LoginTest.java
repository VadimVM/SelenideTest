package com.my.tests.github.login;

import com.codeborne.selenide.CollectionCondition;
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

public class LoginTest {
    private GitHubActions actions;
    private GitHubPage page;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = RemoteWebDriverProvider.class.getName();
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
    public void userSingIn(){
        actions.doToSingInPage();
        page.getFormSession().shouldHave(Condition.text("Username or email address"));
        page.getLogin();
        page.getPassword();
    }

    @Test
    public void userLoginToAccount(){
        actions.loginToAccount();
    }

    @Test
    public void userClickToAvatar(){
        actions.getSummaryOfProfile();
        page.listMenuItem().shouldHave(CollectionCondition.size(5));
    }
}
