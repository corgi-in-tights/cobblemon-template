package dev.reyaan.modid.fabric

import com.kyanite.paragon.api.ConfigManager
import com.mojang.logging.LogUtils
import dev.reyaan.modid.fabric.config.ExampleConfig
import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import org.slf4j.Logger


class Example : ModInitializer {
    companion object {
        const val MOD_ID = "example"
        const val MOD_NAME = "Example"
        val LOGGER: Logger = LogUtils.getLogger()
    }

    fun id(path: String): Identifier {
        return Identifier(MOD_ID, path)
    }

    fun log(value: String) {
        LOGGER.info("{}: {}", MOD_NAME, value)
    }


    override fun onInitialize() {
        ConfigManager.register(MOD_ID, ExampleConfig)
        if (ExampleConfig.SEND_TEST_MESSAGE.get()) {
            log("Hello, Example World!")
        }
    }

}