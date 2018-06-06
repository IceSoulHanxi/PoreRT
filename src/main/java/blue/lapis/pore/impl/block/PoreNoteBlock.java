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

import static org.spongepowered.api.data.key.Keys.NOTE_PITCH;

import blue.lapis.pore.converter.type.world.effect.NoteConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Instrument;
import org.bukkit.block.NoteBlock;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.block.tileentity.Note;

public class PoreNoteBlock extends PoreBlockState implements NoteBlock {

    public static PoreNoteBlock of(Note handle) {
        return WrapperConverter.of(PoreNoteBlock.class, handle);
    }

    protected PoreNoteBlock(Note handle) {
        super(handle);
    }

    @Override
    Note getTileEntity() {
        return (Note) super.getTileEntity();
    }

    @Override
    public org.bukkit.Note getNote() {
        return NoteConverter.of(getTileEntity().isValid() ? getTileEntity().get(NOTE_PITCH).get() : null);
    }

    @Override
    @SuppressWarnings("deprecation")
    public byte getRawNote() {
        return getNote().getId();
    }

    @Override
    public void setNote(org.bukkit.Note note) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void setRawNote(byte note) {
        setNote(new org.bukkit.Note(note));
    }

    @Override
    public boolean play() {
        getTileEntity().playNote();
        return getTileEntity().getBlock().getType() == BlockTypes.NOTEBLOCK;
    }

    @Override
    public boolean play(byte instrument, byte note) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public boolean play(Instrument instrument, org.bukkit.Note note) {
        throw new NotImplementedException("TODO"); //TODO
    }
}
