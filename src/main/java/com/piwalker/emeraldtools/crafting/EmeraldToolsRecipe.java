package com.piwalker.emeraldtools.crafting;

import net.minecraft.item.ItemStack;

public class EmeraldToolsRecipe {
	public int emeralds;
	public ItemStack other;
	public ItemStack out;
	public int time;
	
	public EmeraldToolsRecipe(ItemStack out, int emeralds, ItemStack other, int timeInSecconds){
		this.out = out;
		this.emeralds = emeralds;
		this.other = other;
		this.time = timeInSecconds;
	}
}
