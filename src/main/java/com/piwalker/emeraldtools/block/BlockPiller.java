package com.piwalker.emeraldtools.block;

import com.piwalker.emeraldtools.references.Names;
import com.piwalker.emeraldtools.tileentity.TileEntityPiller;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by PiWalker on 7/26/2015.
 */
public class BlockPiller extends BlockEmeraldToolsTileEntity {

    public BlockPiller(){
        super();
        this.setBlockName(Names.Blocks.PILLER);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityPiller();
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

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        ((TileEntityPiller) world.getTileEntity(x, y, z)).placed();
    }


}
