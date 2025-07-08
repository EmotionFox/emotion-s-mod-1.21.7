package fr.emotion.emomod;

import fr.emotion.emomod.init.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = EmotionsMod.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = EmotionsMod.MODID, value = Dist.CLIENT)
public class EmotionsModClient {
    public EmotionsModClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        EmotionsMod.LOGGER.info("HELLO FROM CLIENT SETUP");
        EmotionsMod.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> key = event.getTabKey();

        if (key == CreativeModeTabs.INGREDIENTS) {
            event.accept(ItemRegistry.PURPURA_SHARD.get());
            event.accept(ItemRegistry.FOSSIL.get());
        }
        else if (key == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ItemRegistry.PURPURA_SWORD.get());
            event.accept(ItemRegistry.PURPURA_SHOVEL.get());
            event.accept(ItemRegistry.PURPURA_PICKAXE.get());
            event.accept(ItemRegistry.PURPURA_AXE.get());
            event.accept(ItemRegistry.PURPURA_HOE.get());
        }
    }
}
