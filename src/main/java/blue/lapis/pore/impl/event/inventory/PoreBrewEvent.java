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

package blue.lapis.pore.impl.event.inventory;

import static com.google.common.base.Preconditions.checkNotNull;

import blue.lapis.pore.event.PoreEvent;
import blue.lapis.pore.event.RegisterEvent;
import blue.lapis.pore.impl.block.PoreBlock;
import blue.lapis.pore.impl.inventory.PoreBrewerInventory;

import org.bukkit.block.Block;
import org.bukkit.inventory.BrewerInventory;
import org.spongepowered.api.event.block.tileentity.BrewingEvent;

// I know the bukkit javadocs says end, but you can't cancel BrewingEvent.Finish
@RegisterEvent // TODO Not implemented in Sponge
public final class PoreBrewEvent extends org.bukkit.event.inventory.BrewEvent implements PoreEvent<BrewingEvent.Start> {

    private final BrewingEvent.Start handle;

    public PoreBrewEvent(BrewingEvent.Start handle) {
        super(null, null, 0);
        this.handle = checkNotNull(handle, "handle");
    }

    public BrewingEvent.Start getHandle() {
        return this.handle;
    }

    @Override
    public Block getBlock() {
        return PoreBlock.of(this.getHandle().getTargetTile().getLocation());
    }

    @Override
    public BrewerInventory getContents() {
        return PoreBrewerInventory.of(this.getHandle().getTargetTile().getInventory());
    }

    @Override
    public int getFuelLevel() {
        return 0;
    }

    @Override
    public boolean isCancelled() {
        return this.getHandle().isCancelled();
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.getHandle().setCancelled(cancel);
    }

    @Override
    public String toString() {
        return toStringHelper().toString();
    }
}
