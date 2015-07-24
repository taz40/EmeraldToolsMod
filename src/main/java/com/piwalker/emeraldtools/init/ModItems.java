package com.piwalker.emeraldtools.init;

import com.piwalker.emeraldtools.item.ItemEmeraldShard;
import com.piwalker.emeraldtools.item.ItemEmeraldTools;
import com.piwalker.emeraldtools.references.Names;
import com.piwalker.emeraldtools.references.References;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
@GameRegistry.ObjectHolder(References.MOD_ID)
public class ModItems {
    public static final ItemEmeraldTools emeraldShard = new ItemEmeraldShard();

    public static void init(){
        GameRegistry.registerItem(emeraldShard, Names.Items.EMERALD_SHARD);
    }
}
