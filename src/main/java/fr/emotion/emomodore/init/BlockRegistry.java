package fr.emotion.emomodore.init;

import fr.emotion.emomodore.MainRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MainRegistry.MODID);



    public static void init (IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
