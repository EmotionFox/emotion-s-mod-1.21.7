package fr.emotion.emomodore;

import fr.emotion.emomodore.init.BlockRegistry;
import fr.emotion.emomodore.init.ItemRegistry;
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
@Mod(value = MainRegistry.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = MainRegistry.MODID, value = Dist.CLIENT)
public class MainRegistryClient {
    public MainRegistryClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        MainRegistry.LOGGER.info("HELLO FROM CLIENT SETUP");
        MainRegistry.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> key = event.getTabKey();

        if (key == CreativeModeTabs.INGREDIENTS) {
            event.accept(ItemRegistry.PURPURA_SHARD.get());
            event.accept(ItemRegistry.FOSSIL.get());
        }
        else if (key == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ItemRegistry.PURPURA_SHOVEL.get());
            event.accept(ItemRegistry.PURPURA_PICKAXE.get());
            event.accept(ItemRegistry.PURPURA_HOE.get());

            event.accept(ItemRegistry.FOSSIL_SHOVEL.get());
            event.accept(ItemRegistry.FOSSIL_PICKAXE.get());
            event.accept(ItemRegistry.FOSSIL_HOE.get());
        }
        else if (key == CreativeModeTabs.COMBAT) {
            event.accept(ItemRegistry.PURPURA_SWORD.get());
            event.accept(ItemRegistry.PURPURA_AXE.get());

            event.accept(ItemRegistry.FOSSIL_SWORD.get());
            event.accept(ItemRegistry.FOSSIL_AXE.get());
        }
        else if (key == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(BlockRegistry.PURPURA_BLOCK.get());
            event.accept(BlockRegistry.VIRIDIS_BLOCK.get());
        }
        else if (key == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(BlockRegistry.FOSSIL_ORE.get());
            event.accept(BlockRegistry.PURPURA_ORE.get());
            event.accept(BlockRegistry.DEEPSLATE_PURPURA_ORE.get());
            event.accept(BlockRegistry.VIRIDIS_ORE.get());
            event.accept(BlockRegistry.VIRIDIS_CRISTAL.get());
        }
    }
}
