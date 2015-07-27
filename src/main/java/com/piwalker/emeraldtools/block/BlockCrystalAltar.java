package com.piwalker.emeraldtools.block;

import com.piwalker.emeraldtools.references.Names;
import com.piwalker.emeraldtools.tileentity.TileEntityCrystalAltar;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by PiWalker on 7/26/2015.
 */
public class BlockCrystalAltar extends BlockEmeraldToolsTileEntity {

    public BlockCrystalAltar(){
        super();
        this.setBlockName(Names.Blocks.CRYSTALALTAR);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityCrystalAltar();
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }



    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}
