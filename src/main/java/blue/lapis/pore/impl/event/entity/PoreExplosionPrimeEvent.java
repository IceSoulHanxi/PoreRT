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

import blue.lapis.pore.converter.type.entity.EntityConverter;
import blue.lapis.pore.event.PoreEvent;
import blue.lapis.pore.event.RegisterEvent;
import blue.lapis.pore.impl.entity.PoreEntity;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.spongepowered.api.event.entity.explosive.PrimeExplosiveEvent;

@RegisterEvent
public final class PoreExplosionPrimeEvent extends ExplosionPrimeEvent implements PoreEvent<PrimeExplosiveEvent.Pre> {

    private final PrimeExplosiveEvent.Pre handle;

    public PoreExplosionPrimeEvent(PrimeExplosiveEvent.Pre handle) {
        super(null, -1f, false);
        this.handle = checkNotNull(handle, "handle");
    }

    public PrimeExplosiveEvent.Pre getHandle() {
        return this.handle;
    }

    @Override
    public Entity getEntity() {
        return PoreEntity.of(this.getHandle().getTargetEntity());
    }

    @Override
    public EntityType getEntityType() {
        return EntityConverter.of(this.getHandle().getTargetEntity().getType());
    }

    @Override
    public float getRadius() {
        return this.getHandle().getTargetEntity().explosionRadius().or(0).get();
    }

    @Override
    public void setRadius(float radius) {
        this.getHandle().getTargetEntity().explosionRadius().setTo((int) radius);
    }

    @Override
    public boolean getFire() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void setFire(boolean fire) {
        throw new NotImplementedException("TODO"); //TODO
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
