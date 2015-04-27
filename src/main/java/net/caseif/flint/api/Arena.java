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
package net.caseif.flint.api;

import net.caseif.flint.api.util.Metadatable;
import net.caseif.flint.api.util.physical.Boundary;
import net.caseif.flint.api.util.physical.Location3D;
import net.caseif.flint.api.round.Round;

import com.google.common.base.Optional;

import java.util.Set;

/**
 * Represents an arena in which rounds may take place.
 *
 * @author Max Roncacé
 * @since 1.0.0
 */
public interface Arena extends Metadatable {

    /**
     * Gets the internal ID of this {@link Arena}.
     *
     * @return The internal ID of this {@link Arena}
     * @since 1.0.0
     */
    String getId();

    /**
     * Gets the name of this {@link Arena} as displayed to users.
     *
     * @return The name of this {@link Arena} as displayed to users, or its ID
     *         if one is not set
     * @since 1.0.0
     */
    String getName();

    /**
     * Gets the name of the world which contains this {@link Arena}.
     *
     * @return The name of the world which contains this {@link Arena}
     * @since 1.0.0
     */
    String getWorld();

    /**
     * Gets the {@link Boundary} which this {@link Arena} is contained within.
     *
     * @return The {@link Boundary} which this {@link Arena} is contained
     *         within
     * @since 1.0.0
     */
    Optional<Boundary> getBoundary();

    /**
     * Returns an immutable {@link Set} of points at which players may spawn
     * upon entering this arena.
     *
     * @return An immutable {@link Set} of points at which players may spawn
     *         upon entering this arena
     * @since 1.0.0
     */
    Set<Location3D> getSpawnPoints();

    /**
     * Adds the given {@link Location3D} to this {@link Arena}'s possible
     * spawn points.
     *
     * @param spawn The {@link Location3D} to add as a new spawn point
     * @return The index of the new spawn point
     * @since 1.0.0
     */
    int addSpawnPoint(Location3D spawn);

    /**
     * Removes the spawn point of the given index from this {@link Arena}.
     *
     * @param index The index of the spawn point to remove
     * @throws IllegalArgumentException If a spawn point at the given index does
     *                                  not exist
     * @since 1.0.0
     */
    void removeSpawnPoint(int index);

    /**
     * Removes the spawn point at the given location from this {@link Arena}.
     *
     * @param location The location of the spawn point to remove
     * @throws IllegalArgumentException If a spawn point at the given location
     *                                  does not exist
     * @since 1.0.0
     */
    void removeSpawnPoint(Location3D location);

    /**
     * Gets whether this {@link Arena} contains an active round.
     *
     * @return Whether this {@link Arena} contains an active round
     * @since 1.0.0
     */
    boolean hasActiveRound();

    /**
     * Gets the {@link Round} contained by this {@link Arena}.
     *
     * @return The {@link Round} contained by this {@link Arena}
     * @since 1.0.0
     */
    Optional<Round> getRound();

}
