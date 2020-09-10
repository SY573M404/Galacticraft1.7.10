// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ModUtils.java

package com.gamerforea.galacticraft;

import com.gamerforea.eventhelper.nexus.ModNexus;
import com.gamerforea.eventhelper.nexus.ModNexusFactory;
import com.gamerforea.eventhelper.nexus.NexusUtils;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

@ModNexus(name = "GalactiCraft", uuid = "148f2341-e3b5-4e3e-9517-41ffc8c41654")
public final class ModUtils
{

    public ModUtils()
    {
    }

    public static int version = 3;
    public static List<String> developers = Arrays.asList("_System404_", "SY573M_404");

    public static FakePlayer getModFake(World world)
    {
        return NEXUS_FACTORY.getFake(world);
    }

    public static void addToInventory(IInventory inventory, ItemStack stacks[])
    {
        boolean markDirty = false;
        for(int i = 0; i < stacks.length; i++)
        {
            ItemStack stack = stacks[i];
            if(stack == null)
                continue;
            int maxStackSize = Math.min(stack.getMaxStackSize(), inventory.getInventoryStackLimit());
            if(maxStackSize > 0)
            {
                for(int slot = 0; slot < inventory.getSizeInventory() && stack.stackSize > 0; slot++)
                {
                    ItemStack stackInSlot = inventory.getStackInSlot(slot);
                    int toAdd;
                    if(stackInSlot == null)
                    {
                        toAdd = Math.min(stack.stackSize, maxStackSize);
                        inventory.setInventorySlotContents(slot, copyWithSize(stack, toAdd));
                        stack.stackSize -= toAdd;
                        markDirty = true;
                        continue;
                    }
                    if(stackInSlot.stackSize >= maxStackSize || !isItemEqual(stack, stackInSlot))
                        continue;
                    toAdd = Math.min(Math.min(stack.stackSize, maxStackSize), maxStackSize - stackInSlot.stackSize);
                    if(toAdd > 0)
                    {
                        stackInSlot.stackSize += toAdd;
                        inventory.setInventorySlotContents(slot, stackInSlot);
                        stack.stackSize -= toAdd;
                        markDirty = true;
                    }
                }

            }
            if(stack.stackSize <= 0)
                stacks[i] = null;
        }

        if(markDirty)
            inventory.markDirty();
    }

    public static boolean isItemEqual(ItemStack stack1, ItemStack stack2)
    {
        return stack1 != null && stack2 != null && stack1.isItemEqual(stack2) && ItemStack.areItemStackTagsEqual(stack1, stack2);
    }

    public static ItemStack copyWithSize(ItemStack stack, int size)
    {
        if(stack == null || size <= 0)
        {
            return null;
        } else
        {
            stack = stack.copy();
            stack.stackSize = size;
            return stack;
        }
    }

    public static final Logger LOGGER = LogManager.getLogger("GalactiCraft");
    public static final ModNexusFactory NEXUS_FACTORY = NexusUtils.getFactory();

}
