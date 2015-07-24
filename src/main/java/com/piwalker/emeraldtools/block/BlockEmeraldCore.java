package com.piwalker.emeraldtools.block;

import com.piwalker.emeraldtools.references.Names;
import com.piwalker.emeraldtools.tileentity.TileEntityEmeraldCore;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
public class BlockEmeraldCore extends BlockEmeraldToolsTileEntity {
    public BlockEmeraldCore() {
        super(Material.iron);
        setBlockName(Names.Blocks.EMERALDCORE);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int I1) {
        return new TileEntityEmeraldCore();
    }
}
