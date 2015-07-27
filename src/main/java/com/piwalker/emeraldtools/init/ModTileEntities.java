package com.piwalker.emeraldtools.init;

import com.piwalker.emeraldtools.references.Names;
import com.piwalker.emeraldtools.tileentity.TileEntityCrystalAltar;
import com.piwalker.emeraldtools.tileentity.TileEntityEmeraldCore;
import com.piwalker.emeraldtools.tileentity.TileEntityEmeraldStone;
import com.piwalker.emeraldtools.tileentity.TileEntityPiller;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
public class ModTileEntities {
    public static void init(){
        GameRegistry.registerTileEntity(TileEntityEmeraldCore.class, Names.TileEntities.EMERALDCORE);
        GameRegistry.registerTileEntity(TileEntityEmeraldStone.class, Names.TileEntities.EMERALDSTONE);
        GameRegistry.registerTileEntity(TileEntityCrystalAltar.class, Names.TileEntities.CRYSTALALTAR);
        GameRegistry.registerTileEntity(TileEntityPiller.class, Names.TileEntities.PILLAR);
    }
}
