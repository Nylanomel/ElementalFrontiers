package com.nylanomel.frontiers.init;

import com.nylanomel.frontiers.Frontiers;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Frontiers.MODID);

    public static final RegistryObject<Item> RAW_SEARED_IRON = ITEMS.register("raw_seared_iron", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SEARED_IRON_INGOT = ITEMS.register("seared_iron_ingot", () -> new Item(new Item.Properties()));
}
