package jjplayz565.crunchies;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SlicerBlock extends Block implements BlockEntityProvider{
    public SlicerBlock(Settings settings){
        super(settings);
    }

    
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state){
        return new SlicerBlockEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit){
        if(!world.isClient) return ActionResult.SUCCESS;
        Inventory blockEntity = (Inventory) world.getBlockEntity(pos);

        if(!player.getStackInHand(player.getActiveHand()).isEmpty()){
            if(blockEntity.getStack(0).isEmpty()){
                blockEntity.setStack(0, player.getStackInHand(player.getActiveHand()).copy());
                player.getStackInHand(player.getActiveHand()).setCount(0);
            } else if(blockEntity.getStack(1).isEmpty()){
                blockEntity.setStack(1, player.getStackInHand(player.getActiveHand()).copy());
                player.getStackInHand(player.getActiveHand()).setCount(0);
            } else{
                System.out.println("This block holds " + blockEntity.getStack(0) + " and " + blockEntity.getStack(1));
            }
        } else{
            if(!blockEntity.getStack(1).isEmpty()){
                player.getInventory().offerOrDrop(blockEntity.getStack(1));
                blockEntity.removeStack(1);
            } else if(!blockEntity.getStack(0).isEmpty()){
                player.getInventory().offerOrDrop(blockEntity.getStack(0));
                blockEntity.removeStack(0);
            } else{
                System.out.println("This box has nothing in it");
            }
        }
        return ActionResult.SUCCESS;
    }
}
