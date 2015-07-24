package com.piwalker.emeraldtools.entity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by SamuelPiWalker on 7/24/2015.
 */
public class EntityItemVisual extends EntityItem {
    public EntityItemVisual(World world, double x, double y, double z, ItemStack stack) {
        super(world, x, y, z, stack);
        this.rotationPitch = 0;
        this.rotationYaw = 0;
        this.motionX =0;
        this.motionY = 0;
        this.motionZ = 0;
    }

    @Override
    public void onUpdate() {
        this.delayBeforeCanPickup++;
        this.motionY += 0.03999999910593033D;
        this.age--;

        super.onUpdate();
    }
}
