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

import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.bukkit.Location;
import org.bukkit.entity.EnderSignal;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.projectile.EyeOfEnder;

public class PoreEnderSignal extends PoreEntity implements EnderSignal {

    public static PoreEnderSignal of(EyeOfEnder handle) {
        return WrapperConverter.of(PoreEnderSignal.class, handle);
    }

    protected PoreEnderSignal(EyeOfEnder handle) {
        super(handle);
    }

    @Override
    public EyeOfEnder getHandle() {
        return (EyeOfEnder) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.ENDER_SIGNAL;
    }

    @Override
    public Location getTargetLocation() {
        return null;
    }

    @Override
    public void setTargetLocation(Location location) {

    }

    @Override
    public boolean getDropItem() {
        return false;
    }

    @Override
    public void setDropItem(boolean drop) {

    }

    @Override
    public int getDespawnTimer() {
        return 0;
    }

    @Override
    public void setDespawnTimer(int timer) {

    }
}
