package dev.reyaan.modid.fabric.config

import com.kyanite.paragon.api.ConfigOption
import com.kyanite.paragon.api.interfaces.Config

object ExampleConfig : Config {
    val SEND_TEST_MESSAGE:ConfigOption<Boolean> =
        ConfigOption("send_test_message", false)
}
