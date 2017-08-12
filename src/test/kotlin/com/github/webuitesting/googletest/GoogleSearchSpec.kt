package com.github.webuitesting.googletest

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.github.webuitesting.googletest.pages.GooglePage
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.slf4j.LoggerFactory

object GoogleSearchSpec: Spek({
    val logger = LoggerFactory.getLogger(GoogleSearchSpec::class.java)
    describe("A Basic Search Flow") {
        val baseUrl = SpecConfig.baseUrl
        logger.info("Now starting the test to test the URL {}", { baseUrl })
        on("addition") {
            val page = Selenide.open(baseUrl, GooglePage::class.java)
            val results = page.searchFor("selenide")
            val expectedResults = "Selenide: concise UI tests in Java"
            it("should return the correct Search Results") {
                results.checkResultsSize(10)
                results.results()[0].shouldHave(Condition.text(expectedResults))

            }
        }
    }
})