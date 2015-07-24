package com.piwalker.emeraldtools.tileentity;

import com.piwalker.emeraldtools.utility.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
public class TileEntityEmeraldStone extends TileEntityEmeraldTools {
    public TileEntityEmeraldCore master;
    private boolean firstrun = true;

    public void rightClick(World world,int x,int y,int z,EntityPlayer player){
        if(master != null){
            master.rightClick(world, x, y, z, player);
        }
    }

    public void update(){
        master.checkForMultiblock();
    }

    public TileEntityEmeraldCore getMaster(){
        initializeMultiblockIfNecessary();
        return master;
    }

    private void setMaster(TileEntityEmeraldCore master){
        this.master = master;
    }

    @Override
    public void updateEntity(){
        super.updateEntity();
        if(firstrun){
            LogHelper.info("Running first run update.");
            initializeMultiblockIfNecessary();
            LogHelper.info("Finished first run update.");
            firstrun = false;
        }
    }

    @Override
    public void invalidate(){
        super.invalidate();
        for(ForgeDirection d : ForgeDirection.VALID_DIRECTIONS){
            TileEntity te = worldObj.getTileEntity(xCoord + d.offsetX, yCoord +d.offsetY, zCoord + d.offsetZ);
            if(te instanceof  TileEntityEmeraldStone){
                ((TileEntityEmeraldStone) te).master = null;
                ((TileEntityEmeraldStone) te).initializeMultiblockIfNecessary();
            }
        }
    }

    private void initializeMultiblockIfNecessary(){
        if(master == null || master.isInvalid()){
            List<TileEntityEmeraldTools> connectedBlocks = new ArrayList<TileEntityEmeraldTools>();
            Stack<TileEntityEmeraldTools> traversingStorages = new Stack<TileEntityEmeraldTools>();
            traversingStorages.add(this);
            while(!traversingStorages.isEmpty()){
                TileEntityEmeraldTools te = traversingStorages.pop();
                if(te instanceof  TileEntityEmeraldCore){
                    master = (TileEntityEmeraldCore)te;
                }
                connectedBlocks.add(te);
                for(ForgeDirection d : ForgeDirection.VALID_DIRECTIONS){
                    TileEntity te2 = worldObj.getTileEntity(te.xCoord + d.offsetX, te.yCoord + d.offsetY, te.zCoord + d.offsetZ);
                    if((te2 instanceof  TileEntityEmeraldStone || te2 instanceof TileEntityEmeraldCore) && !connectedBlocks.contains(te2)){
                        traversingStorages.add((TileEntityEmeraldTools)te2);
                    }
                }
            }
            LogHelper.info("Setting master to " + master.xCoord + ", " + master.yCoord + ", " + master.zCoord);
            for(TileEntityEmeraldTools block : connectedBlocks){
                if(block instanceof TileEntityEmeraldStone){
                    ((TileEntityEmeraldStone)block).setMaster(master);
                }
            }
        }
    }


}
