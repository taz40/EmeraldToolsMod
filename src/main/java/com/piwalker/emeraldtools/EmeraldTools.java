package com.piwalker.emeraldtools;

import com.piwalker.emeraldtools.client.handler.GuiHandler;
import com.piwalker.emeraldtools.handler.PlayerHandler;
import com.piwalker.emeraldtools.handler.network.DescriptionHandler;
import com.piwalker.emeraldtools.init.ModBlocks;
import com.piwalker.emeraldtools.init.ModItems;
import com.piwalker.emeraldtools.init.ModTileEntities;
import com.piwalker.emeraldtools.init.Recipes;
import com.piwalker.emeraldtools.network.NetworkHandler;
import com.piwalker.emeraldtools.proxy.IProxy;
import com.piwalker.emeraldtools.references.References;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.MOD_VERSION)
public class EmeraldTools {

    @Mod.Instance(References.MOD_ID)
    public static EmeraldTools instance;

    @SidedProxy(serverSide = References.SERVER_PROXY_CLASS, clientSide = References.CLIENT_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        proxy.preInit();
        ModItems.init();
        ModBlocks.init();
        ModTileEntities.init();
        DescriptionHandler.init();
        NetworkHandler.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
        MinecraftForge.EVENT_BUS.register(new PlayerHandler());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init();
        Recipes.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit();

    }

}
