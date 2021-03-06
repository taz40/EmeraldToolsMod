package com.piwalker.emeraldtools.network;

import com.piwalker.emeraldtools.references.References;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class NetworkHandler {
	
	private static SimpleNetworkWrapper INSTANCE;
	
	public static void init(){
		INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(References.MOD_ID);
		
		INSTANCE.registerMessage(MessageHandleGui.class, MessageHandleGui.class, 0, Side.SERVER);
	}
	
	public static void sendToServer(IMessage message){
		INSTANCE.sendToServer(message);
	}

}
