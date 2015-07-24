package com.piwalker.emeraldtools.block;

import com.piwalker.emeraldtools.references.Names;
import com.piwalker.emeraldtools.tileentity.TileEntityEmeraldCore;
import com.piwalker.emeraldtools.tileentity.TileEntityEmeraldStone;
import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Arrays;

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

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        TileEntityEmeraldCore te = (TileEntityEmeraldCore)world.getTileEntity(x, y, z);
        te.rightClick(world, x, y, z, player);
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {

        return false;
    }
}
