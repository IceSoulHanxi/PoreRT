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

import static org.spongepowered.api.data.manipulator.catalog.CatalogEntityData.TAMEABLE_DATA;

import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Creature;
import org.spongepowered.api.entity.living.animal.Animal;

public class PoreTameable extends PoreAnimals implements org.bukkit.entity.Tameable, Creature {

    public static PoreTameable of(Animal handle) {
        return WrapperConverter.of(PoreTameable.class, handle);
    }

    protected PoreTameable(Animal handle) {
        super(handle);
    }

    @Override
    public boolean isTamed() {
        return hasData(TAMEABLE_DATA) && getHandle().get(TAMEABLE_DATA).get().owner().get().isPresent();
    }

    @Override
    public void setTamed(boolean tame) {
        if (tame != isTamed()) {
            if (tame) {
                getHandle().offer(getHandle().getOrCreate(TAMEABLE_DATA).get());
            } else {
                getHandle().remove(TAMEABLE_DATA);
            }
        }
    }

    @Override
    public AnimalTamer getOwner() {
        throw new NotImplementedException("TODO"); //TODO
        //return isTamed() ? PoreAnimalTamer.of(getHandle().get(TAMEABLE_DATA).get().owner().get().get()) : null;
    }

    @Override
    public void setOwner(AnimalTamer tamer) {
        throw new NotImplementedException("TODO"); //TODO
        /*getHandle().offer(getHandle().getOrCreate(TAMEABLE_DATA).get()
                .owner().setTo(((PoreAnimalTamer) tamer).getHandle()));*/
    }
}
