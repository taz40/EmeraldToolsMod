package com.piwalker.emeraldtools.network;

import com.piwalker.emeraldtools.tileentity.TileEntityEmeraldCore;
import com.piwalker.emeraldtools.tileentity.TileEntityEmeraldTools;
import com.piwalker.emeraldtools.utility.LogHelper;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

public class MessageHandleGui extends MessageBase<MessageHandleGui> {
	private int x, y, z;
	
	public MessageHandleGui(){}
	
	public MessageHandleGui(TileEntityEmeraldTools te){
		this.x = te.xCoord;
		this.y = te.yCoord;
		this.z = te.zCoord;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
	}

	@Override
	public void handleClientSide(MessageHandleGui message, EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleServerSide(MessageHandleGui message, EntityPlayer player) {
		// TODO Auto-generated method stub
		LogHelper.info("Message Received!");
		TileEntity te = player.worldObj.getTileEntity(message.x, message.y, message.z);
		if(te instanceof TileEntityEmeraldCore){
			((TileEntityEmeraldCore) te).startCraft();
		}
	}

	

}
