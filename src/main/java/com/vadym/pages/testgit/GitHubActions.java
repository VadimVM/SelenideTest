package com.vadym.pages.testgit;

public class GitHubActions {
    private GitHubPage gitPage;

    public GitHubActions(){
        gitPage = new GitHubPage();
    }
    public void doToSingInPage(){
        gitPage.getSingIn().click();
    }

    public void loginToAccount(){
        doToSingInPage();
        gitPage.getLogin().val("vadimvm11@gmail.com");
        gitPage.getPassword().val("xxxxxxxxxxx").pressEnter(); // пароль в личку, если что, напишу.
    }

    public void getSummaryOfProfile(){
        loginToAccount();
        gitPage.getViewProfile().click();
    }

    public void goToSelenideTest(){
        loginToAccount();
        gitPage.getReposSelenideTest().click();
    }
}
