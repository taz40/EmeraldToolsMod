package com.piwalker.emeraldtools.inventory;

import com.piwalker.emeraldtools.tileentity.TileEntityEmeraldCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by SamuelPiWalker on 7/23/2015.
 */
public class ContainerChrystalAlter extends ContainerEmeraldTools {
    private TileEntityEmeraldCore te;

    public ContainerChrystalAlter(InventoryPlayer playerInventory, TileEntityEmeraldCore te){
        this.te = te;
        this.addSlotToContainer(new Slot(te, 0, 23, 33));
        this.addSlotToContainer(new Slot(te, 1, 43, 33));
        this.addSlotToContainer(new Slot(te, 2, 64, 33));
        this.addSlotToContainer(new Slot(te, 3, 84, 33));
        this.addSlotToContainer(new Slot(te, 4, 142, 33));

        this.addPlayerSlots(playerInventory, 8,84);
    }


    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return te.isUseableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slotNum)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(slotNum);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slotNum < 5)
            {
                if (!this.mergeItemStack(itemstack1, 5, 41, true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, 5, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }
}
