package net.caseif.flint.exception.rollback;

/**
 * An exception pertaining to a rollback-related action.
 *
 * @author Max Roncacé
 * @since 1.1
 */
public class RollbackException extends RuntimeException {

    /**
     * Creates a new {@link RollbackException} with the given cause.
     *
     * @param cause The {@link Exception} which caused this
     *     {@link RollbackException}
     * @since 1.1
     */
    public RollbackException(Exception cause) {
        super(cause);
    }

}
