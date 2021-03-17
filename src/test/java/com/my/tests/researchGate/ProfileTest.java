package com.my.tests.researchGate;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.vadym.pages.driverManager.CreateWebDriver;
import com.vadym.pages.testResearchGate.RGAction;
import com.vadym.pages.testResearchGate.RGPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class ProfileTest {
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
    public void getUserProfile() {
        action.UserProfile();
        page.getUserName().shouldBe(Condition.visible);
    }

    @Test
    public void countOfPublications() {
        action.UserProfile();
        page.getListOfPublication().shouldHave(CollectionCondition.size(5));
    }
}
