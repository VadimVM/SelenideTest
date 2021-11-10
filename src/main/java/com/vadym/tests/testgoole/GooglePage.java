package com.vadym.tests.testgoole;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class GooglePage {
    public SelenideElement getResSearch() {
        return $x("//div[@id='search']");
    }

    public SelenideElement getResSearchByCSS(int index) {
        return $("#rso .g");
    }

    public ElementsCollection getRes() {
        return $$x("//div[@class='g']");
    }

    public SelenideElement getSearchInput() {
        return $(By.name("q"));
    }
}
