package com.artemy.minestation13.item.custom;

import com.artemy.minestation13.block.ModBlocks;
import com.artemy.minestation13.component.ModDataComponentTypes;
import com.artemy.minestation13.particle.ModParticles;
import com.artemy.minestation13.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP = Map.of(
            Blocks.STONE,Blocks.STONE_BRICKS,
            Blocks.END_STONE,Blocks.END_STONE_BRICKS,
            Blocks.OAK_LOG, ModBlocks.PINK_GARNET_BLOCK
    );

    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());
                context.getStack().damage(1,((ServerWorld) world),((ServerPlayerEntity) context.getPlayer()),
                        item -> Objects.requireNonNull(context.getPlayer()).sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
                world.playSound(null, context.getBlockPos(), ModSounds.CHISEL_USE, SoundCategory.BLOCKS);
                context.getStack().set(ModDataComponentTypes.POSITION, context.getBlockPos());
                ((ServerWorld) world).spawnParticles(new BlockStateParticleEffect(ParticleTypes.BLOCK,clickedBlock.getDefaultState()),
                        context.getBlockPos().getX()+.5f,context.getBlockPos().getY()+.5f,context.getBlockPos().getZ()+.5f,
                        20,0,0,0,2.5f);
                ((ServerWorld) world).spawnParticles(ModParticles.PINK_GARNET_PARTICLE,
                        context.getBlockPos().getX()+.5f,context.getBlockPos().getY()+.5f,context.getBlockPos().getZ()+.5f,
                        5,0,0,0,3);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.mine_station_13.chisel.info"));
        }else {
            tooltip.add(Text.translatable("tooltip.mine_station_13.press_shift"));
        }
        if (stack.get(ModDataComponentTypes.POSITION)!=null) {
            //noinspection DataFlowIssue
            tooltip.add(Text.literal("Last block changed at:"+stack.get(ModDataComponentTypes.POSITION).toString()));
        }
    }
}
