package com.artemy.minestation13;

import com.artemy.minestation13.block.ModBlocks;
import com.artemy.minestation13.component.ModDataComponentTypes;
import com.artemy.minestation13.item.ModItemGroups;
import com.artemy.minestation13.item.ModItems;
import com.artemy.minestation13.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MineStation13 implements ModInitializer {
	public static final String MOD_ID = "mine_station_13";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerModItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponentTypes();

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES,600);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if(entity instanceof SheepEntity sheep && !world.isClient()){
				if(player.getMainHandStack().getItem() == Items.END_ROD){
					player.sendMessage(Text.literal("<Sheep> please don't"));
					player.getMainHandStack().decrement(1);
					sheep.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 600, 3, false, false));
				}
			}
			return ActionResult.PASS;
		});
	}
}