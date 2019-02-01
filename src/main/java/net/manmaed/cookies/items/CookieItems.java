package net.manmaed.cookies.items;

import net.manmaed.cookies.Cookies;
import net.manmaed.cookies.items.base.CookieCutterBase;
import net.manmaed.cookies.items.base.CookieFoodBase;
import net.manmaed.cookies.items.base.CookieItemBase;
import net.manmaed.cookies.libs.RegistryHelper;

/**
 * Created by manmaed on 13/01/2019.
 */
public class CookieItems {

    //public static Item itemname;
    //Other Junk
    public static CookieItemBase yellowRibbon;
    public static CookieItemBase giftboxPlain;

    //Ingredients
    public static CookieItemBase sugarPowder;
    public static CookieItemBase gingerPowder;
    public static CookieItemBase ginger;
    public static CookieItemBase chocolatePowder;

    //Cookie Cutters
    public static CookieCutterBase ccCircle;
    public static CookieCutterBase ccGBMan;
    public static CookieCutterBase ccSquare;
    public static CookieCutterBase ccStar;
    public static CookieCutterBase ccTree;

    //Foods
    public static CookieFoodBase chocolateChips;
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
        giftboxPlain = new GiftBoxPlain();
        yellowRibbon = new YellowRibbon();

        //Ingredients
        sugarPowder = new CookieItemBase("sugarPowder");
        gingerPowder = new CookieItemBase("gingerPower");
        ginger = new CookieItemBase("ginger");
        chocolatePowder = new CookieItemBase("chocolatePowder");

        //Cookie Cutters
        ccCircle = new CookieCutterBase("circle");
        ccGBMan = new CookieCutterBase("gbMan");
        ccSquare = new CookieCutterBase("square");
        ccStar = new CookieCutterBase("star");
        ccTree = new CookieCutterBase("tree");

        //Foods
        chocolateChips = new CookieFoodBase("chocolateChips", 1, 0.2F);
        cookiedough = new CookieFoodBase("cookieDough", 1,0.2F);
        plainCircle = new CookieFoodBase("plainCircle", 2, 0.4F);
        plainSquare = new CookieFoodBase("plainSquare", 2, 0.4F);
        plainStar = new CookieFoodBase("plainStar", 2, 0.4F);

        sugarCircle = new CookieFoodBase("sugarCircle", 2, 0.4F);
        sugarSquare = new CookieFoodBase("sugarSquare", 2, 0.4F);
        sugarStar = new CookieFoodBase("sugarStar", 2, 0.4F);

        chocolateCircle = new CookieFoodBase("chocolateCircle", 2, 0.4F);
        chocolateSquare = new CookieFoodBase("chocolateSquare", 2, 0.4F);
        chocolateStar = new CookieFoodBase("chocolateStar", 2, 0.4F);

        doublechocolateCircle = new CookieFoodBase("doublechocolateCircle", 2, 0.4F);
        doublechocolateSquare = new CookieFoodBase("doublechocolateSquare", 2, 0.4F);
        doublechocolateStar = new CookieFoodBase("doublechocolateCircleStar", 2, 0.4F);


        RegistryHelper.registerItem(yellowRibbon, "ribbon_yellow");

        //Ingredients
        RegistryHelper.registerItem(sugarPowder, "sugarpowder");
        RegistryHelper.registerItem(gingerPowder, "gingerpowder");
        RegistryHelper.registerItem(ginger, "ginger");
        RegistryHelper.registerItem(chocolatePowder, "chocolate_powder");

        //Cutters
        RegistryHelper.registerItem(ccCircle, "cookie_cutter_circle");
        RegistryHelper.registerItem(ccGBMan, "cookie_cutter_gbman");
        RegistryHelper.registerItem(ccSquare, "cookie_cutter_square");
        RegistryHelper.registerItem(ccStar, "cookie_cutter_star");
        RegistryHelper.registerItem(ccTree, "cookie_cutter_tree");

        //Food
        RegistryHelper.registerItem(chocolateChips, "chocolate_chips");
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
