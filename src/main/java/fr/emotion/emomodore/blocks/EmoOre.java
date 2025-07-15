package fr.emotion.emomodore.blocks;

import fr.emotion.emomodore.init.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EmoOre extends DropExperienceBlock {
    private VoxelShape SHAPE = Block.cube(16);
            
    public EmoOre(VoxelShape shape, IntProvider xpRange, Properties properties) {
        this(xpRange, properties);

        SHAPE = shape;
    }

    public EmoOre(IntProvider xpRange, Properties properties)
    {
        super(xpRange, properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState state) {
        if (this == BlockRegistry.VIRIDIS_CRISTAL.get())
            return state.getFluidState().isEmpty();
        else
            return super.propagatesSkylightDown(state);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        if (this == BlockRegistry.VIRIDIS_ORE.get()) level.setBlock(pos, state, 2);

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }
}
