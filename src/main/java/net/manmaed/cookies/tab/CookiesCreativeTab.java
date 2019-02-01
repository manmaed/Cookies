package net.manmaed.cookies.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.manmaed.cookies.libs.Reference;
import net.minecraft.util.text.translation.I18n;

/**
 * Created by manmaed on 13/01/2019.
 */
public class CookiesCreativeTab extends CreativeTabs {

    public CookiesCreativeTab(int id) {
        super(Reference.MOD_ID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Items.COOKIE);
    }

    @Override
    public String getTranslatedTabLabel() {
        return I18n.translateToLocal("cookietab.name");
    }
}
