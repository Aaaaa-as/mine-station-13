package com.artemy.minestation13;

import com.artemy.minestation13.block.ModBlocks;
import com.artemy.minestation13.component.ModDataComponentTypes;
import com.artemy.minestation13.item.ModItemGroups;
import com.artemy.minestation13.item.ModItems;
import com.artemy.minestation13.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
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
	}
}