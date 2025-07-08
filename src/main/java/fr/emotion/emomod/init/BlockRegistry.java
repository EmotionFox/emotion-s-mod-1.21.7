package fr.emotion.emomod.init;

import fr.emotion.emomod.EmotionsMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EmotionsMod.MODID);



    public static void init (IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
