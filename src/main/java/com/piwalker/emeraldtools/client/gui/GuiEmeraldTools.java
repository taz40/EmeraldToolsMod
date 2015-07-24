package com.piwalker.emeraldtools.client.gui;

import com.piwalker.emeraldtools.references.References;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
public abstract class GuiEmeraldTools extends GuiContainer {
    private ResourceLocation guiTexture;
    private IInventory inventory;

    public GuiEmeraldTools(Container container, String guiTetureName, IInventory inventory) {
        super(container);
        this.guiTexture = new ResourceLocation(References.MOD_ID + ":textures/gui/"+guiTetureName + ".png");
        this.inventory = inventory;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTick, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(guiTexture);
        this.drawTexturedModalRect(guiLeft, guiTop, 0,0, xSize,ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = inventory.hasCustomInventoryName() ? inventory.getInventoryName() : I18n.format(inventory.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(s, xSize / 2  - fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }
}
