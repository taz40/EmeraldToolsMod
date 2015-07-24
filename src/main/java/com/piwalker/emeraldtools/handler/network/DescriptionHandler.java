package com.piwalker.emeraldtools.handler.network;

import com.piwalker.emeraldtools.EmeraldTools;
import com.piwalker.emeraldtools.references.References;
import com.piwalker.emeraldtools.tileentity.TileEntityEmeraldTools;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
@ChannelHandler.Sharable
public class DescriptionHandler extends SimpleChannelInboundHandler<FMLProxyPacket> {
    public static final String CHANNEL = References.MOD_ID + "Description";
    static{
        NetworkRegistry.INSTANCE.newChannel(CHANNEL, new DescriptionHandler());
    }

    public static void init(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FMLProxyPacket msg) throws Exception {
        ByteBuf buf = msg.payload();
        int x = buf.readInt();
        int y = buf.readInt();
        int z = buf.readInt();
        TileEntity te = EmeraldTools.proxy.getClientPlayer().worldObj.getTileEntity(x, y, z);
        if(te instanceof TileEntityEmeraldTools){
            ((TileEntityEmeraldTools) te).readFromPacket(buf);
        }
    }
}
