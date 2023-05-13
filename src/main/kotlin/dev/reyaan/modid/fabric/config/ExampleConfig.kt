package dev.reyaan.modid.fabric.config

import com.kyanite.paragon.api.ConfigGroup
import com.kyanite.paragon.api.ConfigOption
import com.kyanite.paragon.api.interfaces.Config
import com.kyanite.paragon.api.interfaces.Description
import com.kyanite.paragon.api.interfaces.serializers.ConfigSerializer
import com.kyanite.paragon.api.interfaces.serializers.JSON5Serializer


object ExampleConfig : Config {
    var DISCORD_USERNAME = ConfigOption("username", "oa#1220")

    @Description("What do we do?")
    var ABOUT_ME = ConfigOption("about_me",
        "Minecraft MOOOOOOODER & game developer (also the creator of this super cool config-lib ur using rn!)")

    var MY_INFO = ConfigGroup("my_info", DISCORD_USERNAME, ABOUT_ME)


    override fun getSerializer(): ConfigSerializer {
        return JSON5Serializer.builder(this).build()
    }
}
