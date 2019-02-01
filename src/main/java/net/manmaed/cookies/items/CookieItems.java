package net.manmaed.cookies.items;

import net.manmaed.cookies.Cookies;
import net.manmaed.cookies.items.base.CookieCutterBase;
import net.manmaed.cookies.items.base.CookieFoodBase;
import net.manmaed.cookies.items.base.CookieItemBase;
import net.manmaed.cookies.items.cutters.*;
import net.manmaed.cookies.items.food.*;
import net.manmaed.cookies.items.ingredients.ChocPowder;
import net.manmaed.cookies.items.ingredients.Ginger;
import net.manmaed.cookies.items.ingredients.GingerPowder;
import net.manmaed.cookies.items.ingredients.SugerPowder;

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
    public static CookieItemBase chocPowder;

    //Cookie Cutters
    public static CookieCutterBase ccCircle;
    public static CookieCutterBase ccGBMan;
    public static CookieCutterBase ccSquare;
    public static CookieCutterBase ccStar;
    public static CookieCutterBase ccTree;

    //Foods
    public static CookieFoodBase chocChips;
    public static CookieFoodBase cookiedough;
    public static CookieFoodBase plainCircle;
    public static CookieFoodBase plainSquare;
    public static CookieFoodBase plainStar;

    public static CookieFoodBase sugarCircle;
    public static CookieFoodBase sugarSquare;
    public static CookieFoodBase sugarStar;

    public static CookieFoodBase chocCircle;
    public static CookieFoodBase chocSquare;
    public static CookieFoodBase chocStar;

    public static CookieFoodBase doublechocCircle;
    public static CookieFoodBase doublechocSquare;
    public static CookieFoodBase doublechocStar;

    public static void load() {
        //Init'ing
        //itemname = new ItemClass();
        giftboxPlain = new GiftBoxPlain();
        yellowRibbon = new YellowRibbon();

        //Ingredients
        sugarPowder = new SugerPowder();
        gingerPowder = new GingerPowder();
        ginger = new Ginger();
        chocPowder = new ChocPowder();

        //Cookie Cutters
        ccCircle = new CookieCutterCircle();
        ccGBMan = new CookieCutterGBMan();
        ccSquare = new CookieCutterSquare();
        ccStar = new CookieCutterStar();
        ccTree = new CookieCutterTree();

        //Foods
        chocChips = new ChocChips(1, 0.2F);
        cookiedough = new CookieDough(1,0.2F);
        plainCircle = new PlainCookie(2, 0.4F);
        plainSquare = new PlainSquareCookie(2, 0.4F);
        plainStar = new PlainStarCookie(2, 0.4F);

        sugarCircle = new SugarCookie(2, 0.4F);
        sugarSquare = new SugarSquareCookie(2, 0.4F);
        sugarStar = new SugarStarCookie(2, 0.4F);

        chocCircle = new ChocCookie(2, 0.4F);
        chocSquare = new ChocSquareCookie(2, 0.4F);
        chocStar = new ChocStarCookie(2, 0.4F);

        doublechocCircle = new DoubleChocCookie(2, 0.4F);
        doublechocSquare = new DoubleChocSquareCookie(2, 0.4F);
        doublechocStar = new DoubleChocStarCookie(2, 0.4F);




        //Registering
        /*MainClass.getRegistryHelper().registerItem(itemname);
        itemname.setRegistryName("itemname");*/
        Cookies.getRegistryHelper().registerItem(giftboxPlain);
        Cookies.getRegistryHelper().registerItem(yellowRibbon);

        //Ingredients
        Cookies.getRegistryHelper().registerItem(sugarPowder);
        Cookies.getRegistryHelper().registerItem(gingerPowder);
        Cookies.getRegistryHelper().registerItem(ginger);
        Cookies.getRegistryHelper().registerItem(chocPowder);

        //Cutters
        Cookies.getRegistryHelper().registerItem(ccCircle);
        Cookies.getRegistryHelper().registerItem(ccGBMan);
        Cookies.getRegistryHelper().registerItem(ccSquare);
        Cookies.getRegistryHelper().registerItem(ccStar);
        Cookies.getRegistryHelper().registerItem(ccTree);

        //Food
        Cookies.getRegistryHelper().registerItem(chocChips);
        Cookies.getRegistryHelper().registerItem(cookiedough);
        Cookies.getRegistryHelper().registerItem(plainCircle);
        Cookies.getRegistryHelper().registerItem(plainSquare);
        Cookies.getRegistryHelper().registerItem(plainStar);

        Cookies.getRegistryHelper().registerItem(sugarCircle);
        Cookies.getRegistryHelper().registerItem(sugarSquare);
        Cookies.getRegistryHelper().registerItem(sugarStar);

        Cookies.getRegistryHelper().registerItem(chocCircle);
        Cookies.getRegistryHelper().registerItem(chocSquare);
        Cookies.getRegistryHelper().registerItem(chocStar);

        Cookies.getRegistryHelper().registerItem(doublechocCircle);
        Cookies.getRegistryHelper().registerItem(doublechocSquare);
        Cookies.getRegistryHelper().registerItem(doublechocStar);

        //
        giftboxPlain.setRegistryName("giftbox");
        yellowRibbon.setRegistryName("ribbon_yellow");

        //Ingredients
        sugarPowder.setRegistryName("sugarpowder");
        gingerPowder.setRegistryName("gingerpowder");
        ginger.setRegistryName("ginger");
        chocPowder.setRegistryName("chocolate_powder");

        //Cutters
        ccCircle.setRegistryName("cookie_cutter_circle");
        ccGBMan.setRegistryName("cookie_cutter_gbman");
        ccSquare.setRegistryName("cookie_cutter_square");
        ccStar.setRegistryName("cookie_cutter_star");
        ccTree.setRegistryName("cookie_cutter_tree");

        chocChips.setRegistryName("choc_chips");
        cookiedough.setRegistryName("cookie_dough");
        plainCircle.setRegistryName("plain_cookie");
        plainSquare.setRegistryName("plain_cookie_square");
        plainStar.setRegistryName("plain_cookie_star");

        sugarCircle.setRegistryName("sugar_cookie");
        sugarSquare.setRegistryName("sugar_cookie_square");
        sugarStar.setRegistryName("sugar_cookie_star");

        chocCircle.setRegistryName("choc_chip_cookie");
        chocSquare.setRegistryName("choc_chip_cookie_square");
        chocStar.setRegistryName("choc_chip_cookie_star");

        doublechocCircle.setRegistryName("double_choc_chip_cookie");;
        doublechocSquare.setRegistryName("double_choc_chip_cookie_square");
        doublechocStar.setRegistryName("double_choc_chip_cookie_star");
    }
}
