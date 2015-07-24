package com.piwalker.emeraldtools.proxy;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
public interface IProxy {

    public abstract void preInit();
    public abstract void init();
    public abstract void postInit();

    public abstract EntityPlayer getClientPlayer();

}
