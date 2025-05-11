package com.artemy.minestation13.util;

import com.artemy.minestation13.MineStation13;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MineStation13.MOD_ID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> MAGIC_TRANSFORMABLE_ITEMS = createTag("magic_transformable_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MineStation13.MOD_ID, name));
        }
    }
}
