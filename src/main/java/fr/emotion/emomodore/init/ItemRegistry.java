package fr.emotion.emomodore.init;

import fr.emotion.emomodore.MainRegistry;
import fr.emotion.emomodore.tags.ItemTags;
import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.FuelValues;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MainRegistry.MODID);

    public static final ToolMaterial FOSSIL_MAT = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 172, 5.0F, 2.0F, 16, ItemTags.FOSSIL_TOOL_MATERIALS);
    public static final ToolMaterial PURPURA_MAT = new ToolMaterial(fr.emotion.emomodore.tags.BlockTags.INCORRECT_FOR_PURPURA_TOOL,  1750, 10.0F, 3.5F, 8, ItemTags.PURPURA_TOOL_MATERIALS);

    public static final ArmorMaterial VIRIDIS_MAT = new ArmorMaterial(35, Util.make(new EnumMap<>(ArmorType.class), map -> {
        map.put(ArmorType.BOOTS, 3);
        map.put(ArmorType.LEGGINGS, 6);
        map.put(ArmorType.CHESTPLATE, 8);
        map.put(ArmorType.HELMET, 3);
        map.put(ArmorType.BODY, 11);
    }), 20, SoundEvents.ARMOR_EQUIP_GENERIC, 2.5F, 0.0F, ItemTags.REPAIRS_VIRIDIS_ARMOR, ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.fromNamespaceAndPath(MainRegistry.MODID, "viridis")));

    public static final DeferredItem<Item> FOSSIL = ITEMS.registerSimpleItem("fossil");

    public static final DeferredItem<Item> FOSSIL_SWORD = ITEMS.registerItem("fossil_sword", props -> new Item(props.sword(FOSSIL_MAT, 3.0F, -2.4F)));
    public static final DeferredItem<Item> FOSSIL_SHOVEL = ITEMS.registerItem("fossil_shovel", props -> new ShovelItem(FOSSIL_MAT, 1.5F, -3.0F, props));
    public static final DeferredItem<Item> FOSSIL_PICKAXE = ITEMS.registerItem("fossil_pickaxe", props -> new Item(props.pickaxe(FOSSIL_MAT, 1.0F, -2.8F)));
    public static final DeferredItem<Item> FOSSIL_AXE = ITEMS.registerItem("fossil_axe", props -> new AxeItem(FOSSIL_MAT, 5.0F, -3.0F, props));
    public static final DeferredItem<Item> FOSSIL_HOE = ITEMS.registerItem("fossil_hoe", props -> new HoeItem(FOSSIL_MAT, -3.0F, -2.0F, props));

    public static final DeferredItem<Item> PURPURA_SHARD = ITEMS.registerSimpleItem("purpura_shard");

    public static final DeferredItem<Item> PURPURA_SWORD = ITEMS.registerItem("purpura_sword", props -> new Item(props.sword(PURPURA_MAT, 3.0F, -2.4F)));
    public static final DeferredItem<Item> PURPURA_SHOVEL = ITEMS.registerItem("purpura_shovel", props -> new ShovelItem(PURPURA_MAT, 1.5F, -3.0F, props));
    public static final DeferredItem<Item> PURPURA_PICKAXE = ITEMS.registerItem("purpura_pickaxe", props -> new Item(props.pickaxe(PURPURA_MAT, 1.0F, -2.8F)));
    public static final DeferredItem<Item> PURPURA_AXE = ITEMS.registerItem("purpura_axe", props -> new AxeItem(PURPURA_MAT, 5.0F, -3.0F, props));
    public static final DeferredItem<Item> PURPURA_HOE = ITEMS.registerItem("purpura_hoe", props -> new HoeItem(PURPURA_MAT, -3.0F, 0.0F, props));

    public static final DeferredItem<Item> VIRIDIS_HELMET = ITEMS.registerItem("viridis_helmet", props -> new Item(props.humanoidArmor(VIRIDIS_MAT, ArmorType.HELMET)));
    public static final DeferredItem<Item> VIRIDIS_CHESTPLATE = ITEMS.registerItem("viridis_chestplate", props -> new Item(props.humanoidArmor(VIRIDIS_MAT, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> VIRIDIS_LEGGINGS = ITEMS.registerItem("viridis_leggings", props -> new Item(props.humanoidArmor(VIRIDIS_MAT, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> VIRIDIS_BOOTS = ITEMS.registerItem("viridis_boots", props -> new Item(props.humanoidArmor(VIRIDIS_MAT, ArmorType.BOOTS)));

    public static final DeferredItem<Item> LUME_STONE = ITEMS.registerItem("lume_stone", props -> new Item(props) {
        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType, FuelValues fuelValues) {
            return 3200;
        }
    });

    public static void init (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
