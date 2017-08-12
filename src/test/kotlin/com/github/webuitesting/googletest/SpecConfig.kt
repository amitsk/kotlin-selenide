package com.github.webuitesting.googletest

import com.codeborne.selenide.Configuration as SelenideConfiguration
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory

object SpecConfig {
    var config: Config = ConfigFactory.empty()
    init {
        if (!config.isResolved || config.isEmpty) {
            //Explicitly named, default is also application.conf
            val baseConfig = ConfigFactory.load("application")
            val env = baseConfig.getString("environment") ?:
                    throw IllegalArgumentException("Please specify an environment." +
                            " Valid values are local,test,prod")
            config = ConfigFactory.load(env).withFallback(baseConfig)
        }

        SelenideConfiguration.timeout = 3000
        SelenideConfiguration.browser = config.getString("browser.name")
    }

    val baseUrl= config.getString("google.baseUrl")
}