package com.nylanomel.frontiers.blockentities;

import com.nylanomel.frontiers.init.BlockEntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CrusherBlockEntity extends BlockEntity {
    private static final int MAX_PROGRESS = 100;
    private int progress;

    public CrusherBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.CRUSHER.get(), pos, state);
    }

    public void tick() {
        progress++;
        if(progress>MAX_PROGRESS) {
            if(this.level != null) {
                progress = 0;
                var pig = new Pig(EntityType.PIG, this.level);
                pig.setPos(this.worldPosition.getX(),this.worldPosition.getY(),this.worldPosition.getZ());
                this.level.addFreshEntity(pig);
            }
        }
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);

        this.progress = nbt.getInt("Progress");
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);

        nbt.putInt("Progress", this.progress);
    }
}
