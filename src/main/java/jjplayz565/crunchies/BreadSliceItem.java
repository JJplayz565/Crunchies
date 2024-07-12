package jjplayz565.crunchies;

import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

public class BreadSliceItem extends Item{
    public BreadSliceItem(Settings settings){
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, TooltipContext context, List<Text> tooltip, TooltipType type){
        tooltip.add(Text.translatable("item.crunchies.bread_slice.tooltip"));
    }
}
