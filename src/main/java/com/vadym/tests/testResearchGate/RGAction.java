package com.vadym.tests.testResearchGate;

public class RGAction {
    private RGPage page;

    public RGAction() {
        page = new RGPage();
    }

    public void goToLoginPage() {
        page.getLoginPage().click();
    }

    public void userLoginToRG() {
        goToLoginPage();
        page.getInputLogin().val("vadimvm11@gmail.com");
        page.getInputPassword().val(System.getProperty("password")).pressEnter();
    }

    public void UserProfile() {
        userLoginToRG();
        page.getAvatarUser().click();
    }

}
