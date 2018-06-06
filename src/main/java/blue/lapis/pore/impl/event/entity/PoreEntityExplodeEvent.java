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

package blue.lapis.pore.impl.event.entity;

import static com.google.common.base.Preconditions.checkNotNull;

import blue.lapis.pore.converter.vector.LocationConverter;
import blue.lapis.pore.event.PoreEvent;
import blue.lapis.pore.event.RegisterEvent;
import blue.lapis.pore.event.Source;
import blue.lapis.pore.impl.entity.PoreEntity;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.world.ExplosionEvent;
import org.spongepowered.api.world.explosion.Explosion;

import java.util.List;

@RegisterEvent
public final class PoreEntityExplodeEvent extends EntityExplodeEvent implements PoreEvent<ExplosionEvent.Pre> {

    private final ExplosionEvent.Pre handle;
    private final Entity exploder;

    //TODO Double check that it is the source
    public PoreEntityExplodeEvent(ExplosionEvent.Pre handle, @Source Entity exploder) {
        super(null, null, null, -1);
        this.handle = checkNotNull(handle, "handle");
        this.exploder = checkNotNull(exploder, "exploder");
    }

    @Override
    public ExplosionEvent.Pre getHandle() {
        return this.handle;
    }

    @Override
    public org.bukkit.entity.Entity getEntity() {
        return PoreEntity.of(this.exploder);
    }

    @Override
    public EntityType getEntityType() {
        return getEntity().getType();
    }

    @Override
    public List<Block> blockList() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public Location getLocation() {
        return LocationConverter.of(getHandle().getExplosion().getLocation());
    }

    @Override
    public float getYield() {
        return this.getHandle().getExplosion().getRadius();
    }

    @Override
    public void setYield(float yield) {
        getHandle().setExplosion(Explosion.builder().from(getHandle().getExplosion()).radius(yield).build());
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
        return toStringHelper().toString();
    }

}
