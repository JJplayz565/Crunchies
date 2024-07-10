package jjplayz565.crunchies;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Crunchies implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("crunchies");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Initialising!");
	}

	private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item, Item after){
		ItemGroupEvents.modifyEntriesEvent(group).register(content -> {content.addAfter(after, item);});
		String tempString = group.toString();
		int startIndex  = tempString.indexOf("/ ");
		int endIndex = tempString.indexOf("]");
		String groupString = tempString.substring(startIndex +  1, endIndex);
		LOGGER.info("Added " + item + " to item group " + groupString + " after " + after);
	}

	public static int ticks(int seconds){
		return seconds * 20;
	}
}