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

import blue.lapis.pore.converter.type.attribute.EventResultConverter;
import blue.lapis.pore.event.PoreEvent;
import blue.lapis.pore.event.RegisterEvent;
import blue.lapis.pore.impl.entity.PorePlayer;
import blue.lapis.pore.impl.inventory.PoreInventory;
import blue.lapis.pore.impl.inventory.PoreInventoryView;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.DragType;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
//import org.spongepowered.api.event.cause.NamedCause;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RegisterEvent // TODO Not implemented in Sponge
public final class PoreInventoryDragEvent extends InventoryDragEvent implements PoreEvent<ClickInventoryEvent.Drag> {

    private final ClickInventoryEvent.Drag handle;

    public PoreInventoryDragEvent(ClickInventoryEvent.Drag handle) {
        super(null, null, new ItemStack(Material.DIRT, 1), false, Maps.<Integer, ItemStack>newHashMap());
        this.handle = checkNotNull(handle, "handle");
    }

    public ClickInventoryEvent.Drag getHandle() {
        return this.handle;
    }

    @Override
    public Inventory getInventory() {
        return PoreInventory.of(this.getHandle().getTargetInventory());
    }

    @Override
    public List<HumanEntity> getViewers() {
        return this.getInventory().getViewers();
    }

    @Override
    public InventoryView getView() {
        return PoreInventoryView.builder()
                .setPlayer(getWhoClicked())
                .setTopInventory(getInventory())
                .setBottomInventory(getWhoClicked().getInventory())
                .build();
    }

    @Override
    public HumanEntity getWhoClicked() {
        return PorePlayer.of((Player) getHandle().getSource());
    }

    @Override
    public Map<Integer, ItemStack> getNewItems() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public Set<Integer> getRawSlots() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public Set<Integer> getInventorySlots() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public ItemStack getCursor() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void setCursor(ItemStack newCursor) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public ItemStack getOldCursor() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public DragType getType() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public Event.Result getResult() {
        return EventResultConverter.of(getHandle().isCancelled());
    }

    @Override
    public void setResult(Event.Result newResult) {
        getHandle().setCancelled(EventResultConverter.of(newResult));
    }

    @Override
    public boolean isCancelled() {
        return handle.isCancelled();
    }

    @Override
    public void setCancelled(boolean cancelled) {
        handle.setCancelled(cancelled);
    }

    @Override
    public String toString() {
        return toStringHelper().toString();
    }
}
