package com.piwalker.emeraldtools.tileentity.SpecialRenderer;

import com.piwalker.emeraldtools.references.References;
import com.piwalker.emeraldtools.tileentity.TileEntityPiller;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

/**
 * Created by PiWalker on 7/26/2015.
 */
public class PillerRenderer extends TileEntitySpecialRenderer {

    IModelCustom pillerModel;
    ResourceLocation texture;

    public PillerRenderer(){
        pillerModel = AdvancedModelLoader.loadModel(new ResourceLocation(References.MOD_ID + ":models/Pillar.obj"));
        texture = new ResourceLocation(References.MOD_ID + ":textures/models/stone.png");
    }

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
        int rotation = ((TileEntityPiller) te).rotation;
        GL11.glPushMatrix();
        if(rotation == 90) {
            GL11.glTranslated(x+.25, y + .35, z + .75);
        }else if(rotation == 180) {
            GL11.glTranslated(x+1, y + .35, z + .75);
        }else if(rotation == 270){
            GL11.glTranslated(x+.75, y + .35, z + .25);
        }else{
            GL11.glTranslated(x, y + .35, z + .25);
        }
        GL11.glPushMatrix();
        GL11.glScaled(.75, .75, .75);
        GL11.glPushMatrix();
        GL11.glRotated(rotation, 0, 1, 0);

        bindTexture(texture);
        pillerModel.renderAll();

        GL11.glPopMatrix();
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
