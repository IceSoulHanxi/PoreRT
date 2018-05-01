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

package blue.lapis.pore.command;

import blue.lapis.pore.impl.command.PoreCommandSender;
import blue.lapis.pore.util.PoreText;
import blue.lapis.pore.util.PoreWrapper;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.Command;
import org.spongepowered.api.command.CommandCallable;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.annotation.NonnullByDefault;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.List;
import java.util.Optional;

@NonnullByDefault
public class PoreCommandCallable extends PoreWrapper<Command> implements CommandCallable {

    final String label;

    public PoreCommandCallable(Command handle, String label) {
        super(handle);
        this.label = label;
    }

    @Override
    public CommandResult process(CommandSource source, String arguments) throws CommandException {
        if (source.getName().contains("@")){
            return CommandResult.empty();
        }
        if (getHandle().execute(PoreCommandSender.of(source), label, StringUtils.split(arguments))) {
            return CommandResult.success();
        } else {
            return CommandResult.empty();
        }
    }

    @Override
    public List<String> getSuggestions(CommandSource source, String arguments, Location<World> targetPosition)
            throws CommandException {
        return getHandle().tabComplete(PoreCommandSender.of(source), label, StringUtils.split(arguments));
    }

    @Override
    public boolean testPermission(CommandSource source) {
        return getHandle().testPermissionSilent(PoreCommandSender.of(source));
    }

    @Override
    public Optional<Text> getShortDescription(CommandSource source) {
        return getHelp(source);
    }

    @Override
    public Optional<Text> getHelp(CommandSource source) {
        return Optional.of(PoreText.convert(getHandle().getDescription()));
    }

    @Override
    public Text getUsage(CommandSource source) {
        return PoreText.convert(getHandle().getUsage());
    }
}
