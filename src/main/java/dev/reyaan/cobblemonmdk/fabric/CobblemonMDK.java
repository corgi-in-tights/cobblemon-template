package dev.reyaan.cobblemonmdk.fabric;


import com.cobblemon.mod.common.api.pokemon.PokemonSpecies;
import com.cobblemon.mod.common.pokemon.Species;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.minecraft.server.command.CommandManager.literal;


public class CobblemonMDK implements ModInitializer {
    public static String MOD_NAME = "Cobblemon MDK";
    public static String MOD_ID = "cobblemonmdk";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


    @Override
    public void onInitialize() {
        LOGGER.info("Hello, world!");

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(literal("test").executes(context -> {
                Species species = PokemonSpecies.INSTANCE.getByIdentifier(Identifier.of("cobblemon:bidoof", ":"));
                LOGGER.info("Species: {}", species);
                return 0;
            }));
        });
    }


}
