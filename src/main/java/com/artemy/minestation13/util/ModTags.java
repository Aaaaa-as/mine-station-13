package com.artemy.minestation13.util;

import com.artemy.minestation13.MineStation13;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_PINK_GARNET_TOOL = createTag("needs_pink_garnet_tool");
        public static final TagKey<Block> INCORRECT_FOR_PINK_GARNET_TOOL = createTag("incorrect_for_pink_garnet_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, MineStation13.id(name));
        }
    }
    public static class Items {
        public static final TagKey<Item> MAGIC_TRANSFORMABLE_ITEMS = createTag("magic_transformable_items");

        @SuppressWarnings("SameParameterValue")
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, MineStation13.id(name));
        }
    }
}
