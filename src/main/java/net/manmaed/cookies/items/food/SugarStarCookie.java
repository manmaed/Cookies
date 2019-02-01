package net.manmaed.cookies.items.food;

import net.manmaed.cookies.items.base.CookieFoodBase;

/**
 * Created by manmaed on 13/01/2019.
 */
public class SugarStarCookie extends CookieFoodBase {
    public SugarStarCookie(int amount, float saturation) {
        super(amount, saturation);
        setUnlocalizedName("sugar_cookie_star");
    }
}
