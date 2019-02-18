package net.manmaed.cookiesplus.client;

import net.manmaed.cookiesplus.libs.Reference;
import net.manmaed.cookiesplus.libs.RegistryHelper;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by manmaed on 03/07/2017.
 */
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
public class EventModelRender
{

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void renderModels(ModelRegistryEvent event) {
        RegistryHelper.BLOCKS.forEach(block -> ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory")));
        RegistryHelper.ITEMS.forEach(item -> ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory")));
    }
}