package fr.emotion.emomod.tags;

import fr.emotion.emomod.EmotionsMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class BlockTags {
    public static final TagKey<Block> NEEDS_PURPURA_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(EmotionsMod.MODID, "needs_purpura_tool"));
    public static final TagKey<Block> INCORRECT_FOR_PURPURA_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(EmotionsMod.MODID, "incorrect_for_purpura_tool"));
}
