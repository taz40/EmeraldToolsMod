package com.piwalker.emeraldtools.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
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
    }
}
