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

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.spongepowered.api.entity.EnderCrystal;

public class PoreEnderCrystal extends PoreEntity implements org.bukkit.entity.EnderCrystal {

    public static PoreEnderCrystal of(EnderCrystal handle) {
        return WrapperConverter.of(PoreEnderCrystal.class, handle);
    }

    protected PoreEnderCrystal(EnderCrystal handle) {
        super(handle);
    }

    @Override
    public EnderCrystal getHandle() {
        return (EnderCrystal) super.getHandle();
    }

    @Override
    public EntityType getType() {
        return EntityType.ENDER_CRYSTAL;
    }

    @Override
    public boolean isShowingBottom() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void setShowingBottom(boolean showing) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public Location getBeamTarget() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void setBeamTarget(Location location) {
        throw new NotImplementedException("TODO"); //TODO
    }

}
