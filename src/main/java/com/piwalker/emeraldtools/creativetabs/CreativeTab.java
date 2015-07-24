package com.piwalker.emeraldtools.creativetabs;

import com.piwalker.emeraldtools.references.References;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
public class CreativeTab {
    public static CreativeTabs EMERALDTOOLS_TAB = new CreativeTabs(References.MOD_ID) {
        @Override
        public Item getTabIconItem() {
            return Items.emerald;
        }
    };
}
