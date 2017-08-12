package com.github.webuitesting.googletest.pages

import com.codeborne.selenide.ElementsCollection

import com.codeborne.selenide.CollectionCondition.size
import com.codeborne.selenide.CollectionCondition.texts

class SearchResultsPage {

    fun checkResultsSize(expectedSize: Int) {
        results().shouldHave(size(expectedSize))
    }

    fun checkResults(vararg expectedTexts: String) {
        results().shouldHave(texts(*expectedTexts))
    }

    fun results(): ElementsCollection {
        return all("#ires .g")
    }

}