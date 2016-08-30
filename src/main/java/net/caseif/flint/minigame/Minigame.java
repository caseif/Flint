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
package net.caseif.flint.minigame;

import net.caseif.flint.arena.Arena;
import net.caseif.flint.challenger.Challenger;
import net.caseif.flint.component.ComponentOwner;
import net.caseif.flint.config.ConfigNode;
import net.caseif.flint.config.RoundConfigNode;
import net.caseif.flint.component.exception.OrphanedComponentException;
import net.caseif.flint.round.Round;
import net.caseif.flint.util.annotation.Orphaner;
import net.caseif.flint.util.builder.Buildable;
import net.caseif.flint.util.builder.Builder;
import net.caseif.flint.util.physical.Boundary;
import net.caseif.flint.util.physical.Location3D;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.eventbus.EventBus;

import java.util.UUID;

/**
 * Represents a minigame registered with Flint.
 *
 * @author Max Roncacé
 * @since 1.0
 */
public interface Minigame extends ComponentOwner {

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
    ImmutableList<Arena> getArenas();

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
     *     identifier already exists, if {@code spawnPoint} does not contain a
     *     world, or if the ID or name contain characters not permitted by the
     *     implementation
     * @deprecated Use an {@link Arena.Builder arena builder} instead (see
     *     {@link #createBuilder(Class)})
     * @since 1.0
     */
    @Deprecated
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
     *     identifier already exists, if {@code spawnPoint} does not contain a
     *     world, or if the id or name contain characters not permitted by the
     *     implementation
     * @deprecated Use an {@link Arena.Builder arena builder} instead (see
     *     {@link #createBuilder(Class)})
     * @since 1.0
     */
    @Deprecated
    Arena createArena(String id, Location3D spawnPoint, Boundary boundary) throws IllegalArgumentException;

    /**
     * Removes the {@link Arena} with the given ID from this {@link Minigame}.
     *
     * <p>Note that calling this method will orphan the {@link Arena} object
     * associated with the passed ID, causing all of its methods to throw
     * {@link OrphanedComponentException}s.</p>
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
     * {@link OrphanedComponentException}s.</p>
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
     * Gets an {@link ImmutableList} containing all active {@link Round}s owned
     * by this {@link Minigame}.
     *
     * @return An {@link ImmutableList} containing all active {@link Round}s
     *     owned by this {@link Minigame}.
     * @since 1.0
     */
    ImmutableList<Round> getRounds();

    /**
     * Gets an {@link ImmutableList} containing all active {@link Challenger}s
     * owned by this {@link Minigame}.
     *
     * @return An immutable {@link ImmutableList} containing all active
     *     {@link Challenger}s owned by this {@link Minigame}.
     * @since 1.0
     */
    ImmutableList<Challenger> getChallengers();

    /**
     * Gets the {@link Challenger} by the given UUID.
     *
     * @param uuid The UUID to look up
     * @return The {@link Challenger} by the given UUID
     * @since 1.0
     */
    Optional<Challenger> getChallenger(UUID uuid);

    /**
     * Creates a new builder for the given class type.
     *
     * @param type The type to create a {@link Builder} for
     * @param <T> The type associated with the requested {@link Builder}
     * @param <U> The {@link Builder}'s type
     * @return A new builder for the given class type
     * @throws UnsupportedOperationException If the provided class does not have
     *     a builder registration
     * @since 1.3
     */
    <T extends Buildable<U>, U extends Builder<T>> U createBuilder(Class<T> type);

}
