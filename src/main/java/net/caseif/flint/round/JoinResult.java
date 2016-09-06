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

package net.caseif.flint.round;

import net.caseif.flint.challenger.Challenger;

/**
 * Represents the result of a {@link Challenger} attempting to join a round.
 *
 * @author Max Roncace
 * @since 1.1
 */
public interface JoinResult {

    /**
     * Returns the new {@link Challenger} object created by the join event.
     *
     * @return The new {@link Challenger} object created by the join event
     * @throws IllegalStateException If {@link JoinResult#getStatus} returns
     *     anything other than {@link Status#SUCCESS}
     * @since 1.1
     */
    Challenger getChallenger() throws IllegalStateException;

    /**
     * Returns the {@link Status} of this {@link JoinResult}.
     *
     * @return The {@link Status} of this {@link JoinResult}
     * @since 1.1
     */
    Status getStatus();

    /**
     * Returns the {@link Throwable} which caused an
     * {@link Status#INTERNAL_ERROR INTERNAL_ERROR} status.
     *
     * @return The {@link Throwable} which caused an
     *     {@link Status#INTERNAL_ERROR INTERNAL_ERROR} status.
     * @throws IllegalStateException If {@link JoinResult#getStatus} returns
     *     anything other than {@link Status#SUCCESS}
     * @since 1.1
     */
    Throwable getThrowable() throws IllegalStateException;

    /**
     * Represents a specific reason for a player failing to join a {@link Round}.
     *
     * @author Max Roncace
     * @since 1.1
     */
    enum Status {
        /**
         * A successful join.
         *
         * @since 1.1
         */
        SUCCESS,
        /**
         * A failed join due to the player already being present in a
         * {@link Round}.
         *
         * @since 1.1
         */
        ALREADY_IN_ROUND,
        /**
         * A failed join due to the round being at capacity.
         *
         * @since 1.1
         */
        ROUND_FULL,
        /**
         * A failed join due to an internal error.
         *
         * @since 1.1
         */
        INTERNAL_ERROR,
        /**
         * A failed join due to the player being offline.
         *
         * @since 1.1
         */
        PLAYER_OFFLINE
    }

}
