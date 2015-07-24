package com.piwalker.emeraldtools.tileentity;

import com.piwalker.emeraldtools.init.ModBlocks;
import com.piwalker.emeraldtools.utility.LogHelper;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
public class TileEntityEmeraldCore extends TileEntityEmeraldTools {
    public boolean isMultiblock = false;

    public void rightClick(World world,int x,int y,int z,EntityPlayer player){
        if(isMultiblock && !world.isRemote){
            LogHelper.info("Click");
        }
    }

    public void checkForMultiblock(){
        LogHelper.info("checking multiblock");
        int x = xCoord;
        int y = yCoord;
        int z = zCoord;
        if(testBlock(x+1, y, z) && testBlock(x+1, y, z+1) && testBlock(x, y, z+1) && testBlock(x-1, y, z+1) && testBlock(x-1, y, z)
                && testBlock(x, y, z-1) && testBlock(x-1, y, z-1) && testBlock(x+2, y, z) && testBlock(x+2, y+1, z)
                && testBlock(x+3, y+1, z) && testBlock(x+3, y+2, z) && testBlock(x+3, y+3, z) && testBlock(x+2, y+3, z)
                && testBlock(x-2, y, z) && testBlock(x-2, y+1, z) && testBlock(x-3, y+1, z) && testBlock(x-3, y+2, z)
                && testBlock(x-3, y+3, z) && testBlock(x-2, y+3, z) /**/&& testBlock(x, y, z+2) && testBlock(x, y+1, z+2)
                && testBlock(x, y+1, z+3) && testBlock(x, y+2, z+3) && testBlock(x, y+3, z+3) && testBlock(x, y+3, z+2)
                && testBlock(x, y, z-2) && testBlock(x, y+1, z-2) && testBlock(x, y+1, z-3) && testBlock(x, y+2, z-3)
                && testBlock(x, y+3, z-3) && testBlock(x, y+3, z-2)){
            isMultiblock = true;
        }else{
            isMultiblock = false;
        }
        worldObj.markBlockForUpdate(x, y, z);
    }

    private boolean testBlock(int x, int y, int z){
        return testBlock(x, y, z, ModBlocks.emeraldStone);
    }

    private boolean testBlock(int x, int y, int z, Block block){
        if(worldObj.getBlock(x, y, z) == block){
            return true;
        }
        return false;
    }

    @Override
    public void writeToPacket(ByteBuf buf) {
        buf.writeBoolean(isMultiblock);
    }

    @Override
    public void readFromPacket(ByteBuf buf) {
        isMultiblock = buf.readBoolean();
    }
}
