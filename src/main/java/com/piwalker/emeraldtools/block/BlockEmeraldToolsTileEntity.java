package com.piwalker.emeraldtools.block;

import com.piwalker.emeraldtools.creativetabs.CreativeTab;
import com.piwalker.emeraldtools.references.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
public abstract class BlockEmeraldToolsTileEntity extends BlockContainer {

    public BlockEmeraldToolsTileEntity(Material material) {
        super(material);
        setCreativeTab(CreativeTab.EMERALDTOOLS_TAB);
    }

    public BlockEmeraldToolsTileEntity(){
        this(Material.rock);
    }

    @Override
    public String getUnlocalizedName(){
        return String.format("tile.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        blockIcon = iconRegister.registerIcon(String.format("%s",getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
