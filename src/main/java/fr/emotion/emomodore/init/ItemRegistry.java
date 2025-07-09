package fr.emotion.emomodore.init;

import fr.emotion.emomodore.MainRegistry;
import fr.emotion.emomodore.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MainRegistry.MODID);

    public static final ToolMaterial FOSSIL_MAT = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 172, 5.0F, 2.0F, 16, ItemTags.FOSSIL_TOOL_MATERIALS);
    public static final ToolMaterial PURPURA_MAT = new ToolMaterial(fr.emotion.emomodore.tags.BlockTags.INCORRECT_FOR_PURPURA_TOOL,  1750, 10.0F, 3.5F, 8, ItemTags.PURPURA_TOOL_MATERIALS);

    public static final DeferredItem<Item> PURPURA_SHARD = ITEMS.registerSimpleItem("purpura_shard");

    public static final DeferredItem<Item> PURPURA_SWORD = ITEMS.registerItem("purpura_sword", props -> new Item(props.sword(PURPURA_MAT, 3.0F, -2.4F)));
    public static final DeferredItem<Item> PURPURA_SHOVEL = ITEMS.registerItem("purpura_shovel", props -> new Item(props.shovel(PURPURA_MAT, 1.5F, -3.0F)));
    public static final DeferredItem<Item> PURPURA_PICKAXE = ITEMS.registerItem("purpura_pickaxe", props -> new Item(props.pickaxe(PURPURA_MAT, 1.0F, -2.8F)));
    public static final DeferredItem<Item> PURPURA_AXE = ITEMS.registerItem("purpura_axe", props -> new Item(props.axe(PURPURA_MAT, 5.0F, -3.0F)));
    public static final DeferredItem<Item> PURPURA_HOE = ITEMS.registerItem("purpura_hoe", props -> new Item(props.hoe(PURPURA_MAT, -3.0F, 0.0F)));

    public static final DeferredItem<Item> FOSSIL = ITEMS.registerSimpleItem("fossil");

    public static void init (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
