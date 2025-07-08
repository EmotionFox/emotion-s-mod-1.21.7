package fr.emotion.emomod.tags;

import fr.emotion.emomod.EmotionsMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class ItemTags {
    public static final TagKey<Item> FOSSIL_TOOL_MATERIALS = TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(EmotionsMod.MODID, "fossil_tool_materials"));
    public static final TagKey<Item> PURPURA_TOOL_MATERIALS = TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(EmotionsMod.MODID, "purpura_tool_materials"));
}