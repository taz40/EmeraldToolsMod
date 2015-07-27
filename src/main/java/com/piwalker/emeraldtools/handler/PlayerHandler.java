package com.piwalker.emeraldtools.handler;

import com.piwalker.emeraldtools.item.ItemExcavator;
import com.piwalker.emeraldtools.item.ItemHammer;
import com.piwalker.emeraldtools.utility.LogHelper;
import com.piwalker.emeraldtools.utility.NBTHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

/**
 * Created by PiWalker on 7/26/2015.
 */
public class PlayerHandler {

    @SubscribeEvent
    public void onPlayerInteractEvent(PlayerInteractEvent event){
        if(event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK && event.entityPlayer.getCurrentEquippedItem() != null && (event.entityPlayer.getCurrentEquippedItem().getItem() instanceof ItemHammer || event.entityPlayer.getCurrentEquippedItem().getItem() instanceof ItemExcavator)){
            int face = event.face;
            NBTHelper.setInteger(event.entityPlayer.getCurrentEquippedItem(), "Face", face);
        }
    }
}
