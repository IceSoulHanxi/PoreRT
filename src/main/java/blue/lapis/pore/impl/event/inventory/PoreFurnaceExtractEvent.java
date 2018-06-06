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
import blue.lapis.pore.impl.entity.PorePlayer;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.FurnaceExtractEvent;
//import org.spongepowered.api.event.cause.NamedCause;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;

public final class PoreFurnaceExtractEvent extends FurnaceExtractEvent
    implements PoreEvent<ClickInventoryEvent.Primary> {

    private final ClickInventoryEvent.Primary handle;

    public PoreFurnaceExtractEvent(ClickInventoryEvent.Primary handle) {
        super(null, null, null, -1, -1);
        this.handle = checkNotNull(handle, "handle");
        //TODO: assert handle involves furnace inventory
    }

    public ClickInventoryEvent.Primary getHandle() {
        return this.handle;
    }

    @Override
    public Block getBlock() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public int getExpToDrop() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void setExpToDrop(int exp) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public Player getPlayer() {
        return PorePlayer.of((org.spongepowered.api.entity.living.player.Player) getHandle().getSource());
    }

    @Override
    public Material getItemType() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public int getItemAmount() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public String toString() {
        return toStringHelper().toString();
    }
    //TODO register event
}
