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
package net.caseif.flint.round;

import net.caseif.flint.arena.Arena;
import net.caseif.flint.challenger.Challenger;
import net.caseif.flint.challenger.Team;
import net.caseif.flint.config.RoundConfigNode;
import net.caseif.flint.exception.OrphanedObjectException;
import net.caseif.flint.exception.round.RoundJoinException;
import net.caseif.flint.metadata.Metadatable;
import net.caseif.flint.util.MinigameElement;
import net.caseif.flint.util.annotation.Orphanable;
import net.caseif.flint.util.annotation.Orphaner;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.util.UUID;

/**
 * Represents an active minigame {@link Round} backed by Flint.
 *
 * @author Max Roncacé
 * @since 1.0
 */
@SuppressWarnings("DuplicateThrows")
@Orphanable
public interface Round extends Metadatable, MinigameElement {

    /**
     * Gets the {@link Arena} which contains this {@link Round}.
     *
     * @return The {@link Arena} which contains this {@link Round}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    Arena getArena() throws OrphanedObjectException;

    /**
     * Returns an {@link ImmutableList} of {@link Challenger}s in this
     * {@link Round}.
     *
     * @return An {@link ImmutableList} of {@link Challenger}s in this
     * {@link Round}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    ImmutableList<Challenger> getChallengers() throws OrphanedObjectException;

    /**
     * Gets the {@link Challenger} from this {@link Round} with the given
     * {@link UUID}.
     *
     * @param uuid The {@link UUID} to look up
     * @return The {@link Challenger} from this {@link Round} with the given
     *         {@link UUID}.
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    Optional<Challenger> getChallenger(UUID uuid) throws OrphanedObjectException;

    /**
     * Adds the player by the given {@link UUID} to this {@link Round}.
     *
     * @param uuid The unique ID of the player to add to this {@link Round}
     * @return The newly created {@link Challenger} object
     * @throws RoundJoinException If the player fails to be added to the
     *     {@link Round} for any given reason (obtainable through
     *     {@link RoundJoinException#getReason()})
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    Challenger addChallenger(UUID uuid) throws RoundJoinException, OrphanedObjectException;

    /**
     * Removes the player by the given {@link UUID} from this {@link Round}.
     *
     * <p>Note that this will orphan the {@link Challenger} object associated
     * with the given {@link UUID}, causing all of its methods to throw
     * {@link OrphanedObjectException}s.</p>
     *
     * @param uuid The {@link UUID} of the player to remove
     * @throws IllegalArgumentException If this {@link Round} does not contain a
     *     player by the given {@link UUID}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    @Orphaner
    void removeChallenger(UUID uuid) throws IllegalArgumentException, OrphanedObjectException;

    /**
     * Removes the given {@link Challenger} from this {@link Round}, returning
     * them to their original location before joining.
     *
     * <p>Note that this will orphan the passed {@link Challenger} object,
     * causing all of its methods to throw {@link OrphanedObjectException}s.</p>
     *
     * @param challenger The {@link Challenger} to remove
     * @throws IllegalArgumentException If this {@link Round} is not the one
     *     containing {@code challenger}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    @Orphaner
    void removeChallenger(Challenger challenger) throws IllegalArgumentException, OrphanedObjectException;

    /**
     * Returns an {@link ImmutableList} of {@link Team}s in this {@link Round}.
     *
     * @return An {@link ImmutableList} of {@link Team}s in this {@link Round}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    ImmutableList<Team> getTeams() throws OrphanedObjectException;

    /**
     * Gets the {@link Team} from this {@link Round} with the given identifier.
     *
     * @param id The identifier to look up
     * @return The {@link Team} with the given identifier
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    Optional<Team> getTeam(String id) throws OrphanedObjectException;

    /**
     * Creates a {@link Team} in this {@link Round} with the given identifer.
     *
     * @param id The identifier of the new {@link Team}
     * @return The newly created {@link Team}.
     * @throws IllegalArgumentException If a {@link Team} with the given
     *     identifer already exists
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    Team createTeam(String id) throws IllegalArgumentException, OrphanedObjectException;

    /**
     * Gets the {@link Team} from this {@link Round} with the given identifer,
     * or creates it if it does not already exist.
     *
     * @param id The identifier to look up
     * @return The fetched or newly created {@link Team}.
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    Team getOrCreateTeam(String id) throws OrphanedObjectException;

    /**
     * Removes the {@link Team} with the given identifier from this
     * {@link Round}.
     *
     * <p>Note that calling this method will orphan the {@link Team} object
     * associated with the given ID, causing all of its methods to throw
     * {@link OrphanedObjectException}s.</p>
     *
     * @param id The identifier of the {@link Team} to remove
     * @throws IllegalArgumentException If this {@link Round} does not contain
     *     a {@link Team} by the given ID
     */
    @Orphaner
    void removeTeam(String id) throws IllegalArgumentException, OrphanedObjectException;

    /**
     * Removes the given {@link Team} from this {@link Round}.
     *
     * <p>Note that calling this method will orphan the passed {@link Team}
     * object, causing all of its methods to throw
     * {@link OrphanedObjectException}s.</p>
     *
     * @param team The {@link Team} to remove
     * @throws IllegalArgumentException If the given {@link Team} object is
     *     parented by a different {@link Round} or has already been removed
     *     from this one
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     */
    @Orphaner
    void removeTeam(Team team) throws IllegalArgumentException, OrphanedObjectException;

    /**
     * Returns the number of {@link Challenger}s in this {@link Round} marked as
     * spectating.
     *
     * @return The number of {@link Challenger}s in this {@link Round} marked as
     *     spectating
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    int getSpectatorCount() throws OrphanedObjectException;

    /**
     * Broadcasts the string {@code message} to all {@link Challenger}s in
     * this {@link Round}.
     *
     * @param message The string to broadcast
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    void broadcast(String message) throws OrphanedObjectException;

    /**
     * Gets an immutable {@link ImmutableSet} of this {@link Round}'s defined
     * lifecycle stages.
     *
     * @return This {@link Round}'s defined lifecycle stages
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    ImmutableSet<LifecycleStage> getLifecycleStages() throws OrphanedObjectException;

    /**
     * Gets this {@link Round}'s current {@link LifecycleStage}.
     *
     * @return This {@link Round}'s current {@link LifecycleStage}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    LifecycleStage getLifecycleStage() throws OrphanedObjectException;

    /**
     * Sets this {@link Round}'s current {@link LifecycleStage}.
     *
     * @param stage The new {@link LifecycleStage} for the {@link Round}
     * @throws IllegalArgumentException If {@code stage} is not defined for
     *     this {@link Round}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    void setLifecycleStage(LifecycleStage stage) throws IllegalArgumentException, OrphanedObjectException;

    /**
     * Gets the {@link LifecycleStage} by the given ID in this {@link Round}.
     *
     * @param id The ID of the {@link LifecycleStage} to get
     * @return The {@link LifecycleStage} by the given ID in this {@link Round},
     *     or {@link Optional#absent()} if one does not exist
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    Optional<LifecycleStage> getLifecycleStage(String id) throws OrphanedObjectException;

    /**
     * Gets the {@link LifecycleStage} at the given index for this
     * {@link Round}.
     *
     * @param index The index of the {@link LifecycleStage} to get
     * @return The {@link LifecycleStage} at the given index
     * @throws IndexOutOfBoundsException If {@code index} is greater than
     *     the highest defined index
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    LifecycleStage getLifecycleStage(int index) throws IndexOutOfBoundsException, OrphanedObjectException;

    /**
     * Gets this {@link Round}'s next {@link LifecycleStage}, if applicable.
     *
     * @return This {@link Round}'s next {@link LifecycleStage}, or
     *     {@link Optional#absent()} if the current stage is the final defined
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    Optional<LifecycleStage> getNextLifecycleStage() throws OrphanedObjectException;

    /**
     * Progresses this {@link Round} to its next {@link LifecycleStage}.
     *
     * @throws IllegalStateException If the current {@link LifecycleStage} is
     *     the last one defined
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    void nextLifecycleStage() throws IllegalStateException, OrphanedObjectException;

    /**
     * Gets the current state of this {@link Round}'s timer in seconds.
     *
     * <p>Typically, this represents the time since its last lifecycle stage
     * change, although this is not absolute.</p>
     *
     * @return The current state of this {@link Round}'s timer in seconds
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    long getTime() throws OrphanedObjectException;

    /**
     * Sets the current state of this {@link Round}'s timer in seconds.
     *
     * @param time The current state of this {@link Round}'s timer in seconds
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    void setTime(long time) throws OrphanedObjectException;

    /**
     * Gets the time in seconds until this {@link Round} is due to change
     * its {@link LifecycleStage lifecycle stage}.
     *
     * @return The time in seconds until this {@link Round} is due to change
     *     its {@link LifecycleStage lifecycle stage}, or {@code -1} if the
     *     current stage is untimed
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    long getRemainingTime() throws OrphanedObjectException;

    /**
     * Returns whether this {@link Round}'s timer is currently ticking.
     *
     * @return Whether this {@link Round}'s timer is currently ticking
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    boolean isTimerTicking() throws OrphanedObjectException;

    /**
     * Sets whether this {@link Round}'s timer is currently ticking.
     *
     * @param ticking Whether this {@link Round}'s timer is currently ticking
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    void setTimerTicking(boolean ticking) throws OrphanedObjectException;

    /**
     * Sets this {@link Round}'s lifecycle stage to its initial state and resets
     * and stops the timer.
     *
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    void resetTimer() throws OrphanedObjectException;

    /**
     * Ends this {@link Round} by resetting its timer, removing all
     * {@link Challenger}s and returning them to their original locations, and
     * rolling back its arena.
     *
     * <p>Note that calling this method will orphan this {@link Round} object,
     * causing all of its methods to throw {@link OrphanedObjectException}s.</p>
     *
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    @Orphaner
    void end() throws OrphanedObjectException;

    /**
     * Ends this {@link Round} by resetting its timer, removing all
     * {@link Challenger}s and returning them to thieir original locations, and,
     * if {@code rollback} is {@code true}, rolling back its arena.
     *
     * <p>Note that calling this method will orphan this {@link Round} object,
     * causing all of its methods to throw {@link OrphanedObjectException}s.</p>
     *
     * @param rollback Whether this {@link Round}'s arena should be rolled back
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    @Orphaner
    void end(boolean rollback) throws OrphanedObjectException;

    /**
     * Gets the value of the given {@link RoundConfigNode} for this
     * {@link Round}, or the server value if it is not set.
     *
     * @param node The {@link RoundConfigNode} to look up
     * @param <T> The value type associated with {@code node}
     * @return The value associated with {@code node}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    <T> T getConfigValue(RoundConfigNode<T> node) throws OrphanedObjectException;

    /**
     * Sets the value of the given {@link RoundConfigNode} for this
     * {@link Round}.
     *
     * @param node The {@link RoundConfigNode} to set
     * @param value The new value associated with {@code node}
     * @param <T> The value type associated with {@code node}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    <T> void setConfigValue(RoundConfigNode<T> node, T value) throws OrphanedObjectException;

}
