package com.my.tests.google.search;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.vadym.pages.testgoole.GoogleAction;
import com.vadym.pages.testgoole.GooglePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class SearchTest {
    private GoogleAction googleAction;
    private GooglePage page;


    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = String.format("com.vadym.pages.driverManager.%s", System.getProperty("remote", "WebDriver"));
        Configuration.timeout = 30000;
        googleAction = new GoogleAction();
        page = new GooglePage();
    }

    @BeforeMethod
    public void openGoogle() {
        open("http://google.com");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void searchShouldHaveText() {
        googleAction.searchText(System.getProperty("g"));
        page.getResSearch().shouldHave(Condition.text("Gradle Build"));
    }

    @Test
    public void firstLinkShouldHaveText() {
        googleAction.searchText("gradle");
        page.getResSearchByCSS(0).shouldHave(Condition.text("Gradle Build"));
    }

}
