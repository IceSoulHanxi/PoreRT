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

package blue.lapis.pore.impl.map;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapCursorCollection;
import org.bukkit.map.MapFont;
import org.bukkit.map.MapView;

import java.awt.Image;

public class PoreMapCanvas implements MapCanvas {

    // TODO: Bridge

    @Override
    public MapView getMapView() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public MapCursorCollection getCursors() {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void setCursors(MapCursorCollection cursors) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void setPixel(int x, int y, byte color) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public byte getPixel(int x, int y) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public byte getBasePixel(int x, int y) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void drawImage(int x, int y, Image image) {
        throw new NotImplementedException("TODO"); //TODO
    }

    @Override
    public void drawText(int x, int y, MapFont font, String text) {
        throw new NotImplementedException("TODO"); //TODO
    }

}
