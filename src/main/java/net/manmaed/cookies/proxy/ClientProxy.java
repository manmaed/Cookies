package net.manmaed.cookies.proxy;

import net.manmaed.cookies.render.GiftBoxRenderer;
import net.manmaed.cookies.tile.TileEntityGiftBox;
import net.minecraftforge.fml.client.registry.ClientRegistry;

/**
 * Created by manmaed on 30/01/2019.
 */
public class ClientProxy extends CommonProxy {

    public void renderinfo() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGiftBox.class, new GiftBoxRenderer());
    }
}
