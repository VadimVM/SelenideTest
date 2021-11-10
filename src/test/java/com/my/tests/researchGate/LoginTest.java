package com.my.tests.researchGate;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.vadym.tests.annotations.TestId;
import com.vadym.tests.driverManager.CreateWebDriver;
import com.vadym.tests.testResearchGate.RGAction;
import com.vadym.tests.testResearchGate.RGPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

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
    public void openRG() {
        open("https://www.researchgate.net");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }


    @Test
    public void searchShouldHaveText() {
        action.userLoginToRG();
        sleep(2000);
    }

    @TestId(number = "RG-L-1")
    @Test(description = "System provide an ability for authorized Users Log In")
    public void userSeeHomePage() {
        action.userLoginToRG();
        page.getHeader().shouldBe(Condition.visible);
        page.getAvatarUser().shouldBe(Condition.visible);
    }
}
