package com.piwalker.emeraldtools.proxy;

import com.piwalker.emeraldtools.tileentity.SpecialRenderer.CrystalAltarRenderer;
import com.piwalker.emeraldtools.tileentity.SpecialRenderer.PillerRenderer;
import com.piwalker.emeraldtools.tileentity.TileEntityCrystalAltar;
import com.piwalker.emeraldtools.tileentity.TileEntityEmeraldCore;
import com.piwalker.emeraldtools.tileentity.TileEntityPiller;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
public class ClientProxy extends CommonProxy {


    @Override
    public void preInit() {

    }

    @Override
    public void init() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrystalAltar.class, new CrystalAltarRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPiller.class, new PillerRenderer());
    }

    @Override
    public void postInit() {

    }

    @Override
    public EntityPlayer getClientPlayer() {
        return Minecraft.getMinecraft().thePlayer;
    }
}
