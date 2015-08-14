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
package net.caseif.flint.arena;

import net.caseif.flint.exception.OrphanedObjectException;
import net.caseif.flint.round.LifecycleStage;
import net.caseif.flint.round.Round;
import net.caseif.flint.metadata.Metadatable;
import net.caseif.flint.util.MinigameElement;
import net.caseif.flint.util.annotation.Orphanable;
import net.caseif.flint.util.physical.Boundary;
import net.caseif.flint.util.physical.Location3D;

import com.google.common.base.Optional;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableSet;

import java.util.LinkedHashSet;

/**
 * Represents an arena in which rounds may take place.
 *
 * @author Max Roncacé
 * @since 1.0
 */
@SuppressWarnings("DuplicateThrows")
@Orphanable
public interface Arena extends Metadatable, MinigameElement {

    /**
     * Gets the identifier of this {@link Arena}.
     *
     * @return The identifier of this {@link Arena}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    String getId() throws OrphanedObjectException;

    /**
     * Gets the "friendly" name of this {@link Arena}, as displayed to users.
     *
     * @return The "friendly" name of this {@link Arena}, as displayed to users,
     *     or its ID if one is not set
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    String getName() throws OrphanedObjectException;

    /**
     * Gets the name of the world which contains this {@link Arena}.
     *
     * @return The name of the world which contains this {@link Arena}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    String getWorld() throws OrphanedObjectException;

    /**
     * Gets the {@link Boundary} which this {@link Arena} is contained within.
     *
     * @return The {@link Boundary} which this {@link Arena} is contained
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     *     within
     * @since 1.0
     */
    Boundary getBoundary() throws OrphanedObjectException;

    /**
     * Sets the {@link Boundary} which this {@link Arena} is contained within.
     *
     * @param bound The new {@link Boundary} which this {@link Arena} is to be
     *     contained within
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    void setBoundary(Boundary bound) throws OrphanedObjectException;

    /**
     * Returns an immutable {@link BiMap} of points at which players may spawn
     * upon entering this arena, mapped to their respective IDs.
     *
     * @return An immutable {@link BiMap} of points at which players may spawn
     *     upon entering this arena, mapped to their respective IDs
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    ImmutableBiMap<Integer, Location3D> getSpawnPoints() throws OrphanedObjectException;

    /**
     * Adds the given {@link Location3D} to this {@link Arena}'s possible
     * spawn points.
     *
     * @param spawn The {@link Location3D} to add as a new spawn point
     * @return The index of the new spawn point
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    int addSpawnPoint(Location3D spawn) throws OrphanedObjectException;

    /**
     * Removes the spawn point of the given index from this {@link Arena}.
     *
     * @param index The index of the spawn point to remove
     * @throws IllegalArgumentException If a spawn point at the given index does
     *     not exist
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    void removeSpawnPoint(int index) throws OrphanedObjectException;

    /**
     * Removes the spawn point at the given location from this {@link Arena}.
     *
     * @param location The location of the spawn point to remove
     * @throws IllegalArgumentException If a spawn point at the given location
     *     does not exist
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    void removeSpawnPoint(Location3D location) throws OrphanedObjectException;

    /**
     * Gets the {@link Round} contained by this {@link Arena}.
     *
     * @return The {@link Round} contained by this {@link Arena}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    Optional<Round> getRound() throws OrphanedObjectException;

    /**
     * Creates a new {@link Round} in this {@link Arena}.
     *
     * @param stages A {@link LinkedHashSet} containing {@link LifecycleStage}s
     *               to define for the new {@link Round}
     * @return The newly created {@link Round}.
     * @throws IllegalArgumentException If {@code stages} contains an empty
     *     set
     * @throws IllegalStateException If a {@link Round} already exists in this
     *     {@link Arena}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    Round createRound(ImmutableSet<LifecycleStage> stages)
            throws IllegalArgumentException, IllegalStateException, OrphanedObjectException;

    /**
     * Creates a new {@link Round} in this {@link Arena} with the default
     * {@link LifecycleStage}s.
     *
     * @return The newly created {@link Round}.
     * @throws IllegalStateException If a {@link Round} already exists in this
     *     {@link Arena}, or if the default {@link LifecycleStage}s have not
     *     been set as a config option
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    Round createRound() throws IllegalStateException, OrphanedObjectException;

    /**
     * Rolls this {@link Arena}'s its state immediately prior to a {@link Round}
     * having been created in it.
     *
     * @throws IllegalStateException If no {@link Round} has taken place in this
     *     {@link Arena} since the last call to this method upon it
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    void rollback() throws IllegalStateException, OrphanedObjectException;

}
