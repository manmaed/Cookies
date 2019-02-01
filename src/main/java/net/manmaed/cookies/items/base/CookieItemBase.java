package net.manmaed.cookies.items.base;

import net.manmaed.cookies.libs.Reference;
import net.minecraft.item.Item;
import net.manmaed.cookies.Cookies;

/**
 * Created by manmaed on 13/01/2019.
 */
public class CookieItemBase extends Item {
    public CookieItemBase(String name){
        super();
        setCreativeTab(Cookies.tabsCookies);
        setTranslationKey(Reference.MOD_ID + "." + name);
    }
}
