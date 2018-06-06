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

package blue.lapis.pore.impl.event.block;

import static com.google.common.base.Preconditions.checkNotNull;

import blue.lapis.pore.event.PoreEvent;
import blue.lapis.pore.event.PoreEventRegistry;
import blue.lapis.pore.event.RegisterEvent;
import blue.lapis.pore.impl.block.PoreBlock;

import org.bukkit.block.Block;
import org.bukkit.event.block.LeavesDecayEvent;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.util.GuavaCollectors;

public final class PoreLeavesDecayEvent extends LeavesDecayEvent implements PoreEvent<ChangeBlockEvent.Decay> {

    private final ChangeBlockEvent.Decay handle;
    private final Transaction<BlockSnapshot> transaction;

    public PoreLeavesDecayEvent(ChangeBlockEvent.Decay handle, Transaction<BlockSnapshot> transaction) {
        super(null);
        this.handle = checkNotNull(handle, "handle");
        this.transaction = checkNotNull(transaction, "transaction");
    }

    public ChangeBlockEvent.Decay getHandle() {
        return handle;
    }

    @Override
    public Block getBlock() {
        return PoreBlock.of(this.transaction.getOriginal().getLocation().orElse(null));
    }

    @Override
    public boolean isCancelled() {
        return getHandle().isCancelled();
    }

    @Override
    public void setCancelled(boolean cancel) {
        getHandle().setCancelled(cancel);
    }

    @Override
    public String toString() {
        return toStringHelper()
                .add("transaction", this.transaction)
                .toString();
    }

    @RegisterEvent
    public static void register() {
        PoreEventRegistry.register(PoreLeavesDecayEvent.class, ChangeBlockEvent.Decay.class, event -> {
            return event.getTransactions().stream()
                    .map(transaction -> new PoreLeavesDecayEvent(event, transaction))
                    .collect(GuavaCollectors.toImmutableList());
        });
    }
}
