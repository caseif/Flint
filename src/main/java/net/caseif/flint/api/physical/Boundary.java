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
    public Boundary(Location3D corner1, Location3D corner2, boolean ignoreDifferentWorlds)
            throws IllegalArgumentException {
        checkState(corner1 != null, "Boundary corner cannot be null");
        checkState(corner2 != null, "Boundary corner cannot be null");
        //noinspection ConstantConditions
        checkState(ignoreDifferentWorlds
                        || (!corner1.getWorld().isPresent() && !corner2.getWorld().isPresent())
                        || corner1.getWorld().get().equals(corner2.getWorld().get()),
                "Boundary corners cannot have mismatching worlds");
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
    public Boundary(Location3D corner1, Location3D corner2) throws IllegalArgumentException {
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

    /**
     * Returns whether this {@link Boundary} contains the given location
     * (inclusively).
     *
     * @param location The {@link Location3D} to check against this
     *                 {@link Boundary}
     * @return Whether this {@link Boundary} contains the given location
     *         (inclusively)
     * @since 0.1.0
     */
    public boolean contains(Location3D location) {
        return     location.getX() >= getLowerBound().getX() && location.getX() <= getUpperBound().getX()
                && location.getY() >= getLowerBound().getY() && location.getY() <= getUpperBound().getY()
                && location.getZ() >= getLowerBound().getZ() && location.getZ() <= getUpperBound().getZ();
    }

}
