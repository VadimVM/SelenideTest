package com.vadym.tests.testResearchGate;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class RGPage {
    public SelenideElement getLoginPage() {
        return $x("//a[text()='Log in']");
    }

    public SelenideElement getInputLogin() {
        return $("#input-login");
    }

    public SelenideElement getInputPassword() {
        return $("#input-password");
    }

    public SelenideElement getHeader() {
        return $("nav[aria-label='Main']");
    }

    public SelenideElement getAvatarUser() {
        return $("img[alt='Vadim']");
    }

    public SelenideElement getUserName() {
        return $x("//div[text()='Vadim Mikhailenko']");
    }

    public SelenideElement getUserJob(){
        return $x("//div[text()='State Scientific Institution Institute for Single Crystal, Ukraine, Kharkiv']");
    }

    public ElementsCollection getListOfPublication() {
        return $$("div.profile-highlights__item");
    }
}
