package com.piwalker.emeraldtools.init;

import com.piwalker.emeraldtools.crafting.EmeraldToolsRecipe;
import com.piwalker.emeraldtools.crafting.EmeraldToolsRegistry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
public class Recipes {
    public static void init(){
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.emeraldShard, 16),"gemEmerald"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.emeraldStone), ModItems.emeraldShard, Blocks.stone));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.emeraldCore), "III", "IEI", "III", 'I', "ingotIron", 'E', "blockEmerald"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.diamondHammer), "DDD", "DSD", " S ", 'D', "gemDiamond", 'S', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.diamondExcavator), " D ", "DSD", " S ", 'D', "gemDiamond", 'S', "stickWood"));
        EmeraldToolsRegistry.RegisterRecipe(new EmeraldToolsRecipe(new ItemStack(ModItems.emeraldPick), 4, new ItemStack(Items.diamond_pickaxe), 10));
        EmeraldToolsRegistry.RegisterRecipe(new EmeraldToolsRecipe(new ItemStack(ModItems.emeraldSpade),4 , new ItemStack(Items.diamond_shovel), 10));
        EmeraldToolsRegistry.RegisterRecipe(new EmeraldToolsRecipe(new ItemStack(ModItems.emeraldSword),4 , new ItemStack(Items.diamond_sword), 10));
        EmeraldToolsRegistry.RegisterRecipe(new EmeraldToolsRecipe(new ItemStack(ModItems.emeraldAxe),4 , new ItemStack(Items.diamond_axe), 10));
        EmeraldToolsRegistry.RegisterRecipe(new EmeraldToolsRecipe(new ItemStack(ModItems.emeraldHoe),4 , new ItemStack(Items.diamond_hoe), 10));
        EmeraldToolsRegistry.RegisterRecipe(new EmeraldToolsRecipe(new ItemStack(ModItems.emeraldHammer),4 , new ItemStack(ModItems.diamondHammer), 10));
        EmeraldToolsRegistry.RegisterRecipe(new EmeraldToolsRecipe(new ItemStack(ModItems.emeraldExcavator),4 , new ItemStack(ModItems.diamondExcavator), 10));
    }
}
