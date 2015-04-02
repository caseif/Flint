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
package net.caseif.flint.api;

import net.caseif.flint.api.physical.Boundary;
import net.caseif.flint.api.physical.Location3D;

import java.util.Optional;
import java.util.Set;

/**
 * Represents an arena in which rounds may take place.
 *
 * @author Max Roncacé
 * @since 0.1.0
 */
public interface Arena {

    /**
     * Gets the internal ID of this {@link Arena}.
     *
     * @return The internal ID of this {@link Arena}
     * @since 0.1.0
     */
    String getId();

    /**
     * Gets the name of this {@link Arena} as displayed to users.
     * @return The name of this {@link Arena} as displayed to users, or its ID
     *         if one is not set
     * @since 0.1.0
     */
    String getName();

    /**
     * Gets the name of the world which contains this {@link Arena}.
     * @return The name of the world which contains this {@link Arena}
     * @since 0.1.0
     */
    String getWorld();

    /**
     * Gets the {@link Boundary} which this {@link Arena} is contained within.
     *
     * @return The {@link Boundary} which this {@link Arena} is contained
     *         within
     * @since 0.1.0
     */
    Optional<Boundary> getBoundary();

    /**
     * Returns an immutable {@link Set} of points at which players may spawn
     * upon entering this arena.
     * @return An immutable {@link Set} of points at which players may spawn
     *         upon entering this arena
     * @since 0.1.0
     */
    Set<Location3D> getSpawnPoints();

    /**
     * Adds the given {@link Location3D} to this {@link Arena}'s possible
     * spawn points.
     *
     * @param spawn The {@link Location3D} to add as a new spawn point
     * @return The index of the new spawn point
     * @since 0.1.0
     */
    int addSpawnPoint(Location3D spawn);

    /**
     * Removes the spawn point of the given index from this {@link Arena}.
     *
     * @param index The index of the spawn point to remove
     * @throws IllegalArgumentException If a spawn point at the given index does
     *                                  not exist
     * @since 0.1.0
     */
    void removeSpawnPoint(int index);

    /**
     * Removes the spawn point at the given location from this {@link Arena}.
     *
     * @param location The location of the spawn point to remove
     * @throws IllegalArgumentException If a spawn point at the given location
     *                                  does not exist
     * @since 0.1.0
     */
    void removeSpawnPoint(Location3D location);

    /**
     * Gets whether this {@link Arena} contains an active round.
     *
     * @return Whether this {@link Arena} contains an active round
     * @since 0.1.0
     */
    boolean hasActiveRound();

    /**
     * Gets the {@link Round} contained by this {@link Arena}.
     *
     * @return The {@link Round} contained by this {@link Arena}
     * @since 0.1.0
     */
    Optional<Round> getRound();

}
