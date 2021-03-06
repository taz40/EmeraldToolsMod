package com.piwalker.emeraldtools.item;

import com.piwalker.emeraldtools.creativetabs.CreativeTab;
import com.piwalker.emeraldtools.references.Names;
import com.piwalker.emeraldtools.references.Textures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemEmeraldAxe extends ItemAxe {

	public ItemEmeraldAxe() {
		super(ToolMaterialEmerald.EMERALD);
		this.setCreativeTab(CreativeTab.EMERALDTOOLS_TAB);
		this.setUnlocalizedName(Names.Tools.AXEEMERALD);
	}
	
	@Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister){
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName){
        return unlocalizedName.substring(unlocalizedName.indexOf(".")+1);
    }

}
