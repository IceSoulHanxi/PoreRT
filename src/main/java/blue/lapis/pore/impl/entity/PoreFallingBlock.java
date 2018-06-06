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

import blue.lapis.pore.converter.type.material.MaterialConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.FallingBlock;

@SuppressWarnings("deprecation")
public class PoreFallingBlock extends PoreEntity implements org.bukkit.entity.FallingBlock {

    public static PoreFallingBlock of(FallingBlock handle) {
        return WrapperConverter.of(PoreFallingBlock.class, handle);
    }

    protected PoreFallingBlock(FallingBlock handle) {
        super(handle);
    }

    @Override
    public FallingBlock getHandle() {
        return (FallingBlock) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.FALLING_BLOCK;
    }

    @Override
    public Material getMaterial() {
        return MaterialConverter.of(getHandle().getFallingBlockData().blockState().get().getType());
    }

    @Override
    public int getBlockId() {
        return getMaterial().getId();
    }

    @Override
    public byte getBlockData() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public boolean getDropItem() {
        return getHandle().getFallingBlockData().canDropAsItem().get();
    }

    @Override
    public void setDropItem(boolean drop) {
        getHandle().offer(getHandle().getFallingBlockData().canDropAsItem().set(drop));
    }

    @Override
    public boolean canHurtEntities() {
        return getHandle().canHurtEntities().get();
    }

    @Override
    public void setHurtEntities(boolean hurtEntities) {
        getHandle().canHurtEntities().set(hurtEntities);
    }

}
