package fr.emotion.emomodore.init;

import fr.emotion.emomodore.MainRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MainRegistry.MODID);

    public static final DeferredBlock<Block> FOSSIL_ORE = addBlock("fossil_ore", (props) -> new DropExperienceBlock(UniformInt.of(0, 2), props.mapColor(MapColor.DIRT).strength(0.5F)));

    public static final DeferredBlock<Block> PURPURA_ORE = addBlock("purpura_ore", (props) -> new DropExperienceBlock(UniformInt.of(3, 7), props.mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(9.0F, 10F)));
    public static final DeferredBlock<Block> DEEPSLATE_PURPURA_ORE = addBlock("deepslate_purpura_ore", (props) -> new DropExperienceBlock(UniformInt.of(3, 7), props.mapColor(MapColor.DEEPSLATE).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> PURPURA_BLOCK = addBlock("purpura_block", (props) -> new Block(props.mapColor(MapColor.COLOR_PURPLE).requiresCorrectToolForDrops().strength(7.0F, 14.0F).sound(SoundType.METAL)));

    public static final DeferredBlock<Block> VIRIDIS_ORE = addBlock("viridis_ore", (props) -> new DropExperienceBlock(UniformInt.of(3, 7), props.mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(5F, 6F)) {
        @Override
        public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
            super.playerWillDestroy(level, pos, state, player);
            level.setBlock(pos, VIRIDIS_CRYSTAL.get().defaultBlockState(), 3);
            return state;
        }
    });

    public static final DeferredBlock<Block> VIRIDIS_CRYSTAL = addBlock("viridis_crystal", (props) -> new DropExperienceBlock(UniformInt.of(3, 7), props.mapColor(MapColor.STONE).forceSolidOn().noOcclusion().requiresCorrectToolForDrops().strength(7F, 14.0F)));
    public static final DeferredBlock<Block> VIRIDIS_BLOCK = addBlock("viridis_block", (props) -> new Block(props.mapColor(MapColor.COLOR_LIGHT_GREEN).requiresCorrectToolForDrops().strength(7.0F, 14.0F).sound(SoundType.METAL)));

    public static final DeferredBlock<Block> NETHER_LUME_ORE = addBlock("nether_lume_ore", (props) -> new DropExperienceBlock(UniformInt.of(2, 5), props.mapColor(MapColor.NETHER).requiresCorrectToolForDrops().strength(4.0F, 4.0F).sound(SoundType.NETHER_ORE)));
    public static final DeferredBlock<Block> LUME_BLOCK = addBlock("lume_block", (props) -> new Block(props.mapColor(MapColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(7.0F, 14.0F).sound(SoundType.METAL)));

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
