package net.manmaed.cookies.items.food;

import net.manmaed.cookies.items.base.CookieFoodBase;

/**
 * Created by manmaed on 13/01/2019.
 */
public class SugarSquareCookie extends CookieFoodBase {
    public SugarSquareCookie(int amount, float saturation) {
        super(amount, saturation);
        setUnlocalizedName("sugar_cookie_square");
    }
}
