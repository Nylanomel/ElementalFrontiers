package com.nylanomel.frontiers.init;

import com.nylanomel.frontiers.Frontiers;
import com.nylanomel.frontiers.block.CrusherBlock;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Frontiers.MODID);

    public static final RegistryObject<CrusherBlock> CRUSHER = BLOCKS.register("crusher",
    () -> new CrusherBlock(BlockBehaviour.Properties.of(Material.METAL)));
    public static final RegistryObject<BlockItem> CRUSHER_ITEM = ItemInit.ITEMS.register("crusher",
    () -> new BlockItem(CRUSHER.get(), new Item.Properties()));



    public static final RegistryObject<Block> SEARED_IRON_ORE = BLOCKS.register("seared_iron_ore",
    () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3.5f,3f).requiresCorrectToolForDrops().lightLevel((state) -> 6)));
    public static final RegistryObject<BlockItem> SEARED_IRON_ORE_ITEM = ItemInit.ITEMS.register("seared_iron_ore",
    () -> new BlockItem(SEARED_IRON_ORE.get(), new Item.Properties()));

    public static final RegistryObject<Block> DEEPSLATE_SEARED_IRON_ORE = BLOCKS.register("deepslate_seared_iron_ore",
    () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f,3f).requiresCorrectToolForDrops().lightLevel((state) -> 6)));
    public static final RegistryObject<BlockItem> DEEPSLATE_SEARED_IRON_ORE_ITEM = ItemInit.ITEMS.register("deepslate_seared_iron_ore",
    () -> new BlockItem(DEEPSLATE_SEARED_IRON_ORE.get(), new Item.Properties()));

}
