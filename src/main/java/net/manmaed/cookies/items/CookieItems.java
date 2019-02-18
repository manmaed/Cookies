package net.manmaed.cookies.items;

import net.manmaed.cookies.Cookies;
import net.minecraft.item.FoodItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by manmaed on 13/01/2019.
 */
public class CookieItems {

    public final static Item.Settings ITEM_SETTINGS = new Item.Settings().itemGroup(Cookies.itemGroup);


    public static final List<Item> ITEMS = new ArrayList<>();
    //public static Item itemname;
    //Other Junk
    public static Item yellowRibbon;
    public static Item handgrinder;
    /*public static Item giftboxPlain;*/

    //Ingredients
    public static Item sugarPowder;
    public static Item gingerPowder;
    public static Item chocpowder;

    //Cookie Cutters
    public static Item ccGBMan;
    public static Item ccTree;

    public static void load() {

        for (CookieTypes.Shapes shape : CookieTypes.Shapes.values()) {
            registerItem(shape.name().toLowerCase() + "_cookie_cutter");
            for (CookieTypes.Types type : CookieTypes.Types.values()) {
                String name = shape.name().toLowerCase() + "_" + type.name().toLowerCase() + "_cookie";
                registerFood(name, shape.getHungerRestored() + type.getHungerRestored(), shape.getStation() + type.getStation());
            }
        }

        registerFood("chocolate_chips", 1, 0.2F);
        registerFood("cookie_dough", 1,0.2F);
        //Special
        registerFood("gingerbread_man_cookie", 1,0.2F);
        registerFood("tree_christmas_cookie", 1,0.2F);

        yellowRibbon = registerItem("ribbon_yellow");
        handgrinder = registerItem("hand_grinder");

        //Ingredients
        sugarPowder = registerItem("sugar_powder");
        gingerPowder = registerItem("ginger_powder");
        chocpowder = registerItem("chocolate_powder");

        //Special
        ccGBMan = registerItem("gbman_cookie_cutter");
        ccTree = registerItem("tree_cookie_cutter");

    }

    public static Item registerItem(String name) {
        Item item = new Item(ITEM_SETTINGS);
        Registry.register(Registry.ITEM, new Identifier(Cookies.MOD_ID, name), item);
        ITEMS.add(item);
        return item;
    }

    public static FoodItem registerFood(String name, int f1, float f2) {
        FoodItem foodItem = new FoodItem(f1, f2,false, ITEM_SETTINGS);
        Registry.register(Registry.ITEM, new Identifier(Cookies.MOD_ID, name), foodItem);
        ITEMS.add(foodItem);
        return foodItem;
    }
}
