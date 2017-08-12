package com.github.webuitesting.googletest.pages

import org.openqa.selenium.By

import com.codeborne.selenide.Selenide.page

class GooglePage {

    fun searchFor(query: String): SearchResultsPage {
        get(By.name("q")).setValue(query).pressEnter()
        return page(SearchResultsPage::class.java)
    }
}
