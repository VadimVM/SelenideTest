package com.my.tests.github.login;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.vadym.pages.annotations.TestId;
import com.vadym.pages.driverManager.RemoteWebDriverProvider;
import com.vadym.pages.testgit.GitHubActions;
import com.vadym.pages.testgit.GitHubPage;
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


    @TestId(number = "RG-L-1")
    @Test(description = "System should have authorization for users")
    public void userSingIn(){
        actions.doToSingInPage();
        page.getFormSession().shouldHave(Condition.text("Username or email address"));
        page.getLogin();
        page.getPassword();
    }

    @TestId(number = "RG-L-2")
    @Test(description = "System provide an ability for users to log in")
    public void userLoginToAccount(){
        actions.loginToAccount();
    }

    @TestId(number = "RG-L-3")
    @Test(description = "User can see his profile and list of publications")
    public void userClickToAvatar(){
        actions.getSummaryOfProfile();
        page.listMenuItem().shouldHave(CollectionCondition.size(5));
    }
}
