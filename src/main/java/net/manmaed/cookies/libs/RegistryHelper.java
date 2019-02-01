package net.manmaed.cookies.libs;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.GameData;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.ArrayList;


/**
 * Created by manmaed on 24/02/2017.
 */
public class RegistryHelper {

   public static final ArrayList<Block> BLOCKS = new ArrayList<>();
   public static final ArrayList<Item> ITEMS = new ArrayList<>();

    private static <T extends IForgeRegistryEntry<T>> void register(T registryEntry, String name) {
        GameData.register_impl(registryEntry.setRegistryName(new ResourceLocation(Reference.MOD_ID, name)));
    }

    public static <T extends Block> void registerBlock(T block, String name) {
        register(block, name);
        BLOCKS.add(block);
        registerItem(new ItemBlock(block), name);
    }

    public static <T extends Item> void registerItem(T item, String name) {
        register(item, name);
        ITEMS.add(item);
    }
}
