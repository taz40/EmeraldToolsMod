package com.piwalker.emeraldtools.client.gui;

import com.piwalker.emeraldtools.inventory.ContainerChrystalAlter;
import com.piwalker.emeraldtools.network.MessageHandleGui;
import com.piwalker.emeraldtools.network.NetworkHandler;
import com.piwalker.emeraldtools.tileentity.TileEntityEmeraldCore;
import com.piwalker.emeraldtools.utility.LogHelper;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
public class GuiChrystalAlter extends GuiEmeraldTools {
	TileEntityEmeraldCore te;

    public GuiChrystalAlter(InventoryPlayer playerInventory, TileEntityEmeraldCore te) {
        super(new ContainerChrystalAlter(playerInventory, te), "crystalAltar", te);
        this.te = te;
    }
    
    public void initGui(){
    	super.initGui();
    	GuiButton button = new GuiButton(0, guiLeft+80, guiTop+55, 80, 20, I18n.format("gui.emeraldtools.crystalaltar.button.craft"));
    	buttonList.add(button);
    }
    
    protected void actionPerformed(GuiButton button){
    	LogHelper.info("Action!");
    	if(button.id == 0){
    		NetworkHandler.sendToServer(new MessageHandleGui(te));
    	}
    }

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		if(!(te.timeUntilCrafted == -1)){
			this.fontRendererObj.drawString(I18n.format("gui.emraldtools.crystalalter.time", te.timeUntilCrafted/20), 13, 17, 4210752);
		}
	}
    
    
}
