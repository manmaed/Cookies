package net.manmaed.cookies.proxy;

import net.manmaed.cookies.blocks.giftbox.GiftBoxContainerTileEntity;
import net.manmaed.cookies.render.GiftBoxRenderer;
import net.minecraftforge.fml.client.registry.ClientRegistry;

/**
 * Created by manmaed on 30/01/2019.
 */
public class ClientProxy extends CommonProxy {

    public void renderinfo() {
        ClientRegistry.bindTileEntitySpecialRenderer(GiftBoxContainerTileEntity.class, new GiftBoxRenderer());
    }
}
