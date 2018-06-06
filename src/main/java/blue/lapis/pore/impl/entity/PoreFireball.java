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

import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.EXPLOSIVE_RADIUS_DATA;

import blue.lapis.pore.converter.vector.VectorConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.util.Vector;
import org.spongepowered.api.entity.projectile.DamagingProjectile;
import org.spongepowered.api.entity.projectile.explosive.fireball.Fireball;

public class PoreFireball extends PoreProjectile implements org.bukkit.entity.Fireball {

    public static PoreFireball of(DamagingProjectile handle) {
        return WrapperConverter.of(PoreFireball.class, handle);
    }

    protected PoreFireball(Fireball handle) {
        super(handle);
    }

    protected PoreFireball(DamagingProjectile handle) {
        super(handle);
    }

    @Override
    public DamagingProjectile getHandle() {
        return (Fireball) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.FIREBALL;
    }

    @Override
    public Vector getDirection() {
        //TODO: I'm not entirely sure how this method is supposed to behave, so this impl might change
        return VectorConverter.createBukkitVector(getHandle().getRotation());
    }

    @Override
    public void setDirection(Vector direction) {
        getHandle().setRotation(VectorConverter.create3d(direction));
    }

    @Override
    public float getYield() { // TODO: ???
        return getHandle().get(EXPLOSIVE_RADIUS_DATA).get().explosionRadius().get().get();
    }

    @Override
    public void setYield(float yield) {
        getHandle().get(EXPLOSIVE_RADIUS_DATA).get().explosionRadius().setTo((int) yield);
    }

    @Override
    public boolean isIncendiary() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void setIsIncendiary(boolean isIncendiary) {
        throw new NotImplementedException("TODO"); //TODO
    }

}
