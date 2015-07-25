package com.piwalker.emeraldtools.init;

import com.piwalker.emeraldtools.item.ItemEmeraldAxe;
import com.piwalker.emeraldtools.item.ItemEmeraldHoe;
import com.piwalker.emeraldtools.item.ItemEmeraldPickaxe;
import com.piwalker.emeraldtools.item.ItemEmeraldShard;
import com.piwalker.emeraldtools.item.ItemEmeraldSpade;
import com.piwalker.emeraldtools.item.ItemEmeraldSword;
import com.piwalker.emeraldtools.item.ItemEmeraldTools;
import com.piwalker.emeraldtools.references.Names;
import com.piwalker.emeraldtools.references.References;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
@GameRegistry.ObjectHolder(References.MOD_ID)
public class ModItems {
    public static final ItemEmeraldTools emeraldShard = new ItemEmeraldShard();
    public static final Item emeraldPick = new ItemEmeraldPickaxe();
    public static final Item emeraldSpade = new ItemEmeraldSpade();
    public static final Item emeraldSword = new ItemEmeraldSword();
    public static final Item emeraldAxe = new ItemEmeraldAxe();
    public static final Item emeraldHoe = new ItemEmeraldHoe();

    public static void init(){
        GameRegistry.registerItem(emeraldShard, Names.Items.EMERALD_SHARD);
        GameRegistry.registerItem(emeraldPick, Names.Tools.PICKAXEEMERALD);
        GameRegistry.registerItem(emeraldSpade, Names.Tools.SPADEEMERALD);
        GameRegistry.registerItem(emeraldSword, Names.Tools.SWORDEMERALD);
        GameRegistry.registerItem(emeraldAxe, Names.Tools.AXEEMERALD);
        GameRegistry.registerItem(emeraldHoe, Names.Tools.HOEEMERALD);
    }
}
