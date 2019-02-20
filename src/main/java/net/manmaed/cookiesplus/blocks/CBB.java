package net.manmaed.cookiesplus.blocks;

import net.manmaed.cookiesplus.Cookies;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * Created by manmaed on 19/02/2019.
 */
public class CBB extends Block {

    public CBB(String name, Material material, float hardness, float resistance, String toolclass, int level, SoundType soundType) {
        super(material);
        setTranslationKey(name);
        setCreativeTab(Cookies.tabsCookies);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(toolclass, level);
        setSoundType(soundType);
    }
}
