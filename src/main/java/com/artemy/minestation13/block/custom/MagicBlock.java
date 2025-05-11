package com.artemy.minestation13.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import com.artemy.minestation13.util.ModTags;

import java.util.List;



public class MagicBlock extends Block {
    public MagicBlock(Settings settings) {
        super(settings);
    }



    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        world.playSound(player, pos, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 1.0f, 1.0f);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity itemEntity) {
            if(itemEntity.getStack().isIn(ModTags.Items.MAGIC_TRANSFORMABLE_ITEMS)) {
                itemEntity.setStack(new ItemStack(Items.LAPIS_LAZULI, itemEntity.getStack().getCount()));
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.mine_station_13.magic_block.tooltip"));
    }
}
