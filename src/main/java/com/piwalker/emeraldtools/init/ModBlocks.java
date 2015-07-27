package com.piwalker.emeraldtools.init;

import com.piwalker.emeraldtools.block.*;
import com.piwalker.emeraldtools.references.Names;
import com.piwalker.emeraldtools.references.References;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
@GameRegistry.ObjectHolder(References.MOD_ID)
public class ModBlocks {
    public static final BlockEmeraldToolsTileEntity emeraldStone = new BlockEmeraldInfusedStone();
    public static final BlockEmeraldToolsTileEntity emeraldCore = new BlockEmeraldCore();
    public static final BlockEmeraldToolsTileEntity crystalAltar = new BlockCrystalAltar();
    public static final BlockEmeraldToolsTileEntity piller = new BlockPiller();

    public static void init(){
        GameRegistry.registerBlock(emeraldStone, Names.Blocks.EMERALDSTONE);
        GameRegistry.registerBlock(emeraldCore, Names.Blocks.EMERALDCORE);
        GameRegistry.registerBlock(crystalAltar, Names.Blocks.CRYSTALALTAR);
        GameRegistry.registerBlock(piller, Names.Blocks.PILLER);
    }
}
