package jjplayz565.crunchies;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Crunchies implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("Crunchies");

	public static final String modId = "crunchies";

	public static BlockEntityType<SlicerBlockEntity> SLICER_BLOCK_ENTITY;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		SLICER_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(modId, "slicer_block_entity"), BlockEntityType.Builder.create(SlicerBlockEntity::new, ModBlocks.SLICER_BLOCK).build());

		initialisation();
	}

	public static int ticks(int seconds){
		return seconds * 20;
	}

	private static void initialisation(){
		LOGGER.info("Initialising!");

		ModItems.initialise();
		ModBlocks.initialise();
	}
}