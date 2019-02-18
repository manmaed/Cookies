package net.manmaed.cookiesplus.items.base;

import net.manmaed.cookiesplus.Cookies;
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
