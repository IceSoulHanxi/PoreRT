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
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.spongepowered.api.entity.living.complex.EnderDragonPart;

public class PoreEnderDragonPart extends PoreComplexEntityPart implements org.bukkit.entity.EnderDragonPart {

    public static PoreEnderDragonPart of(EnderDragonPart handle) {
        return WrapperConverter.of(PoreEnderDragonPart.class, handle);
    }

    protected PoreEnderDragonPart(EnderDragonPart handle) {
        super(handle);
    }

    @Override
    public EnderDragonPart getHandle() {
        return (EnderDragonPart) super.getHandle();
    }

    @Override
    public EnderDragon getParent() {
        return PoreEnderDragon.of(getHandle().getParent());
    }

    @Override
    public void damage(double amount) {
        getParent().damage(amount);
    }

    @Override
    public void damage(double amount, Entity source) {
        getParent().damage(amount, source);
    }

    /*
    @Override
    public void _INVALID_damage(int amount) {
        this.damage(amount);
    }

    @Override
    public void _INVALID_damage(int amount, Entity source) {
        this.damage(amount, source);
    }
    */

    @Override
    public double getHealth() {
        return this.getHandle().getParent().getHealthData().health().get();
    }

    /*
    @Override
    public int _INVALID_getHealth() {
        return (int) getHealth();
    }
    */

    @Override
    public void setHealth(double health) {
        this.getHandle().getParent().getHealthData().health().set(health);
    }

    /*
    @Override
    public void _INVALID_setHealth(int health) {
        this.setHealth(health);
    }
    */

    @Override
    public double getMaxHealth() {
        return this.getHandle().getParent().getHealthData().maxHealth().get();
    }

    /*
    @Override
    public int _INVALID_getMaxHealth() {
        return (int) this.getMaxHealth();
    }
    */

    @Override
    public void setMaxHealth(double health) {
        this.getHandle().getParent().getHealthData().maxHealth().set(health);
    }

    /*
    @Override
    public void _INVALID_setMaxHealth(int health) {
        this.setMaxHealth(health);
    }
    */

    @Override
    public void resetMaxHealth() {
        this.setMaxHealth(this.getHandle().getParent().getHealthData().maxHealth().getDefault());
    }
}
