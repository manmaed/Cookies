package net.manmaed.cookies.items.base;

import net.manmaed.cookies.libs.Reference;
import net.minecraft.item.ItemFood;
import net.manmaed.cookies.Cookies;

/**
 * Created by manmaed on 13/01/2019.
 */
public class CookieFoodBase extends ItemFood {

    public CookieFoodBase(String name, int amount, float saturation) {
        super(amount, saturation, false);
        setCreativeTab(Cookies.tabsCookies);
        setTranslationKey(Reference.MOD_ID + "." + name);

    }
}
