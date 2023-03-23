package com.nylanomel.frontiers.block;

import javax.annotation.Nullable;

import com.nylanomel.frontiers.blockentities.CrusherBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CrusherBlock extends Block implements EntityBlock {
    public CrusherBlock(Properties prop) {
        super(prop);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return null;//BlockEntity.CRUSHER.get().create(pos, state);
    }

    // Only necessary if the BlockEntity needs to do something every tick
    //@Nullable
    //@Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide() ? null : ($0, $1, $2, blockEntity) -> {
            if(blockEntity instanceof CrusherBlockEntity crusher) {
                crusher.tick();
            }
        };
    }
}
