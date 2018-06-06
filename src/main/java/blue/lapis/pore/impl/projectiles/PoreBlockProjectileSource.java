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

package blue.lapis.pore.impl.projectiles;

import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.util.PoreWrapper;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.block.Block;
import org.bukkit.entity.Projectile;
import org.bukkit.util.Vector;
import org.spongepowered.api.entity.projectile.source.BlockProjectileSource;

public class PoreBlockProjectileSource
        extends PoreWrapper<BlockProjectileSource> implements org.bukkit.projectiles.BlockProjectileSource {

    public static PoreBlockProjectileSource of(BlockProjectileSource handle) {
        return WrapperConverter.of(PoreBlockProjectileSource.class, handle);
    }

    protected PoreBlockProjectileSource(BlockProjectileSource handle) {
        super(handle);
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public Block getBlock() {
        throw new NotImplementedException("TODO"); //TODO
    }
}
