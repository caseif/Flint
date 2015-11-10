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

import net.caseif.flint.challenger.Challenger;

/**
 * Represents the result of a {@link Challenger} attempting to join a round.
 *
 * @author Max Roncacé
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
     * @author Max Roncacé
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
