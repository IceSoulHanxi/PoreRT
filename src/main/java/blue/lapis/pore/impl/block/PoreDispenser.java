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

package blue.lapis.pore.impl.block;

import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.inventory.PoreInventory;
import blue.lapis.pore.impl.projectiles.PoreBlockProjectileSource;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.inventory.Inventory;
import org.bukkit.projectiles.BlockProjectileSource;
import org.spongepowered.api.block.tileentity.carrier.Dispenser;

public class PoreDispenser extends PoreContainer implements org.bukkit.block.Dispenser {

    public static PoreDispenser of(Dispenser handle) {
        return WrapperConverter.of(PoreDispenser.class, handle);
    }

    protected PoreDispenser(Dispenser handle) {
        super(handle);
    }

    @Override
    Dispenser getTileEntity() {
        return (Dispenser) super.getTileEntity();
    }

    @Override
    public BlockProjectileSource getBlockProjectileSource() {
        return PoreBlockProjectileSource.of(getTileEntity());
    }

    @Override
    public boolean dispense() { //TODO bug sponge about this
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public Inventory getInventory() {
        return PoreInventory.of(getTileEntity().getInventory());
    }
}
