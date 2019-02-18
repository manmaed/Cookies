package net.manmaed.cookiesplus;

import net.manmaed.cookiesplus.blocks.CookieBlocks;
import net.manmaed.cookiesplus.client.WorldGen;
import net.manmaed.cookiesplus.items.CookieItems;
import net.manmaed.cookiesplus.libs.LogHelper;
import net.manmaed.cookiesplus.libs.Reference;
import net.manmaed.cookiesplus.proxy.GUIProxy;
import net.manmaed.cookiesplus.tab.CookiesCreativeTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by manmaed on 13/01/2019.
 */


@Mod(
        modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.VERSION,
        acceptedMinecraftVersions = Reference.MC_VERSION,
        certificateFingerprint = "@FINGERPRINT@"
)
public class Cookies {

    @Mod.Instance(Reference.MOD_ID)
    public static Cookies instance;

    /*@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.PROXY_COMMON)
    public static CommonProxy proxy;*/
    public static CreativeTabs tabsCookies = new CookiesCreativeTab(CreativeTabs.getNextID());
    private static final String FINGERPRINT = "@FINGERPRINT@";
    private static boolean devenvsign = false;
    private static boolean invalsign = false;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        CookieItems.load();
        CookieBlocks.load();
        //proxy.renderinfo();
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event)
    {
        /*proxy.renderinfo();*/
        GameRegistry.registerWorldGenerator(WorldGen.INSTANCE, 5);
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GUIProxy());

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        if (devenvsign) {
            LogHelper.info(Reference.NO_FINGERPRINT_MESSAGE);
        }
        if (invalsign) {
            LogHelper.warn(Reference.INVALID_FINGERPRINT_MESSAGE);
        }
    }

    //FInger Print Stuff
    @Mod.EventHandler
    public void onInvalidFingerprint(FMLFingerprintViolationEvent event)
    {
        if(event.isDirectory()){
            devenvsign = true;
        }
        if(!event.isDirectory()) {
            invalsign = true;
        }

    }

}
