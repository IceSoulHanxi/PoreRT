/*
 * Pore(RT)
 * Copyright (c) 2014-2016, Lapis <https://github.com/LapisBlue>
 * Copyright (c) 2014-2016, Contributors
 *
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package blue.lapis.pore.impl.entity;

import blue.lapis.pore.converter.type.material.ItemStackConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.entity.Item;

public class PoreItem extends PoreEntity implements org.bukkit.entity.Item {

    public static PoreItem of(Item handle) {
        return WrapperConverter.of(PoreItem.class, handle);
    }

    protected PoreItem(Item handle) {
        super(handle);
    }

    @Override
    public Item getHandle() {
        return (Item) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.DROPPED_ITEM;
    }

    @Override
    public ItemStack getItemStack() {
        // No idea what I'm doing here...
        return ItemStackConverter.of(getHandle().get(Keys.REPRESENTED_ITEM).get().createStack());
    }

    @Override
    public void setItemStack(ItemStack stack) {
        // No idea what I'm doing here...
        getHandle().offer(Keys.REPRESENTED_ITEM, ItemStackConverter.of(stack).createSnapshot());
    }

    @Override
    public int getPickupDelay() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void setPickupDelay(int delay) {
        throw new NotImplementedException("TODO"); //TODO
    }
}
