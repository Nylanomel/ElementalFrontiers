package com.nylanomel.frontiers.init;

import com.nylanomel.frontiers.Frontiers;
import com.nylanomel.frontiers.blockentities.CrusherBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Frontiers.MODID);

    public static final RegistryObject<BlockEntityType<CrusherBlockEntity>> CRUSHER = BLOCK_ENTITIES.register("crusher",
        () -> BlockEntityType.Builder.of(CrusherBlockEntity::new, BlockInit.CRUSHER.get()).build(null));
}
