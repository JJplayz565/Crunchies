package jjplayz565.crunchies;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class SlicerBlockEntity extends BlockEntity implements ImplementedInventory{
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

    public SlicerBlockEntity(BlockPos pos, BlockState state){
        super(Crunchies.SLICER_BLOCK_ENTITY, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems(){
        return inventory;
    }

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapper){
        Inventories.writeNbt(nbt, inventory, wrapper);
        
        super.writeNbt(nbt, wrapper);
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapper){
        super.readNbt(nbt, wrapper);

        Inventories.readNbt(nbt, inventory, wrapper);
    }

    //Still have these in because I'm tryna sort out ImplementedInventory first

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStackInSlot'");
    }
}
