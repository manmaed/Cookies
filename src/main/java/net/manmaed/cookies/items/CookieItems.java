package net.manmaed.cookies.items;

import net.manmaed.cookies.items.base.CookieCutterBase;
import net.manmaed.cookies.items.base.CookieFoodBase;
import net.manmaed.cookies.items.base.CookieItemBase;
import net.manmaed.cookies.libs.RegistryHelper;
import net.minecraft.item.Item;

/**
 * Created by manmaed on 13/01/2019.
 */
public class CookieItems {

    //public static Item itemname;
    //Other Junk
    public static CookieItemBase yellowRibbon;
    public static CookieItemBase handgrinder;
    /*public static CookieItemBase giftboxPlain;*/

    //Ingredients
    public static CookieItemBase sugarPowder;
    public static CookieItemBase gingerPowder;
    public static Item ginger;
    public static CookieItemBase chocpowder;

    //Cookie Cutters
    public static CookieCutterBase ccCircle;
    public static CookieCutterBase ccGBMan;
    public static CookieCutterBase ccSquare;
    public static CookieCutterBase ccStar;
    public static CookieCutterBase ccTree;

    //Foods
    public static CookieFoodBase chocchips;
    public static CookieFoodBase cookiedough;
    public static CookieFoodBase plainCircle;
    public static CookieFoodBase plainSquare;
    public static CookieFoodBase plainStar;

    public static CookieFoodBase sugarCircle;
    public static CookieFoodBase sugarSquare;
    public static CookieFoodBase sugarStar;

    public static CookieFoodBase chocolateCircle;
    public static CookieFoodBase chocolateSquare;
    public static CookieFoodBase chocolateStar;

    public static CookieFoodBase doublechocolateCircle;
    public static CookieFoodBase doublechocolateSquare;
    public static CookieFoodBase doublechocolateStar;

    public static void load() {
        //Init'ing
        //itemname = new ItemClass();
       /* giftboxPlain = new GiftBoxPlain();*/
        yellowRibbon = new CookieItemBase("ribbon_yellow");
        handgrinder = new CookieItemBase("hand_grinder");


        //Ingredients
        sugarPowder = new CookieItemBase("sugarpowder");
        gingerPowder = new CookieItemBase("gingerpowder");
        ginger = new Ginger();
        chocpowder = new CookieItemBase("chocpowder");

        //Cookie Cutters
        ccCircle = new CookieCutterBase("circle");
        ccGBMan = new CookieCutterBase("gbman");
        ccSquare = new CookieCutterBase("square");
        ccStar = new CookieCutterBase("star");
        ccTree = new CookieCutterBase("tree");

        //Foods
        chocchips = new CookieFoodBase("chocchips", 1, 0.2F);
        cookiedough = new CookieFoodBase("cookiedough", 1,0.2F);
        plainCircle = new CookieFoodBase("plaincircle", 2, 0.4F);
        plainSquare = new CookieFoodBase("plainsquare", 2, 0.4F);
        plainStar = new CookieFoodBase("plainstar", 2, 0.4F);

        sugarCircle = new CookieFoodBase("sugarcircle", 2, 0.4F);
        sugarSquare = new CookieFoodBase("sugarsquare", 2, 0.4F);
        sugarStar = new CookieFoodBase("sugarstar", 2, 0.4F);

        chocolateCircle = new CookieFoodBase("chocolatecircle", 2, 0.4F);
        chocolateSquare = new CookieFoodBase("chocolatesquare", 2, 0.4F);
        chocolateStar = new CookieFoodBase("chocolatestar", 2, 0.4F);

        doublechocolateCircle = new CookieFoodBase("doublechocolatecircle", 2, 0.4F);
        doublechocolateSquare = new CookieFoodBase("doublechocolatesquare", 2, 0.4F);
        doublechocolateStar = new CookieFoodBase("doublechocolatecirclestar", 2, 0.4F);


        RegistryHelper.registerItem(yellowRibbon, "ribbon_yellow");
        RegistryHelper.registerItem(handgrinder, "hand_grinder");

        //Ingredients
        RegistryHelper.registerItem(sugarPowder, "sugarpowder");
        RegistryHelper.registerItem(gingerPowder, "gingerpowder");
        RegistryHelper.registerItem(ginger, "ginger");
        RegistryHelper.registerItem(chocpowder, "chocolate_powder");

        //Cutters
        RegistryHelper.registerItem(ccCircle, "cookie_cutter_circle");
        RegistryHelper.registerItem(ccGBMan, "cookie_cutter_gbman");
        RegistryHelper.registerItem(ccSquare, "cookie_cutter_square");
        RegistryHelper.registerItem(ccStar, "cookie_cutter_star");
        RegistryHelper.registerItem(ccTree, "cookie_cutter_tree");

        //Food
        RegistryHelper.registerItem(chocchips, "chocolate_chips");
        RegistryHelper.registerItem(cookiedough, "cookie_dough");
        RegistryHelper.registerItem(plainCircle, "plain_cookie");
        RegistryHelper.registerItem(plainSquare, "plain_cookie_square");
        RegistryHelper.registerItem(plainStar, "plain_cookie_star");

        RegistryHelper.registerItem(sugarCircle, "sugar_cookie");
        RegistryHelper.registerItem(sugarSquare, "sugar_cookie_square");
        RegistryHelper.registerItem(sugarStar, "sugar_cookie_star");

        RegistryHelper.registerItem(chocolateCircle, "chocolate_chip_cookie");
        RegistryHelper.registerItem(chocolateSquare, "chocolate_chip_cookie_square");
        RegistryHelper.registerItem(chocolateStar, "chocolate_chip_cookie_star");

        RegistryHelper.registerItem(doublechocolateCircle, "double_chocolate_chip_cookie");
        RegistryHelper.registerItem(doublechocolateSquare, "double_chocolate_chip_cookie_square");
        RegistryHelper.registerItem(doublechocolateStar, "double_chocolate_chip_cookie_star");
        
    }
}
