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
        ALREADY_ENTERED("Cannot enter challenger %s (already in a round)"),
        /**
         * A failed join due to the round being at capacity.
         *
         * @since 1.0
         */
        FULL("Cannot enter challenger %s (round is full)"),
        /**
         * A failed join due to an internal error.
         *
         * @since 1.0
         */
        INTERNAL_ERROR(""),
        /**
         * A failed join due to the player being offline.
         *
         * @since 1.0
         */
        OFFLINE("Cannot enter challenger with UUID %s (player is offline)");

        private String message;

        Reason(String message) {
            this.message = message;
        }

        /**
         * Returns the default message associated with this failure
         * {@link Reason}.
         *
         * @return The default message associated with this failure
         *     {@link Reason}.
         * @since 1.1
         */
        public String getMessage() {
            return message;
        }
    }

}
