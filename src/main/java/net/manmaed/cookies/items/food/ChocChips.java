package net.manmaed.cookies.items.food;

import net.manmaed.cookies.items.base.CookieFoodBase;

/**
 * Created by manmaed on 13/01/2019.
 */
public class ChocChips extends CookieFoodBase {
    public ChocChips(int amount, float saturation) {
        super(amount, saturation);
        setUnlocalizedName("choc_chips");
    }
}
