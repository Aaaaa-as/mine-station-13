package com.artemy.minestation13.world.tree;

import com.artemy.minestation13.MineStation13;
import com.artemy.minestation13.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.world.gen.feature.UndergroundConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator DRIFTWOOD = new SaplingGenerator(MineStation13.MOD_ID + ":driftwood",
            Optional.empty(), Optional.of(UndergroundConfiguredFeatures.MONSTER_ROOM), Optional.empty());

}
