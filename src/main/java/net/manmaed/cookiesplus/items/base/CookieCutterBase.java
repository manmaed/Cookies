package net.manmaed.cookiesplus.items.base;

/**
 * Created by manmaed on 13/01/2019.
 */
public class CookieCutterBase extends CookieItemBase {

    public CookieCutterBase(String name){
        super("cookiecutter." + name);
        setMaxStackSize(1);
    }
}
