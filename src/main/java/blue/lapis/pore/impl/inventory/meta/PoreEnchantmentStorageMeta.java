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

// TODO: bridge

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.Map;

public class PoreEnchantmentStorageMeta extends PoreItemMeta implements EnchantmentStorageMeta {

    public PoreEnchantmentStorageMeta(ItemStack holder) {
        super(holder);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean hasStoredEnchants() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public boolean hasStoredEnchant(Enchantment ench) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public int getStoredEnchantLevel(Enchantment ench) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public Map<Enchantment, Integer> getStoredEnchants() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public boolean addStoredEnchant(Enchantment ench, int level, boolean ignoreLevelRestriction) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public boolean removeStoredEnchant(Enchantment ench) throws IllegalArgumentException {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public boolean hasConflictingStoredEnchant(Enchantment ench) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public EnchantmentStorageMeta clone() {
        throw new NotImplementedException("TODO"); //TODO
    }
}
