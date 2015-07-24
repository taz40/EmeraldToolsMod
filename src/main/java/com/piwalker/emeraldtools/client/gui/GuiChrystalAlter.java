package com.piwalker.emeraldtools.client.gui;

import com.piwalker.emeraldtools.inventory.ContainerChrystalAlter;
import com.piwalker.emeraldtools.tileentity.TileEntityEmeraldCore;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
public class GuiChrystalAlter extends GuiEmeraldTools {

    public GuiChrystalAlter(InventoryPlayer playerInventory, TileEntityEmeraldCore te) {
        super(new ContainerChrystalAlter(playerInventory, te), "crystalAltar", te);
    }
}
