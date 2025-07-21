package fr.emotion.emomodore.datagen;

import fr.emotion.emomodore.MainRegistry;
import fr.emotion.emomodore.advancements.MinePurpura;
import fr.emotion.emomodore.advancements.MineViridis;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;
import java.util.Set;

@Mod(value = MainRegistry.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = MainRegistry.MODID, value = Dist.CLIENT)
public class ClientDataGenerators {
    public static final ResourceKey<ConfiguredFeature<?, ?>> FOSSIL_ORE_CONFIGURED_FEATURE = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(MainRegistry.MODID, "fossil_ore")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPURA_ORE_BURIED_CONFIGURED_FEATURE = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(MainRegistry.MODID, "purpura_ore_buried")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPURA_ORE_SMALL_CONFIGURED_FEATURE = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(MainRegistry.MODID, "purpura_ore_small")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPURA_ORE_MEDIUM_CONFIGURED_FEATURE = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(MainRegistry.MODID, "purpura_ore_medium")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> PURPURA_ORE_LARGE_CONFIGURED_FEATURE = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(MainRegistry.MODID, "purpura_ore_large")
    );

    public static final ResourceKey<ConfiguredFeature<?, ?>> VIRIDIS_ORE_CONFIGURED_FEATURE = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(MainRegistry.MODID, "viridis_ore")
    );

    public static final ResourceKey<PlacedFeature> FOSSIL_ORE_PLACED_FEATURE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(MainRegistry.MODID, "fossil_ore")
    );

    public static final ResourceKey<PlacedFeature> PURPURA_ORE_BURIED_PLACED_FEATURE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(MainRegistry.MODID, "purpura_ore_buried")
    );

    public static final ResourceKey<PlacedFeature> PURPURA_ORE_SMALL_PLACED_FEATURE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(MainRegistry.MODID, "purpura_ore_small")
    );

    public static final ResourceKey<PlacedFeature> PURPURA_ORE_MEDIUM_PLACED_FEATURE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(MainRegistry.MODID, "purpura_ore_medium")
    );

    public static final ResourceKey<PlacedFeature> PURPURA_ORE_LARGE_PLACED_FEATURE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(MainRegistry.MODID, "purpura_ore_large")
    );

    public static final ResourceKey<PlacedFeature> VIRIDIS_ORE_PLACED_FEATURE = ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(MainRegistry.MODID, "viridis_ore")
    );

    public static final ResourceKey<BiomeModifier> FOSSIL_ORE_BIOME_MODIFIER = ResourceKey.create(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS,
            ResourceLocation.fromNamespaceAndPath(MainRegistry.MODID, "fossil_ore")
    );

    public static final ResourceKey<BiomeModifier> PURPURA_ORE_BIOME_MODIFIER = ResourceKey.create(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS,
            ResourceLocation.fromNamespaceAndPath(MainRegistry.MODID, "purpura_ore")
    );

    public static final ResourceKey<BiomeModifier> VIRIDIS_ORE_BIOME_MODIFIER = ResourceKey.create(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS,
            ResourceLocation.fromNamespaceAndPath(MainRegistry.MODID, "viridis_ore")
    );

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(EmoModelProvider::new);

        event.createProvider((output, lookupProvider) -> new AdvancementProvider(
                output,
                lookupProvider,
                List.of(MinePurpura::generate, MineViridis::generate)
        ));

        event.createProvider((output, lookupProvider) -> new LootTableProvider(
                output,
                Set.of(),
                List.of(new LootTableProvider.SubProviderEntry(EmoBlockLootTableSubProvider::new, LootContextParamSets.BLOCK)),
                lookupProvider
        ));

        event.createProvider(EmoRecipeProvider.Runner::new);

        event.createProvider((output, lookupProvider) ->
                new DatapackBuiltinEntriesProvider(
                        output,
                        lookupProvider,
                        EmoSetBuilder.createBuilder(),
                        Set.of(MainRegistry.MODID))
        );
    }
}
