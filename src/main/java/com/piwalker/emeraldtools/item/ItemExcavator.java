package com.piwalker.emeraldtools.item;

import com.google.common.collect.Sets;
import com.piwalker.emeraldtools.creativetabs.CreativeTab;
import com.piwalker.emeraldtools.references.Textures;
import com.piwalker.emeraldtools.utility.LogHelper;
import com.piwalker.emeraldtools.utility.NBTHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import java.util.Random;
import java.util.Set;

/**
 * Created by PiWalker on 7/26/2015.
 */
public class ItemExcavator extends ItemSpade {

    private static final Set shovelBlocks = Sets.newHashSet(new Block[]{Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, Blocks.soul_sand, Blocks.mycelium});

    protected ItemExcavator(Item.ToolMaterial material) {
        super(material);
        this.setCreativeTab(CreativeTab.EMERALDTOOLS_TAB);
    }

    public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer player)
    {

        return false;
    }

    public boolean func_150897_b(Block block)
    {
        return shovelBlocks.contains(block);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase player) {
        LogHelper.info("block destroyed!");
        if(!world.isRemote && stack != null && this.canHarvestBlock(block, stack)) {
            LogHelper.info("breaking other 8 blocks!");
            int face = NBTHelper.getInt(stack, "Face");
            ForgeDirection clickDir = ForgeDirection.getOrientation(face);
            stack.damageItem(1, player);
            for(ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS){
                int bx = x+dir.offsetX;
                int by = y+dir.offsetY;
                int bz = z+dir.offsetZ;
                Block b2 = world.getBlock(bx, by, bz);
                if(dir != clickDir && dir != clickDir.getOpposite() && stack != null && this.canHarvestBlock(b2, stack)){
                    stack.damageItem(1, player);
                    world.spawnEntityInWorld(new EntityItem(world, bx, by, bz, new ItemStack(b2.getItemDropped(1, new Random(), 1), b2.quantityDropped(new Random()))));
                    world.setBlock(bx, by, bz, Blocks.air);
                    for(ForgeDirection dir2 : ForgeDirection.VALID_DIRECTIONS) {
                        int bx2 = bx + dir2.offsetX;
                        int by2 = by + dir2.offsetY;
                        int bz2 = bz + dir2.offsetZ;
                        Block b3 = world.getBlock(bx2, by2, bz2);
                        if (dir2 != clickDir && dir2 != clickDir.getOpposite() && dir2 != dir && dir2 != dir.getOpposite() && stack != null && this.canHarvestBlock(b3, stack)) {
                            stack.damageItem(1, player);
                            world.spawnEntityInWorld(new EntityItem(world, bx2, by2, bz2, new ItemStack(b3.getItemDropped(1, new Random(), 1), b3.quantityDropped(new Random()))));
                            world.setBlock(bx2, by2, bz2, Blocks.air);
                        }
                    }
                }
            }
        }
        return true;
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
