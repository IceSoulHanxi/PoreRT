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

package blue.lapis.pore.impl.inventory.meta;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.FireworkEffect;
import org.bukkit.inventory.meta.FireworkMeta;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.List;

// TODO: bridge

// TODO: bridge

public class PoreFireworkMeta extends PoreItemMeta implements FireworkMeta {

    public PoreFireworkMeta(ItemStack holder) {
        super(holder);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void addEffect(FireworkEffect effect) throws IllegalArgumentException {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void addEffects(FireworkEffect... effects) throws IllegalArgumentException {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void addEffects(Iterable<FireworkEffect> effects) throws IllegalArgumentException {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public List<FireworkEffect> getEffects() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public int getEffectsSize() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void removeEffect(int index) throws IndexOutOfBoundsException {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void clearEffects() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public boolean hasEffects() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public int getPower() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void setPower(int power) throws IllegalArgumentException {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public FireworkMeta clone() {
        throw new NotImplementedException("TODO"); //TODO
    }

}
