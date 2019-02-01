package net.manmaed.cookies.libs;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.manmaed.cookies.libs.events.EventRegisterHelper;

import java.util.ArrayList;

/**
 * Created by manmaed on 24/02/2017.
 */
public class RegistryHelper {

    private final ArrayList<Block> blocks = new ArrayList<>();
    private final ArrayList<Item> items = new ArrayList<>();
    private final ArrayList<Entity> entitys = new ArrayList<>();
    private final ArrayList<TileEntity> tileEntities = new ArrayList<>();

    private final EventRegisterHelper eventRegisterHelper;

    public RegistryHelper(FMLPreInitializationEvent event)
    {
        this.eventRegisterHelper = new EventRegisterHelper(event);

    }

    public ArrayList<Block> getRegisteredBlocks()

    {
        return blocks;
    }

    public void registerBlock(Block block)
    {
        blocks.add(block);
    }
    public ArrayList<Item> getRegisteredItems()
    {
        return items;
    }
    public void registerItem(Item item)
    {
        this.items.add(item);
    }
    public ArrayList<Entity> getRegisteredIEntitys()
    {
        return entitys;
    }
    public void registerEntity(Entity entity)
    {
        this.entitys.add(entity);
    }

    public ArrayList<TileEntity> getRegisteredTileEntitys()

    {
        return tileEntities;
    }

    public void registerTileEntity(TileEntity tileEntity)
    {
        tileEntities.add(tileEntity);
    }



}
