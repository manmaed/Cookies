package net.manmaed.cookies.items.base;

import net.minecraft.item.Item;
import net.manmaed.cookies.Cookies;

/**
 * Created by manmaed on 13/01/2019.
 */
public class CookieCutterBase extends Item {
    public CookieCutterBase(){
        super();
        setCreativeTab(Cookies.tabsCookies);
        setMaxStackSize(1);
    }
}
