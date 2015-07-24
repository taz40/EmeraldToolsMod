package com.piwalker.emeraldtools.tileentity.SpecialRenderer;

import com.piwalker.emeraldtools.init.ModBlocks;
import com.piwalker.emeraldtools.models.ModelCrystalAltar;
import com.piwalker.emeraldtools.references.References;
import com.piwalker.emeraldtools.tileentity.TileEntityEmeraldCore;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

/**
 * Created by SamuelPiWalker on 7/24/2015.
 */
public class CrystalAltarRenderer extends TileEntitySpecialRenderer {

    private IModelCustom crystalAltar;
    private ResourceLocation crystalAltarTexture;
    private ResourceLocation crystalCoreTexture;

    public CrystalAltarRenderer(){
        crystalAltar = AdvancedModelLoader.loadModel(new ResourceLocation(References.MOD_ID + ":models/ModelCrystalAltar.obj"));
        crystalAltarTexture = new ResourceLocation(References.MOD_ID + ":textures/blocks/emeraldStone.png");
        crystalCoreTexture = new ResourceLocation(References.MOD_ID + ":textures/blocks/emeraldCore.png");
    }

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
        TileEntityEmeraldCore master = (TileEntityEmeraldCore)te;
        if(((TileEntityEmeraldCore) te).isMultiblock) {
            GL11.glPushMatrix();
            GL11.glTranslated(x - .5f, y - .5f, z - .5f);
            GL11.glPushMatrix();
            GL11.glScaled(.5f, .5f, .5f);

            bindTexture(crystalAltarTexture);
            crystalAltar.renderAll();

            GL11.glPopMatrix();
            GL11.glPopMatrix();
        }
    }
}
