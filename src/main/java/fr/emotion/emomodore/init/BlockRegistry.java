package fr.emotion.emomodore.init;

import fr.emotion.emomodore.MainRegistry;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MainRegistry.MODID);

    public static final DeferredBlock<Block> FOSSIL_ORE = addBlock("fossil_ore", (props) -> new DropExperienceBlock(UniformInt.of(3, 7), props.mapColor(MapColor.DIRT).strength(0.5F)));

    public static final DeferredBlock<Block> PURPURA_ORE = addBlock("purpura_ore", (props) -> new DropExperienceBlock(UniformInt.of(3, 7), props.mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(9.0F, 10F)));
    public static final DeferredBlock<Block> PURPURA_BLOCK = addBlock("purpura_block", (props) -> new Block(props.mapColor(MapColor.COLOR_PURPLE).requiresCorrectToolForDrops().strength(7.0F, 14.0F).sound(SoundType.METAL)));

    private static <T extends Block> DeferredBlock<T> addBlock(String name, Function<BlockBehaviour.Properties, T> func) {
        DeferredBlock<T> returnBlock = BLOCKS.registerBlock(name, func);
        registerBlockItem(name, returnBlock);
        return returnBlock;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ItemRegistry.ITEMS.registerSimpleBlockItem(name, block);
    }

    public static void init (IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
