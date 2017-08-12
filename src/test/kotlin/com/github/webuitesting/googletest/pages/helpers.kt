package com.github.webuitesting.googletest.pages

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By

fun get(bySelector: By) : SelenideElement {
    return Selenide.`$`(bySelector);
}

fun get(selector: String) : SelenideElement {
    return Selenide.`$`(selector);
}

fun all(selector: String) : ElementsCollection {
    return Selenide.`$$`(selector);
}