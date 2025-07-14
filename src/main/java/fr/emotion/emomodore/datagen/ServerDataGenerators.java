package fr.emotion.emomodore.datagen;

import fr.emotion.emomodore.MainRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = MainRegistry.MODID, value = Dist.DEDICATED_SERVER)
public class ServerDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Server event) {

    }
}
