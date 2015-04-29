package net.caseif.flint.exception.round;

import net.caseif.flint.round.Round;

import java.util.UUID;

/**
 * Thrown when a player fails to join a {@link Round}.
 *
 * @author Max Roncacé
 * @since 1.0.0
 */
public class RoundJoinException extends Throwable {

    private UUID player;
    private Round round;
    private Reason reason;
    private String message;

    /**
     * Creates a new {@link RoundJoinException} with the given parameters.
     *
     * @param player The {@link UUID} of the player involved in this exception
     * @param round The {@link Round} involved in this exception
     * @param reason The {@link Reason} of the failure to join
     * @param message The exception message
     * @since 1.0.0
     */
    public RoundJoinException(UUID player, Round round, Reason reason, String message) {
        this.player = player;
        this.round = round;
        this.reason = reason;
        this.message = message;
    }

    /**
     * Gets the {@link UUID} of the player who failed to join.
     *
     * @return The {@link UUID} of the player who failed to join.
     * @since 1.0.0
     */
    public UUID getPlayer() {
        return this.player;
    }

    /**
     * Gets the {@link Round} the player failed to join.
     *
     * @return The {@link Round} the player failed to join.
     * @since 1.0.0
     */
    public Round getRound() {
        return this.round;
    }

    /**
     * Gets the {@link Reason} of the failure to join.
     *
     * @return The {@link Reason} of the failure to join
     * @since 1.0.0
     */
    public Reason getReason() {
        return this.reason;
    }

    /**
     * Gets the exception message.
     *
     * @return The exception message.
     * @since 1.0.0
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Represents a specific reason for a player failing to join a {@link Round}.
     *
     * @since 1.0.0
     */
    enum Reason {
        /**
         * A failed join due to the round being at capacity.
         *
         * @since 1.0.0
         */
        FULL,
        /**
         * A failed join due to the respective event being cancelled.
         *
         * @since 1.0.0
         */
        CANCELLED,
        /**
         * A failed join due to an internal error.
         *
         * @since 1.0.0
         */
        INTERNAL_ERROR
    }

}
