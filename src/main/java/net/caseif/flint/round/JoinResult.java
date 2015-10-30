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
