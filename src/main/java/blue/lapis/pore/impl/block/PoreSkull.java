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

package blue.lapis.pore.impl.block;

import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.OfflinePlayer;
import org.bukkit.SkullType;
import org.bukkit.block.BlockFace;
import org.spongepowered.api.block.tileentity.Skull;

public class PoreSkull extends PoreBlockState implements org.bukkit.block.Skull {

    public static PoreSkull of(Skull handle) {
        return WrapperConverter.of(PoreSkull.class, handle);
    }

    protected PoreSkull(Skull handle) {
        super(handle);
    }

    @Override
    Skull getTileEntity() {
        return (Skull) super.getTileEntity();
    }

    @Override
    public boolean hasOwner() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public String getOwner() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public boolean setOwner(String name) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public BlockFace getRotation() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void setRotation(BlockFace rotation) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public SkullType getSkullType() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void setSkullType(SkullType skullType) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public OfflinePlayer getOwningPlayer() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void setOwningPlayer(OfflinePlayer player) {
        throw new NotImplementedException("TODO"); //TODO
    }
}
