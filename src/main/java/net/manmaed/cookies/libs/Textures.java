package net.manmaed.cookies.libs;

import net.minecraft.util.ResourceLocation;

/**
 * Created by manmaed on 13/01/2019.
 */
public class Textures {

    public static final String MODEL_SHEET_LOCATION_GUI = "textures/gui/";
    public static final String MODEL_SHEET_LOCATION_MODEL = "textures/model/";
    public static final ResourceLocation GUI_GIFTBOX = ResourceLocationHelper.getResourceLocation(MODEL_SHEET_LOCATION_GUI + "giftbox.png");
    public static final ResourceLocation GIFT_BOX = ResourceLocationHelper.getResourceLocation(MODEL_SHEET_LOCATION_MODEL + "giftbox.png");

    private static class ResourceLocationHelper {
        public static ResourceLocation getResourceLocation(String modId, String path) {
            return new ResourceLocation(modId, path);
        }
        public static ResourceLocation getResourceLocation(String path) {
            return getResourceLocation(Reference.MOD_ID.toLowerCase(), path);
        }
    }

}
