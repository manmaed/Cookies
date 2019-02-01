package net.manmaed.cookies.libs.events;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.manmaed.cookies.Cookies;

/**
 * Created by manmaed on 03/07/2017.
 */
public class EventBlockRegister {

    public EventBlockRegister()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        for (Block block : Cookies.getRegistryHelper().getRegisteredBlocks()) {
            event.getRegistry().registerAll(block);
        }
    }

}
