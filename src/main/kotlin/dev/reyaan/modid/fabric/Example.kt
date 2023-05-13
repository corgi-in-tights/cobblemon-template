package dev.reyaan.modid.fabric

import com.kyanite.paragon.api.ConfigManager
import com.mojang.logging.LogUtils
import dev.reyaan.modid.fabric.config.ExampleConfig
import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import org.slf4j.Logger


class Example : ModInitializer {
    companion object {
        const val MOD_ID = "modid"
        const val MOD_NAME = "Example Mod"
        val LOGGER: Logger = LogUtils.getLogger()

        fun id(path: String): Identifier {
            return Identifier(MOD_ID, path)
        }
    }

    override fun onInitialize() {
        ConfigManager.register(MOD_ID, ExampleConfig)
        LOGGER.info("TEST CONFIG: " + ExampleConfig.ABOUT_ME.get())
    }

}