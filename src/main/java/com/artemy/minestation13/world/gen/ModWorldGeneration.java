package com.artemy.minestation13.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();
        //ModTreeGeneration.generateTrees();

        ModEntitySpawns.addSpawns();
    }
}
