/*
 * New BSD License (BSD-new)
 *
 * Copyright (c) 2015 Maxim Roncacé
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     - Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     - Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     - Neither the name of the copyright holder nor the names of its contributors
 *       may be used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.caseif.flint.util.physical;

import org.junit.Test;

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
