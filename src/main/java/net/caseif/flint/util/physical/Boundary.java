/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015-2016, Max Roncace <me@caseif.net>
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

import static com.google.common.base.Preconditions.checkState;

/**
 * Represents a three-dimensional, cuboid boundary in the world.
 *
 * <p>This may be compared to vanilla Minecraft's world border.</p>
 *
 * @author Max Roncace
 * @since 1.0
 */
public class Boundary {

    /**
     * Represents a {@link Boundary} which extends infinitely along all
     * dimensions.
     *
     * @since 1.0
     */
    public static final Boundary INFINITE = new Boundary(
            new Location3D(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY),
            new Location3D(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)
    );

    private final String world;
    private final Location3D lowerBound;
    private final Location3D upperBound;

    /**
     * Constructs a new {@link Boundary} from the given locations. These
     * locations should represent complimentary corners of a cuboid which will
     * be contained by the new {@link Boundary}.
     *
     * @param corner1 The first corner of the {@link Boundary}
     * @param corner2 The second corner of the {@link Boundary}
     * @throws IllegalArgumentException If one or both location parameters are
     *     {@code null}, or if the worlds containing the locations do not
     *     match and {@code ignoreDifferentWorlds} is {@code false}
     * @since 1.0
     */
    public Boundary(Location3D corner1, Location3D corner2) throws IllegalArgumentException {
        checkState(corner1 != null, "Boundary corner cannot be null");
        checkState(corner2 != null, "Boundary corner cannot be null");
        //noinspection ConstantConditions
        checkState(!(corner1.getWorld().isPresent() && corner2.getWorld().isPresent()
                        && !corner1.getWorld().get().equals(corner2.getWorld().get())),
                "Boundary corners cannot have mismatching worlds");

        if (corner1.getWorld().isPresent()) {
            world = corner1.getWorld().get();
        } else if (corner2.getWorld().isPresent()) {
            world = corner2.getWorld().get();
        } else {
            world = null;
        }

        //noinspection ConstantConditions
        this.lowerBound = new Location3D(
                world,
                Math.min(corner1.getX(), corner2.getX()),
                Math.min(corner1.getY(), corner2.getY()),
                Math.min(corner1.getZ(), corner2.getZ())
        );
        this.upperBound = new Location3D(
                world,
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
     * @param ignoreDifferentWorlds Whether to skip a sanity check of whether
     *     the two locations are within the same world
     * @throws IllegalArgumentException If one or both location parameters are
     *     {@code null}, or if the worlds containing the locations do not
     *     match and {@code ignoreDifferentWorlds} is {@code false}
     * @since 1.0
     * @deprecated As of Flint 1.1, the sanity check is performed regardless of
     *     the boolean flag, rendering it obsolete
     */
    @Deprecated
    public Boundary(Location3D corner1, Location3D corner2, boolean ignoreDifferentWorlds)
            throws IllegalArgumentException {
        this(corner1, corner2);
    }

    /**
     * Gets the boundary lowest on all three axes.
     *
     * @return The boundary lowest on all three axes.
     * @since 1.0
     */
    public Location3D getLowerBound() {
        return this.lowerBound;
    }

    /**
     * Gets the boundary highest on all three axes.
     *
     * @return The boundary highest on all three axes.
     * @since 1.0
     */
    public Location3D getUpperBound() {
        return this.upperBound;
    }

    /**
     * Returns whether this {@link Boundary} contains the given location
     * (inclusively).
     *
     * <p>This will always return false if both this {@link Boundary} and the
     * provided location contain a world, but the worlds do not match.</p>
     *
     * @param location The {@link Location3D} to check against this
     *     {@link Boundary}
     * @return Whether this {@link Boundary} contains the given location
     *     (inclusively)
     * @since 1.0
     */
    public boolean contains(Location3D location) {
        // IntelliJ wants to simplify this method to a single statement. Yeah, in your dreams.
        //noinspection SimplifiableIfStatement
        if (world != null && location.getWorld().isPresent() && !world.equals(location.getWorld().get())) {
            return false;
        }
        return     location.getX() >= getLowerBound().getX() && location.getX() <= getUpperBound().getX()
                && location.getY() >= getLowerBound().getY() && location.getY() <= getUpperBound().getY()
                && location.getZ() >= getLowerBound().getZ() && location.getZ() <= getUpperBound().getZ();
    }

}
