package fr.emotion.emomodore.datagen;

import fr.emotion.emomodore.MainRegistry;
import fr.emotion.emomodore.advancements.MinePurpura;
import fr.emotion.emomodore.advancements.MineViridis;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = MainRegistry.MODID, value = Dist.DEDICATED_SERVER)
public class ServerDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Server event) {
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
    }
}
