package com.piwalker.emeraldtools.tileentity;

import com.piwalker.emeraldtools.utility.LogHelper;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by PiWalker on 7/26/2015.
 */
public class TileEntityPiller extends TileEntityEmeraldTools {

    public int rotation = 0;

    public void placed(){
        TileEntity te = worldObj.getTileEntity(xCoord - 2, yCoord, zCoord-2);
        if(te != null && te instanceof TileEntityCrystalAltar){
            rotation = 0;
        }

        te = worldObj.getTileEntity(xCoord - 2, yCoord, zCoord+2);
        if(te != null && te instanceof TileEntityCrystalAltar){
            rotation = 90;
        }

        te = worldObj.getTileEntity(xCoord + 2, yCoord, zCoord+2);
        if(te != null && te instanceof TileEntityCrystalAltar){
            rotation = 180;
        }

        te = worldObj.getTileEntity(xCoord + 2, yCoord, zCoord-2);
        if(te != null && te instanceof TileEntityCrystalAltar){
            rotation = 270;
        }

        LogHelper.info(rotation);

    }

    @Override
    public void writeToPacket(ByteBuf buf) {
        buf.writeInt(rotation);
    }

    @Override
    public void readFromPacket(ByteBuf buf) {
        rotation = buf.readInt();
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        rotation = tag.getInteger("rotation");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setInteger("rotation", rotation);
    }
}
