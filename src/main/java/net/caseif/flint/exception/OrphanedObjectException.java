package net.caseif.flint.exception;

/**
 * Thrown in response to invocation of a method upon an
 * {@link Orphanable orphaned} object
 *
 * @author Max Roncacé
 * @since 1.0
 */
public class OrphanedObjectException extends IllegalStateException {

    /**
     * Constructs a new {@link OrphanedObjectException}.
     *
     * @since 1.0
     */
    public OrphanedObjectException() {
        this(null);
    }

    /**
     * Constructs a new {@link OrphanedObjectException} with the given
     * {@link Object} as the subject.
     *
     * @param orphan The subject of the exception
     * @since 1.0
     */
    public OrphanedObjectException(Object orphan) {
        super("Cannot invoke method upon orphaned object"
                + (orphan != null ? " of type " + orphan.getClass().getCanonicalName() : ""));
    }

    private OrphanedObjectException(String message) {
    }

}
