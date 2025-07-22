package fr.emotion.emomodore.datagen;

import fr.emotion.emomodore.MainRegistry;
import fr.emotion.emomodore.init.BlockRegistry;
import fr.emotion.emomodore.init.ItemRegistry;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.stream.Stream;

public class EmoModelProvider extends ModelProvider {
    public EmoModelProvider(PackOutput output) {
        super(output, MainRegistry.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        // Items
        itemModels.generateFlatItem(ItemRegistry.FOSSIL.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ItemRegistry.FOSSIL_SWORD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.FOSSIL_SHOVEL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.FOSSIL_PICKAXE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.FOSSIL_AXE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.FOSSIL_HOE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ItemRegistry.PURPURA_SHARD.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ItemRegistry.PURPURA_SWORD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.PURPURA_SHOVEL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.PURPURA_PICKAXE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.PURPURA_AXE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.PURPURA_HOE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ItemRegistry.PURPURA_LUME_SWORD.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ItemRegistry.PURPURA_NETHERITE_SWORD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.PURPURA_DIAMOND_SWORD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.PURPURA_EMERALD_SWORD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.PURPURA_GOLD_SWORD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.PURPURA_IRON_SWORD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.PURPURA_COPPER_SWORD.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ItemRegistry.VIRIDIS_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.VIRIDIS_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.VIRIDIS_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegistry.VIRIDIS_BOOTS.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ItemRegistry.VIRIDIS_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ItemRegistry.LUME_STONE.get(), ModelTemplates.FLAT_ITEM);

        // Blocks
        blockModels.createTrivialCube(BlockRegistry.FOSSIL_ORE.get());

        blockModels.createTrivialCube(BlockRegistry.PURPURA_ORE.get());
        blockModels.createTrivialCube(BlockRegistry.DEEPSLATE_PURPURA_ORE.get());
        blockModels.createTrivialCube(BlockRegistry.PURPURA_BLOCK.get());

        blockModels.createTrivialCube(BlockRegistry.VIRIDIS_ORE.get());
        blockModels.registerSimpleFlatItemModel(BlockRegistry.VIRIDIS_CRYSTAL.get());
        createModelessBlock(blockModels, BlockRegistry.VIRIDIS_CRYSTAL.get(), "viridis_crystal");
        blockModels.createTrivialCube(BlockRegistry.VIRIDIS_BLOCK.get());

        blockModels.createTrivialCube(BlockRegistry.NETHER_LUME_ORE.get());
        blockModels.createTrivialCube(BlockRegistry.LUME_BLOCK.get());
    }

    private static void createModelessBlock(BlockModelGenerators blockModels, Block block, String name) {
        blockModels.blockStateOutput.accept(MultiVariantGenerator.dispatch(block, new MultiVariant(WeightedList.of(new Variant(ResourceLocation.fromNamespaceAndPath(MainRegistry.MODID, "block/" + name))))));
    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream();
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return ItemRegistry.ITEMS.getEntries().stream();
    }
}
