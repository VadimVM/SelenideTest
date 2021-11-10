package com.vadym.tests.testgoole;

public class GoogleAction {
    private GooglePage page;

    public GoogleAction() {
        page = new GooglePage();
    }

    public void searchText(String someText) {
        page.getSearchInput().val(someText).pressEnter();
    }

}
