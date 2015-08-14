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
package net.caseif.flint.minigame;

import net.caseif.flint.arena.Arena;
import net.caseif.flint.challenger.Challenger;
import net.caseif.flint.config.ConfigNode;
import net.caseif.flint.config.RoundConfigNode;
import net.caseif.flint.exception.OrphanedObjectException;
import net.caseif.flint.round.Round;
import net.caseif.flint.util.annotation.Orphaner;
import net.caseif.flint.util.physical.Boundary;
import net.caseif.flint.util.physical.Location3D;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;
import com.google.common.eventbus.EventBus;

import java.util.UUID;

/**
 * Represents a minigame registered with Flint.
 *
 * @author Max Roncacé
 * @since 1.0
 */
public interface Minigame {

    /**
     * Gets the name or ID of the plugin to which this {@link Minigame} belongs.
     *
     * @return The name or ID of the plugin to which this {@link Minigame}
     *     belongs.
     * @since 1.0
     */
    String getPlugin();

    /**
     * Gets this {@link Minigame}'s {@link EventBus}.
     *
     * @return This {@link Minigame}'s {@link EventBus}.
     * @since 1.0
     */
    EventBus getEventBus();

    /**
     * Gets the current value of the given {@link ConfigNode} for this
     * {@link Minigame}.
     *
     * <p>If {@code node} is an instance of a
     * {@link RoundConfigNode}, {@code value} will
     * be used as a default return value for
     * {@link Round#getConfigValue(RoundConfigNode)} when not set for an
     * individual {@link Round}.</p>
     *
     * @param node The {@link ConfigNode} to look up
     * @param <T> The value type associated with {@code node}
     * @return The value of {@code node} for this {@link Minigame}
     * @since 1.0
     */
    <T> T getConfigValue(ConfigNode<T> node);

    /**
     * Gets the current value of the given {@link ConfigNode} for this
     * {@link Minigame}.
     *
     * <p>If {@code node} is an instance of a
     * {@link RoundConfigNode}, {@code value} will
     * be used as a default return value for
     * {@link Round#getConfigValue(RoundConfigNode)} when not set for an
     * individual {@link Round}.</p>
     *
     * @param node The {@link ConfigNode} to look up
     * @param value The new value of {@code node} for this {@link Minigame}
     * @param <T> The value type associated with {@code node}
     * @since 1.0
     */
    <T> void setConfigValue(ConfigNode<T> node, T value);

    /**
     * Gets an {@link ImmutableSet} containing all {@link Arena}s owned by this
     * {@link Minigame}.
     *
     * @return An {@link ImmutableSet} containing all {@link Arena}s owned by
     *     this {@link Minigame}.
     * @since 1.0
     */
    ImmutableSet<Arena> getArenas();

    /**
     * Gets the {@link Arena} by the given ID within this {@link Minigame}.
     *
     * @param arenaId The ID of the {@link Arena} to get (will be converted to
     *     lowercase
     * @return The {@link Arena} by the given ID within this {@link Minigame}
     * @since 1.0
     */
    Optional<Arena> getArena(String arenaId);

    /**
     * Creates and stores a new {@link Arena} within this {@link Minigame} with
     * the given identifier, name, and initial spawn point.
     *
     * @param id The identifier of the new {@link Arena} (will be converted to
     *     lowercase)
     * @param name The "friendly" name of this {@link Arena} (i.e. the one
     *     displayed to users)
     * @param spawnPoint The initial spawn point for the new {@link Arena}
     * @param boundary The {@link Boundary} of the new {@link Arena}
     * @return The newly created {@link Arena}
     * @throws IllegalArgumentException If an {@link Arena} with the given
     *     identifier already exists, or if {@code spawnPoint} does not contain
     *     a world
     * @since 1.0
     */
    Arena createArena(String id, String name, Location3D spawnPoint, Boundary boundary) throws IllegalArgumentException;

    /**
     * Creates and stores a new {@link Arena} within this {@link Minigame} with
     * the given identifier and initial spawn point.
     *
     * @param id The identifier of the new {@link Arena} (will be converted to
     *     lowercase, although the display name will retain the original case)
     * @param spawnPoint The initial spawn point for the new {@link Arena}
     * @param boundary The {@link Boundary} of the new {@link Arena}
     * @return The newly created {@link Arena}
     * @throws IllegalArgumentException If an {@link Arena} with the given
     *     identifier already exists, or if {@code spawnPoint} does not contain
     *     a world
     * @since 1.0
     */
    Arena createArena(String id, Location3D spawnPoint, Boundary boundary) throws IllegalArgumentException;

    /**
     * Removes the {@link Arena} with the given ID from this {@link Minigame}.
     *
     * <p>Note that calling this method will orphan the {@link Arena} object
     * associated with the passed ID, causing all of its methods to throw
     * {@link OrphanedObjectException}s.</p>
     *
     * @param id The ID of the {@link Arena} to remove (will be converted to
     *     lowercase)
     * @throws IllegalArgumentException If an {@link Arena} with the given ID is
     *     not associated with this {@link Minigame}
     * @since 1.0
     */
    @Orphaner
    void removeArena(String id) throws IllegalArgumentException;

    /**
     * Removes the {@link Arena} with the given ID from this {@link Minigame}.
     *
     * <p>Note that calling this method will orphan the passed {@link Arena}
     * object, causing all of its methods to throw
     * {@link OrphanedObjectException}s.</p>
     *
     * @param arena The {@link Arena} to remove
     * @throws IllegalArgumentException If the given {@link Arena} has already
     *     been removed or is otherwise not associated with this
     *     {@link Minigame}
     * @since 1.0
     */
    @Orphaner
    void removeArena(Arena arena) throws IllegalArgumentException;

    /**
     * Gets an {@link ImmutableSet} containing all active {@link Round}s owned
     * by this {@link Minigame}.
     *
     * @return An {@link ImmutableSet} containing all active {@link Round}s
     *     owned by this {@link Minigame}.
     * @since 1.0
     */
    ImmutableSet<Round> getRounds();

    /**
     * Gets an immutable {@link ImmutableSet} containing all active {@link Challenger}s
     * owned by this {@link Minigame}.
     *
     * @return An immutable {@link ImmutableSet} containing all active
     *     {@link Challenger}s owned by this {@link Minigame}.
     * @since 1.0
     */
    ImmutableSet<Challenger> getChallengers();

    /**
     * Gets the {@link Challenger} by the given UUID.
     *
     * @param uuid The UUID to look up
     * @return The {@link Challenger} by the given UUID
     * @since 1.0
     */
    Optional<Challenger> getChallenger(UUID uuid);

}
