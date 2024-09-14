package com.thy.test.items;

import com.thy.test.Test;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().group(Test.TAB));
    }
}
