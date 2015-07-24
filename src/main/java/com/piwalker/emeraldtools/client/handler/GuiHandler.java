package com.piwalker.emeraldtools.client.handler;

import com.piwalker.emeraldtools.client.gui.GuiChrystalAlter;
import com.piwalker.emeraldtools.inventory.ContainerChrystalAlter;
import com.piwalker.emeraldtools.tileentity.TileEntityEmeraldCore;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
public class GuiHandler implements IGuiHandler {

    public enum GuiIDs{
        CHRYSTAL_ALTER;
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (GuiIDs.values()[ID]){
            case CHRYSTAL_ALTER:
                return new ContainerChrystalAlter(player.inventory, (TileEntityEmeraldCore)world.getTileEntity(x, y, z));
            default:
                throw new IllegalArgumentException("No GUI with id " + ID);
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (GuiIDs.values()[ID]){
            case CHRYSTAL_ALTER:
                return new GuiChrystalAlter(player.inventory, (TileEntityEmeraldCore)world.getTileEntity(x, y, z));
            default:
                throw new IllegalArgumentException("No GUI with id " + ID);
        }
    }
}
