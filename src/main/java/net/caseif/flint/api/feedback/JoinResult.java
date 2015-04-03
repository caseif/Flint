package net.caseif.flint.api.feedback;

/**
 * Defines the end result of a player attempting to join a round.
 *
 * @author Max Roncacé
 * @since 0.1.0
 */
public enum JoinResult {

    /**
     * A successful round join.
     *
     * @since 0.1.0
     */
    SUCCESS,
    /**
     * A failed join due to the round being at capacity.
     *
     * @since 0.1.0
     */
    FULL,
    /**
     * A failed join due to the respective event being cancelled.
     *
     * @since 0.1.0
     */
    CANCELLED,
    /**
     * A failed join due to an internal error.
     *
     * @since 0.1.0
     */
    INTERNAL_ERROR

}
