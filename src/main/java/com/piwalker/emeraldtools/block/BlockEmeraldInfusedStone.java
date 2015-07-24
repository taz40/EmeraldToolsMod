package com.piwalker.emeraldtools.block;

import com.piwalker.emeraldtools.references.Names;
import com.piwalker.emeraldtools.tileentity.TileEntityEmeraldStone;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
public class BlockEmeraldInfusedStone extends BlockEmeraldToolsTileEntity {
    public BlockEmeraldInfusedStone() {
        super();
        setBlockName(Names.Blocks.EMERALDSTONE);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityEmeraldStone();
    }
}
