package net.manmaed.cookies.items.base;

import net.manmaed.cookies.Cookies;
import net.minecraft.item.Item;

/**
 * Created by manmaed on 13/01/2019.
 */
public class CookieItemBase extends Item {
    public CookieItemBase(String name){
        super();
        setCreativeTab(Cookies.tabsCookies);
        setTranslationKey(name);
    }
}
