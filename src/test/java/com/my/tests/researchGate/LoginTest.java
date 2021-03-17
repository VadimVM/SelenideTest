package com.my.tests.researchGate;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.vadym.pages.driverManager.CreateWebDriver;
import com.vadym.pages.testResearchGate.RGAction;
import com.vadym.pages.testResearchGate.RGPage;
import com.vadym.pages.testgoole.GoogleAction;
import com.vadym.pages.testgoole.GooglePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
    private RGPage page;
    private RGAction action;

    @BeforeTest
    public void setUp() {
        CreateWebDriver.createWebDriver();
        action = new RGAction();
        page = new RGPage();
    }

    @BeforeMethod
    public void openGoogle() {
        open("https://www.researchgate.net");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void searchShouldHaveText() {
        action.goToLoginPage();
    }
    @Test
    public void userSeeHomePage(){
        action.userLoginToRG();
        page.getHeader().shouldBe(Condition.visible);
        page.getAvatarUser().shouldBe(Condition.visible);
    }
}
