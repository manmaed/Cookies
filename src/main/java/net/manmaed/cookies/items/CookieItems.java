package net.manmaed.cookies.items;

import com.unrealdinnerbone.unreallib.api.IHungerFood;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.manmaed.cookies.Cookies;
import com.unrealdinnerbone.unreallib.api.IItemEnum;
import com.unrealdinnerbone.unreallib.api.RegistryHelper;
import net.manmaed.cookies.lib.EnumUtil;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;

import java.util.Arrays;

public class CookieItems {

    private final static ItemGroup BASIC_ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(Cookies.MOD_ID, Cookies.MOD_ID)).icon(() -> new ItemStack(Items.COOKIE)).build();
    public final static Item.Settings ITEM_SETTINGS = new Item.Settings().itemGroup(BASIC_ITEM_GROUP);

    public static void load(RegistryHelper registry) {
        System.out.println("Cooking " + Cookie.Types.values().length * Cookie.Cutters.values().length + " Cookie!");
        Arrays.stream(Cookie.Cutters.values()).forEach(shape -> registry.registerItem(createBasicItem(), EnumUtil.getNameOfEnum(shape) + "_cookie_cutter"));
        Arrays.stream(Cookie.Cutters.values()).forEach(shape -> Arrays.stream(Cookie.Types.values()).forEach(type -> registry.registerItem(createFoodItem(getHungerRestored(shape, type), getStationAmount(shape, type)), EnumUtil.getNameOfEnum(shape, type) + "_cookie")));
        registry.registerEnumAsItem(Basic.class);
        registry.registerEnumAsFoodItem(Foods.class);
    }

    private static Item createBasicItem() {
        return new Item(ITEM_SETTINGS);
    }
    private static FoodItem createFoodItem(int f1, float f2) {
        return new FoodItem(f1, f2, false, ITEM_SETTINGS);
    }

    public static float getStationAmount(IHungerFood... iHungeFood) {
        float nunber = 0;
        for (IHungerFood hungeFood : iHungeFood) {
            nunber += hungeFood.getStation();
        }
        return nunber;
    }

    public static int getHungerRestored(IHungerFood... iHungerFood) {
        return Arrays.stream(iHungerFood).mapToInt(IHungerFood::getHungerRestored).sum();
    }

    public static class Cookie {

        public enum Cutters implements IHungerFood {
            ROUND(1, 1f),
            SQUARE(2, 2f),
            STAR(1, 1f);

            private int hungerRestored;
            private float station;

            Cutters(int hungerRestored, float station) {
                this.hungerRestored = hungerRestored;
                this.station = station;
            }

            @Override
            public Item.Settings getItemSetting() {
                return ITEM_SETTINGS;
            }

            @Override
            public int getHungerRestored() {
                return hungerRestored;
            }

            @Override
            public float getStation() {
                return station;
            }
        }


        public enum Types implements IHungerFood {

            PLAIN(2, 1f),
            SUGAR(1, 3),
            CHOCOLATE_CHIP(2, 2f),
            DOUBLE_CHOCOLATE_CHIP(3, 4f);

            private int hungerRestored;
            private float station;

            Types(int hungerRestored, float station) {
                this.hungerRestored = hungerRestored;
                this.station = station;
            }

            @Override
            public Item.Settings getItemSetting() {
                return ITEM_SETTINGS;
            }

            @Override
            public int getHungerRestored() {
                return hungerRestored;
            }

            @Override
            public float getStation() {
                return station;
            }
        }
    }


    public enum Basic implements IItemEnum {
        HAND_GRINDER,
        RIBBON_YELLOW,
        SUGAR_POWDER,
        CHOCOLATE_POWDER,
        GBMAN_COOKIE_CUTTER,
        TREE_COOKIE_CUTTER;

        @Override
        public Item.Settings getItemSetting() {
            return ITEM_SETTINGS;
        }
    }

    public enum Foods implements IHungerFood {
        CHOCOLATE_CHIPS(1, 0.2f),
        COOKIE_DOUGH(1, 0.2f),
        GINGERBREAD_MAN_COOKIE(1, 0.2f),
        TREE_CHRISTMAS_COOKIE(1, 0.2f);

        private int hungerRestored;
        private float station;

        Foods(int hungerRestored, float station) {
            this.hungerRestored = hungerRestored;
            this.station = station;
        }

        @Override
        public Item.Settings getItemSetting() {
            return ITEM_SETTINGS;
        }

        @Override
        public int getHungerRestored() {
            return hungerRestored;
        }

        @Override
        public float getStation() {
            return station;
        }
    }
}
