package jjplayz565.crunchies;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    
    public static final BreadSliceItem BREADSLICE_ITEM = Registry.register(Registries.ITEM, Identifier.of(Crunchies.modId, "bread_slice"), new BreadSliceItem(new Item.Settings()));

    public static final SlicerItem SLICER_ITEM = Registry.register(Registries.ITEM, Identifier.of(Crunchies.modId, "slicer"), new SlicerItem(ModBlocks.SLICER_BLOCK,  new Item.Settings()));

    private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item, Item after){
		ItemGroupEvents.modifyEntriesEvent(group).register(content -> {content.addAfter(after, item);});
	}

    private static void ItemsToAddToItemGroups(){
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, BREADSLICE_ITEM, Items.BREAD);
    }

    public static void initialise(){
        Crunchies.LOGGER.info("Initialising Items!");
        ItemsToAddToItemGroups();
    }
}
