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

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.spongepowered.api.entity.living.monster.Slime;

public class PoreSlime extends PoreLivingEntity implements org.bukkit.entity.Slime {

    public static PoreSlime of(Slime handle) {
        return WrapperConverter.of(PoreSlime.class, handle);
    }

    protected PoreSlime(Slime handle) {
        super(handle);
    }

    @Override
    public Slime getHandle() {
        return (Slime) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.SLIME;
    }

    @Override
    public int getSize() {
        return getHandle().getSlimeData().size().get();
    }

    @Override
    public void setSize(int size) {
        getHandle().offer(getHandle().getSlimeData().size().set(size));
    }

    @Override
    public void setTarget(LivingEntity target) {

    }

    @Override
    public LivingEntity getTarget() {
        return null;
    }
}
