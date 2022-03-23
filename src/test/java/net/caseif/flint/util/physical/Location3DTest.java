/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015-2022, Max Roncace <me@caseif.net>
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

package net.caseif.flint.util.physical;

import org.junit.jupiter.api.Test;

public class Location3DTest {

    @Test
    public void testSerialization() {
        String world = "caseif is awesome";
        double x = 42.0;
        double y = -101.0;
        double z = 7.43;
        Location3D loc = new Location3D(world, x, y, z);
        String serial = loc.serialize();
        Location3D des = Location3D.deserialize(serial);
        assert des.getWorld().isPresent();
        assert des.getWorld().get().equals(world);
        assert des.getX() == x;
        assert des.getY() == y;
        assert des.getZ() == z;
    }

    @Test
    public void testSerializationWithoutWorld() {
        double x = 42.0;
        double y = -101.0;
        double z = 7.43;
        Location3D loc = new Location3D(x, y, z);
        String serial = loc.serialize();
        Location3D des = Location3D.deserialize(serial);
        assert !des.getWorld().isPresent();
        assert des.getX() == x;
        assert des.getY() == y;
        assert des.getZ() == z;
    }

}
