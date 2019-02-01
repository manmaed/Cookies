package net.manmaed.cookies.items.food;

import net.manmaed.cookies.items.base.CookieFoodBase;

/**
 * Created by manmaed on 13/01/2019.
 */
public class PlainCookie extends CookieFoodBase {
    public PlainCookie(int amount, float saturation) {
        super(amount, saturation);
        setUnlocalizedName("plain_cookie");
    }
}
