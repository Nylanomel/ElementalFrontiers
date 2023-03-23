package com.nylanomel.frontiers;

import com.mojang.logging.LogUtils;
import com.nylanomel.frontiers.init.BlockEntityInit;
import com.nylanomel.frontiers.init.BlockInit;
import com.nylanomel.frontiers.init.ItemInit;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


import org.slf4j.Logger;

@Mod(Frontiers.MODID)
public class Frontiers {
    public static final String MODID = "frontiers";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Frontiers() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        BlockInit.BLOCKS.register(modEventBus);
        ItemInit.ITEMS.register(modEventBus);
        BlockEntityInit.BLOCK_ENTITIES.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::buildContents);
    }

    private void commonSetup(final FMLClientSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    @SubscribeEvent
    public void buildContents(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(MODID, "frontiers"), builder ->
        // Set name of tab to display
            builder.title(Component.translatable("item_group." + MODID + ".resources"))
            // Set icon of creative tab
            .icon(() -> new ItemStack(ItemInit.SEARED_IRON_INGOT.get()))
            // Add default items to tab
            .displayItems((enabledFlags, populator, hasPermissions) -> {
            populator.accept(BlockInit.SEARED_IRON_ORE.get());
            populator.accept(BlockInit.DEEPSLATE_SEARED_IRON_ORE.get());
            populator.accept(ItemInit.RAW_SEARED_IRON.get());
            populator.accept(ItemInit.SEARED_IRON_INGOT.get());
            })
        );
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
