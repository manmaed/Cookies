package net.manmaed.cookies.libs.events;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.manmaed.cookies.Cookies;

public class EventItemRegister
{
    public EventItemRegister()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        for (Block block : Cookies.getRegistryHelper().getRegisteredBlocks()) {
            event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        }
        for (Item item : Cookies.getRegistryHelper().getRegisteredItems()) {
            event.getRegistry().register(item);
        }
    }
}