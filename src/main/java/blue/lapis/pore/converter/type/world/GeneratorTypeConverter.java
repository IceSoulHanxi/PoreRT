/*
 * PoreRT - A Bukkit to Sponge Bridge
 *
 * Copyright (c) 2016-2017, Maxqia <https://github.com/Maxqia> AGPLv3
 * Copyright (c) 2014-2016, Lapis <https://github.com/LapisBlue> MIT
 * Copyright (c) Contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * An exception applies to this license, see the LICENSE file in the main directory for more information.
 */


package blue.lapis.pore.converter.type.world;

import blue.lapis.pore.converter.type.TypeConverter;

import com.google.common.base.Converter;
import org.bukkit.WorldType;
import org.spongepowered.api.world.GeneratorType;
import org.spongepowered.api.world.GeneratorTypes;

public final class GeneratorTypeConverter {

    private GeneratorTypeConverter() {
    }

    private static final Converter<WorldType, GeneratorType> CONVERTER =
            TypeConverter.builder(WorldType.class, GeneratorType.class)
                    .add(WorldType.NORMAL, GeneratorTypes.DEFAULT)
                    .add(WorldType.FLAT, GeneratorTypes.FLAT)
                    .add(WorldType.VERSION_1_1, (GeneratorType) net.minecraft.world.WorldType.DEFAULT_1_1) // dunno why this isn't in sponge...
                    .add(WorldType.LARGE_BIOMES, GeneratorTypes.LARGE_BIOMES)
                    .add(WorldType.AMPLIFIED, GeneratorTypes.AMPLIFIED)
                    .add(WorldType.CUSTOMIZED, (GeneratorType) net.minecraft.world.WorldType.CUSTOMIZED) // same with this one
                    .build();

    public static GeneratorType of(WorldType worldType) {
        return CONVERTER.convert(worldType);
    }

    public static WorldType of(GeneratorType dimension) {
        return CONVERTER.reverse().convert(dimension);
    }
}
