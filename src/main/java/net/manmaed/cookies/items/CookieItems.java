package net.manmaed.cookies.items;

import com.unrealdinnerbone.unreallib.api.registry.IRegistryItem;
import com.unrealdinnerbone.unreallib.util.ItemUtil;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.manmaed.cookies.Cookies;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class CookieItems {

    private final static ItemGroup BASIC_ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(Cookies.MOD_ID, Cookies.MOD_ID)).icon(ItemUtil.getItemStack(Items.ACACIA_BUTTON)).build();
    public final static Item.Settings ITEM_SETTINGS = new Item.Settings().group(BASIC_ITEM_GROUP);

    public enum Basic implements IRegistryItem<Item> {
        HAND_GRINDER,
        RIBBON_YELLOW,
        SUGAR_POWDER,
        CHOCOLATE_POWDER,
        GINGER_POWDER,
        GBMAN_COOKIE_CUTTER,
        TREE_COOKIE_CUTTER,
        ROUND_COOKIE_CUTTER,
        SQUARE_COOKIE_CUTTER,
        STAR_COOKIE_CUTTER;

        private final Item item;

        Basic() {
            item = new Item(ITEM_SETTINGS);
        }

        @Override
        public Item get() {
            return item;
        }
    }

    public enum Foods implements IRegistryItem<Item> {
        CHOCOLATE_CHIPS(1, 0.2f),
        COOKIE_DOUGH(1, 0.2f),
        GINGERBREAD_MAN_COOKIE(1, 0.2f),
        TREE_CHRISTMAS_COOKIE(1, 0.2f),

        ROUND_PLAIN_COOKIE(2, 1f),
        SQUARE_PLAIN_COOKIE(2, 1f),
        STAR_PLAIN_COOKIE(2, 1f),

        ROUND_SUGAR_COOKIE(1, 3),
        SQUARE_SUGAR_COOKIE(1, 3),
        STAR_SUGAR_COOKIE(1, 3),

        ROUND_CHOCOLATE_CHIP_COOKIE(2, 2f),
        SQUARE_CHOCOLATE_CHIP_COOKIE(2, 2f),
        STAR_CHOCOLATE_CHIP_COOKIE(2, 2f),

        ROUND_DOUBLE_CHOCOLATE_CHIP_COOKIE(3, 4f),
        SQUARE_DOUBLE_CHOCOLATE_CHIP_COOKIE(3, 4f),
        STAR_DOUBLE_CHOCOLATE_CHIP_COOKIE(3, 4f);


        private final Item item;

        Foods(int hungerRestored, float station) {
            this.item = new Item(new Item.Settings().group(BASIC_ITEM_GROUP).food(new FoodComponent.Builder().hunger(hungerRestored).saturationModifier(station).build()));
        }

        @Override
        public Item get() {
            return item;
        }
    }
}
