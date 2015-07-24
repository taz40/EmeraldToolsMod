package com.piwalker.emeraldtools.tileentity;

import com.piwalker.emeraldtools.handler.network.DescriptionHandler;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
public abstract class TileEntityEmeraldTools extends TileEntity {
    public Packet getDescriptionPacket(){
        ByteBuf buf = Unpooled.buffer();
        buf.writeInt(xCoord);
        buf.writeInt(yCoord);
        buf.writeInt(zCoord);
        writeToPacket(buf);
        return new FMLProxyPacket(buf, DescriptionHandler.CHANNEL);
    }

    public void writeToPacket(ByteBuf buf){

    }

    public void readFromPacket(ByteBuf buf){

    }
}
