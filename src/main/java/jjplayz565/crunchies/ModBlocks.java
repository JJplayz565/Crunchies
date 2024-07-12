package jjplayz565.crunchies;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class ModBlocks {

    public static final SlicerBlock SLICER_BLOCK = Registry.register(Registries.BLOCK, Identifier.of(Crunchies.modId, "slicer"), new SlicerBlock(Block.Settings.copy(Blocks.CRAFTING_TABLE)));


    public static void initialise(){
        Crunchies.LOGGER.info("Initialising Blocks!");
    }
}
