package net.manmaed.cookies.libs.events;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.manmaed.cookies.Cookies;

/**
 * Created by manmaed on 11/07/2017.
 */
public class EntityRegisterUtil {


    public static void registerEntity(ResourceLocation texture, Class<? extends Entity> entityClass, String entityName, int id, int eggPrimary, int eggSecondary)
    {
        EntityRegistry.registerModEntity(texture, entityClass, entityName, id, Cookies.instance, 64, 3, true, eggPrimary, eggSecondary);
    }
}
