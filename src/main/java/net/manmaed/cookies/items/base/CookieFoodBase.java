package net.manmaed.cookies.items.base;

import net.minecraft.item.ItemFood;
import net.manmaed.cookies.Cookies;

/**
 * Created by manmaed on 13/01/2019.
 */
public class CookieFoodBase extends ItemFood {
    public CookieFoodBase(int amount, float saturation) {
        super(amount, saturation, false);
        setCreativeTab(Cookies.tabsCookies);
    }
}
