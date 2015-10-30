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
package net.caseif.flint.exception.round;

import net.caseif.flint.component.Component;
import net.caseif.flint.component.exception.OrphanedComponentException;
import net.caseif.flint.round.Round;

import java.util.UUID;

/**
 * Thrown when a player fails to join a {@link Round}.
 *
 * @author Max Roncacé
 * @since 1.0
 * @deprecated Violates basic principle of exceptions
 */
@Deprecated
public abstract class RoundJoinException extends Throwable implements Component<Round> {

    private UUID player;
    private Round round;
    private Reason reason;

    /**
     * Gets the {@link Round} this {@link RoundJoinException} is owned by.
     *
     * <p><strong>Note:</strong> This a convenience method for
     * {@link RoundJoinException#getOwner()}.</p>
     *
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @return The {@link Round} this {@link RoundJoinException} is owned by
     * @since 1.0
     */
    public Round getRound() throws OrphanedComponentException {
        return getOwner();
    }

    /**
     * Creates a new {@link RoundJoinException} with
     * {@link Reason#INTERNAL_ERROR} and the given parameters.
     *
     * @param player The {@link UUID} of the player involved in this exception
     * @param round The {@link Round} involved in this exception
     * @param message The exception message
     * @param cause The {@link Throwable} which caused this exception
     * @since 1.0
     */
    protected RoundJoinException(UUID player, Round round, Throwable cause, String message) {
        super(message, cause);
        setFields(player, round, Reason.INTERNAL_ERROR);
    }

    /**
     * Creates a new {@link RoundJoinException} with
     * {@link Reason#INTERNAL_ERROR} and the given parameters.
     *
     * @param player The {@link UUID} of the player involved in this exception
     * @param round The {@link Round} involved in this exception
     * @param cause The {@link Throwable} which caused this exception
     * @since 1.0
     */
    protected RoundJoinException(UUID player, Round round, Throwable cause) {
        super(cause);
        setFields(player, round, Reason.INTERNAL_ERROR);
    }

    /**
     * Creates a new {@link RoundJoinException} with the given parameters.
     *
     * @param player The {@link UUID} of the player involved in this exception
     * @param round The {@link Round} involved in this exception
     * @param reason The {@link Reason} of the failure to join
     * @param message The exception message
     * @since 1.0
     */
    protected RoundJoinException(UUID player, Round round, Reason reason, String message) {
        super(message);
        setFields(player, round, reason);
    }

    protected void setFields(UUID player, Round round, Reason reason) {
        this.player = player;
        this.round = round;
        this.reason = reason;
    }

    /**
     * Gets the {@link UUID} of the player who failed to join.
     *
     * @return The {@link UUID} of the player who failed to join.
     * @since 1.0
     */
    public UUID getPlayer() {
        return this.player;
    }

    /**
     * Gets the {@link Reason} of the failure to join.
     *
     * @return The {@link Reason} of the failure to join
     * @since 1.0
     */
    public Reason getReason() {
        return this.reason;
    }

    /**
     * Gets the {@link Round} owning this object.
     *
     * @return The {@link Round} owning this object
     */
    @Override
    public Round getOwner() {
        return this.round;
    }

    /**
     * Represents a specific reason for a player failing to join a {@link Round}.
     *
     * @since 1.0
     */
    public enum Reason {
        /**
         * A failed join due to the player already being present in a
         * {@link Round}.
         *
         * @since 1.0
         */
        ALREADY_ENTERED,
        /**
         * A failed join due to the round being at capacity.
         *
         * @since 1.0
         */
        FULL,
        /**
         * A failed join due to an internal error.
         *
         * @since 1.0
         */
        INTERNAL_ERROR,
        /**
         * A failed join due to the player being offline.
         *
         * @since 1.0
         */
        OFFLINE
    }

}
