package net.manmaed.cookies;

import net.manmaed.cookies.blocks.CookieBlocks;
import net.manmaed.cookies.items.CookieItems;
import net.manmaed.cookies.libs.LogHelper;
import net.manmaed.cookies.libs.Reference;
import net.manmaed.cookies.proxy.CommonProxy;
import net.manmaed.cookies.proxy.GUIProxy;
import net.manmaed.cookies.tab.CookiesCreativeTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Created by manmaed on 13/01/2019.
 */


@Mod(
        modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.VERSION,
        acceptedMinecraftVersions = Reference.MC_VERSION,
        certificateFingerprint = "null"
)
public class Cookies {

    @Mod.Instance(Reference.MOD_ID)
    public static Cookies instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.PROXY_COMMON)
    public static CommonProxy proxy;
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
        /*WorldGen WorldGen = new WorldGen();
        GameRegistry.registerWorldGenerator(WorldGen, 1);*/
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
            //iChun.setdev();
        }
        if(!event.isDirectory()) {
            invalsign = true;
        }

    }

}
