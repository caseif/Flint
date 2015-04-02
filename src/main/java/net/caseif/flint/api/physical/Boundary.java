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

import static com.google.common.base.Preconditions.checkState;

/**
 * Represents a three-dimensional, cuboid boundary in the world.
 *
 * <p>This may be compared to vanilla Minecraft's world border.</p>
 *
 * @author Max Roncacé
 * @since 0.1.0
 */
public class Boundary {

    private final Location3D lowerBound;
    private final Location3D upperBound;

    /**
     * Constructs a new {@link Boundary} from the given locations. These
     * locations should represent complimentary corners of a cuboid which will
     * be contained by the new {@link Boundary}.
     *
     * @param corner1 The first corner of the {@link Boundary}
     * @param corner2 The second corner of the {@link Boundary}
     * @param ignoreDifferentWorlds Whether to skip a sanity check of whether
     *                              the two locations are within the same world
     * @throws IllegalArgumentException If one or both location parameters are
     *                                  <code>null</code>, or if the worlds
     *                                  containing the locations do not match
     *                                  and <code>ignoreDifferentWorlds</code>
     *                                  is <code>false</code>
     * @since 0.1.0
     */
    public Boundary(Location3D corner1, Location3D corner2, boolean ignoreDifferentWorlds) {
        checkState(corner1 != null, "Boundary corner cannot be null");
        checkState(corner2 != null, "Boundary corner cannot be null");
        //noinspection ConstantConditions
        checkState(ignoreDifferentWorlds
                        || (!corner1.getWorld().isPresent() && !corner2.getWorld().isPresent())
                        || corner1.getWorld().get().equals(corner2.getWorld().get()),
                "Boundary corners cannot have mismatching worlds!");
        //noinspection ConstantConditions
        this.lowerBound = new Location3D(
                Math.min(corner1.getX(), corner2.getX()),
                Math.min(corner1.getY(), corner2.getY()),
                Math.min(corner1.getZ(), corner2.getZ())
        );
        this.upperBound = new Location3D(
                Math.max(corner1.getX(), corner2.getX()),
                Math.max(corner1.getY(), corner2.getY()),
                Math.max(corner1.getZ(), corner2.getZ())
        );
    }

    /**
     * Constructs a new {@link Boundary} from the given locations. These
     * locations should represent complimentary corners of a cuboid which will
     * be contained by the new {@link Boundary}.
     *
     * @param corner1 The first corner of the {@link Boundary}
     * @param corner2 The second corner of the {@link Boundary}
     * @throws IllegalArgumentException If one or both location parameters are
     *                                  <code>null</code>, or if the worlds
     *                                  containing the locations do not match
     * @since 0.1.0
     */
    public Boundary(Location3D corner1, Location3D corner2) {
        this(corner1, corner2, false);
    }

    /**
     * Gets the boundary lowest on all three axes.
     *
     * @return The boundary lowest on all three axes.
     * @since 0.1.0
     */
    public Location3D getLowerBound() {
        return this.lowerBound;
    }

    /**
     * Gets the boundary highest on all three axes.
     *
     * @return The boundary highest on all three axes.
     * @since 0.1.0
     */
    public Location3D getUpperBound() {
        return this.upperBound;
    }

}
