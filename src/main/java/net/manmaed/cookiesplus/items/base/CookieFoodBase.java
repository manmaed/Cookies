package net.manmaed.cookiesplus.items.base;

import net.manmaed.cookiesplus.Cookies;
import net.minecraft.item.ItemFood;

/**
 * Created by manmaed on 13/01/2019.
 */
public class CookieFoodBase extends ItemFood {

    public CookieFoodBase(String name, int amount, float saturation) {
        super(amount, saturation, false);
        setCreativeTab(Cookies.tabsCookies);
        setTranslationKey(name);

    }
}
