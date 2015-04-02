/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Maxim Roncacé
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
package net.caseif.flint.api.physical;

import com.google.common.base.Optional;

/**
 * Represents a three-dimensional point in space, or optionally, in a world.
 *
 * @author Max Roncacé
 * @since 0.1.0
 */
public class Location3D {

    private final String world;
    private final double x;
    private final double y;
    private final double z;

    /**
     * Constructs a new {@link Location3D} in the given world from the given
     * coordinates.
     *
     * @param world The name of the world which contains this {@link Location3D}
     * @param x The x-coordinate of the new {@link Location3D}
     * @param y The y-coordinate of the new {@link Location3D}
     * @param z The z-coordinate of the new {@link Location3D}
     * @since 0.1.0
     */
    public Location3D(String world, double x, double y, double z) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Constructs a new {@link Location3D} from the given coordinates.
     *
     * @param x The x-coordinate of the new {@link Location3D}
     * @param y The y-coordinate of the new {@link Location3D}
     * @param z The z-coordinate of the new {@link Location3D}
     * @since 0.1.0
     */
    public Location3D(double x, double y, double z) {
        this.world = null;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Gets the world containing this {@link Location3D}.
     *
     * @return The world containing this {@link Location3D}, or
     *         {@link Optional#absent()} if one is not defined
     * @since 0.1.0
     */
    Optional<String> getWorld() {
        return Optional.fromNullable(this.world);
    }

    /**
     * Gets the x-coordinate of this {@link Location3D}.
     *
     * @return The x-coordinate of this {@link Location3D}
     * @since 0.1.0
     */
    public double getX() {
        return this.x;
    }

    /**
     * Gets the y-coordinate of this {@link Location3D}.
     *
     * @return The y-coordinate of this {@link Location3D}
     * @since 0.1.0
     */
    public double getY() {
        return this.y;
    }

    /**
     * Gets the z-coordinate of this {@link Location3D}.
     *
     * @return The z-coordinate of this {@link Location3D}
     * @since 0.1.0
     */
    public double getZ() {
        return this.z;
    }

}
