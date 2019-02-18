package net.manmaed.cookiesplus.tab;

import net.manmaed.cookiesplus.libs.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by manmaed on 13/01/2019.
 */
public class CookiesCreativeTab extends CreativeTabs {

    public CookiesCreativeTab(int id) {
        super(Reference.MOD_ID);
    }

    @Override
    public String getTranslationKey() {
        return "cookietab.name";
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Items.COOKIE);
    }
}
