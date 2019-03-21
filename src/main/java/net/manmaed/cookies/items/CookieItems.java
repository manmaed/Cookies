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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class CookieItems {

    private final static ItemGroup BASIC_ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(Cookies.MOD_ID, Cookies.MOD_ID)).icon(() -> new ItemStack(Items.COOKIE)).build();
    public final static Item.Settings ITEM_SETTINGS = new Item.Settings().itemGroup(BASIC_ITEM_GROUP);

    public static void load(RegistryHelper registry) {
        System.out.println("Cooking " + Cookie.Types.values().length * Cookie.Cutters.values().length + " Cookie!");
        Arrays.stream(Cookie.Cutters.values()).forEach(shape -> registry.registerItem(createBasicItem(), EnumUtil.getNameOfEnum(shape) + "_cookie_cutter"));
        Arrays.stream(Cookie.Cutters.values()).forEach(shape -> Arrays.stream(Cookie.Types.values()).forEach(type -> {
            IHungerFood iHungerFood = new IHungerFood() {
                @Override
                public ItemGroup getItemGroup() {
                    return BASIC_ITEM_GROUP;
                }
                @Override
                public int getHungerRestored() {
                    return CookieItems.getHungerRestored(shape, type);
                }
                @Override
                public float getStation() {
                    return CookieItems.getStationAmount(shape, type);
                }
            };
            registry.registerItem(new Item(iHungerFood.getItemSetting()), EnumUtil.getNameOfEnum(shape, type) + "_cookie");
        }));
        registry.registerEnumAsItem(Basic.class);
        registry.registerEnumAsItem(Foods.class);
    }

    private static Item createBasicItem() {
        return new Item(ITEM_SETTINGS);
    }

    public static float getStationAmount(IHungerFood... iHungerFood) {
        float count = 0;
        for (IHungerFood hungerFood : iHungerFood) {
            count += hungerFood.getStation();
        }
        return count;
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
            public ItemGroup getItemGroup() {
                return BASIC_ITEM_GROUP;
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
            public ItemGroup getItemGroup() {
                return getItemGroup();
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

        @Override
        public ItemGroup getItemGroup() {
            return BASIC_ITEM_GROUP;
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
        public int getHungerRestored() {
            return hungerRestored;
        }

        @Override
        public float getStation() {
            return station;
        }

        @Override
        public ItemGroup getItemGroup() {
            return BASIC_ITEM_GROUP;
        }
    }
}
