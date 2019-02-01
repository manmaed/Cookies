package net.manmaed.cookies.items.food;

import net.manmaed.cookies.items.base.CookieFoodBase;

/**
 * Created by manmaed on 13/01/2019.
 */
public class ChocCookie extends CookieFoodBase {
    public ChocCookie(int amount, float saturation) {
        super(amount, saturation);
        setUnlocalizedName("choc_chip_cookie");
    }
}
