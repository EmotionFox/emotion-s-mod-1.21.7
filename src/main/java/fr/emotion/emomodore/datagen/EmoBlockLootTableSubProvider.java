package fr.emotion.emomodore.datagen;

import fr.emotion.emomodore.init.BlockRegistry;
import fr.emotion.emomodore.init.ItemRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class EmoBlockLootTableSubProvider extends BlockLootSubProvider {
    protected EmoBlockLootTableSubProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        add(BlockRegistry.FOSSIL_ORE.get(), block -> createOreDrop(BlockRegistry.FOSSIL_ORE.get(), ItemRegistry.FOSSIL.get()));

        add(BlockRegistry.PURPURA_ORE.get(), block -> createOreDrop(BlockRegistry.PURPURA_ORE.get(), ItemRegistry.PURPURA_SHARD.get()));
        add(BlockRegistry.DEEPSLATE_PURPURA_ORE.get(), block -> createOreDrop(BlockRegistry.DEEPSLATE_PURPURA_ORE.get(), ItemRegistry.PURPURA_SHARD.get()));
        dropSelf(BlockRegistry.PURPURA_BLOCK.get());

        dropWhenSilkTouch(BlockRegistry.VIRIDIS_ORE.get());
        dropSelf(BlockRegistry.VIRIDIS_CRYSTAL.get());
        dropSelf(BlockRegistry.VIRIDIS_BLOCK.get());

        add(BlockRegistry.NETHER_LUME_ORE.get(), block -> createOreDrop(BlockRegistry.NETHER_LUME_ORE.get(), ItemRegistry.LUME_STONE.get()));
        dropSelf(BlockRegistry.LUME_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
