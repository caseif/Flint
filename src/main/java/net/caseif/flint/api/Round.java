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

import net.caseif.flint.api.feedback.JoinResult;

import java.util.Set;

/**
 * Represents an active minigame {@link Round} backed by Flint.
 *
 * @author Max Roncacé
 * @since 0.1.0
 */
public interface Round {

    /**
     * Gets the {@link Arena} which contains this {@link Round}.
     *
     * @return The {@link Arena} which contains this {@link Round}
     * @since 0.1.0
     */
    Arena getArena();

    /**
     * Returns an immutable {@link Set} of {@link Player}s in this
     * {@link Round}.
     * @return An immutable {@link Set} of {@link Player}s in this
     * {@link Round}
     * @since 0.1.0
     */
    Set<Player> getPlayers();

    /**
     * Adds the given {@link Player} to this {@link Round}.
     *
     * @param player The player to add to this {@link Round}
     * @return The result of the player joining the round
     * @since 0.1.0
     */
    JoinResult addPlayer(Player player);

    /**
     * Removes the given player from this {@link Round}.
     *
     * @param player The player to remove from this {@link Round}
     * @since 0.1.0
     */
    void removePlayer(Player player);

    /**
     * Gets the current state of this {@link Round}'s timer in seconds.
     *
     * <p>Typically, this represents the time since its last lifecycle stage
     * change, although this is not absolute.</p>
     *
     * @return The current state of this {@link Round}'s timer in seconds
     * @since 0.1.0
     */
    int getTime();

    /**
     * Sets the current state of this {@link Round}'s timer in seconds.
     *
     * @param time The current state of this {@link Round}'s timer in seconds
     * @since 0.1.0
     */
    void setTime(int time);

    /**
     * Gets the time in seconds until this {@link Round} is due to change
     * its lifecycle stage.
     *
     * @return The time in seconds until this {@link Round} is due to change
     * its lifecycle stage, or <code>-1</code> if the current stage is untimed.
     * @since 0.1.0
     */
    int getRemainingTime();

    /**
     * Starts this {@link Round}'s timer in its current state.
     *
     * @since 0.1.0
     */
    void startTimer();

    /**
     * Stops this {@link Round}'s timer. Note that this does not end the round.
     *
     * @since 0.1.0
     */
    void stopTimer();

    /**
     * Sets this {@link Round}'s lifecycle stage to its initial state and resets
     * and stops the timer.
     *
     * @since 0.1.0
     */
    void reset();

    /**
     * Ends this round by rolling back its arena and removing all players.
     *
     * @since 0.1.0
     */
    void end();

}
