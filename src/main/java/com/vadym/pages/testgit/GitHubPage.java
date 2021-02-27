package com.vadym.pages.testgit;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class GitHubPage {

    public SelenideElement getSingIn() {
        return $x("//a[@href='/login']");
    }

    public SelenideElement getFormSession() {
        return $x("//form[@action='/session']");
    }

    public SelenideElement getLogin() {
        return $x("//input[@name='login']");
    }

    public SelenideElement getPassword() {
        return $x("//input[@name='password']");
    }

    public SelenideElement getViewProfile() {
        return $x("//div//summary[@aria-label='View profile and more']");
    }

    public ElementsCollection listMenuItem() {
        return $$x("//div//a[@role='menuitem']");
    }

    public SelenideElement getReposSelenideTest() {
        return $x("//div//a[@href='/VadimVM/Selenidtest']");
    }

    public SelenideElement findGitignore() {
        return $x("//div//a[@title='.gitignore']");
    }
}
