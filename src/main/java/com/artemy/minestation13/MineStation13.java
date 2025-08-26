package com.artemy.minestation13;

import com.artemy.minestation13.block.ModBlocks;
import com.artemy.minestation13.component.ModDataComponentTypes;
import com.artemy.minestation13.effect.ModEffects;
import com.artemy.minestation13.enchantment.ModEnchantmentEffects;
import com.artemy.minestation13.entity.ModEntities;
import com.artemy.minestation13.entity.custom.MantisEntity;
import com.artemy.minestation13.item.ModItemGroups;
import com.artemy.minestation13.item.ModItems;
import com.artemy.minestation13.particle.ModParticles;
import com.artemy.minestation13.potion.ModPotions;
import com.artemy.minestation13.util.HammerUsageEvent;
import com.artemy.minestation13.util.ModLootTableModifiers;
import com.artemy.minestation13.util.ModTags;
import com.artemy.minestation13.villager.ModVillagers;
import com.artemy.minestation13.world.gen.ModWorldGeneration;
import com.mojang.datafixers.types.templates.List;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.*;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@SuppressWarnings("CodeBlock2Expr")
public class MineStation13 implements ModInitializer {
	public static final String MOD_ID = "mine_station_13";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItemGroups.registerModItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponentTypes();

		ModEffects.registerModEffects();
		ModPotions.registerPotions();

		ModEnchantmentEffects.registerEnchantmentEffects();
		ModWorldGeneration.generateModWorldGen();

		ModEntities.registerModEntities();
		ModVillagers.registerVillagers();

		ModParticles.registerParticles();

		ModLootTableModifiers.modifyLootTables();

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

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD,Items.SLIME_BALL, ModPotions.SLIMEY_POTION);
		});

		CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER,0.5f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER_SEEDS,0.25f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.HONEY_BERRIES,0.15f);


		StrippableBlockRegistry.register(ModBlocks.DRIFTWOOD_LOG, ModBlocks.STRIPPED_DRIFTWOOD_LOG);
		StrippableBlockRegistry.register(ModBlocks.DRIFTWOOD_WOOD, ModBlocks.STRIPPED_DRIFTWOOD_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DRIFTWOOD_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_LEAVES, 30, 60);

		FabricDefaultAttributeRegistry.register(ModEntities.MANTIS, MantisEntity.createAttributes());


		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2,factories -> {
			factories.add((entity, random) -> {

				return new TradeOffer(
						new TradedItem(Items.EMERALD, 3),
						Optional.of(new TradedItem(new Item[]{Items.WHEAT_SEEDS,Items.BEETROOT_SEEDS,Items.MELON_SEEDS,Items.PUMPKIN_SEEDS}[random.nextInt(4)], 1)),
						new ItemStack(ModItems.CAULIFLOWER_SEEDS), 7, 2, 0.04f);
			});
		});

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 3,factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 6),
					Optional.of(new TradedItem(Items.SWEET_BERRIES, 1)),
					new ItemStack(ModItems.HONEY_BERRIES),7,7,0.04f));
		});
		TradeOfferHelper.registerVillagerOffers(ModVillagers.KAUPENGER, 1,factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 2),
					new ItemStack(ModItems.PINK_GARNET),7,3,0.04f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.PINK_GARNET, 2),
					new ItemStack(Items.EMERALD),7,3,0.04f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.PINK_GARNET, 2),
					Optional.of(new TradedItem(Blocks.OAK_PLANKS, 3)),
					new ItemStack(ModBlocks.CHAIR),7,3,0.04f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.RAW_PINK_GARNET, 1),
					new ItemStack(ModItems.PINK_GARNET,2),8,3,0.04f));
		});
		TradeOfferHelper.registerVillagerOffers(ModVillagers.KAUPENGER, 2,factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.PINK_GARNET, 18),
					new ItemStack(ModBlocks.MAGIC_BLOCK),7,8,0.04f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.PINK_GARNET, 20),
					Optional.of(new TradedItem(Items.IRON_AXE, 1)),
					new ItemStack(ModItems.TOMAHAWK,8),2,8,0.04f));

		});
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

}