package net.caseif.flint.api.util;

import java.util.Set;

/**
 * Represents an object which may carry metadata.
 *
 * @author Max Roncacé
 * @since 1.0.0
 */
public interface Metadatable {

    /**
     * Gets whether this {@link Metadatable} instanceof contains metadata with
     * the given key.
     *
     * @param key The key to search for
     * @return Whether this {@link Metadatable} instanceof contains metadata
     *         with the given key
     * @since 1.0.0
     */
    boolean hasMetadata(String key);

    /**
     * Gets the value of the metadata with the given key.
     *
     * @param key The key of the metadata value to retrieve
     * @return The value of the metadata with the given key, or
     *         <code>null</code> if the key is not defined
     * @since 1.0.0
     */
    Object getMetadata(String key);

    /**
     * Assigns the given value to the metadata with the given key, or clears it
     * if <code>value</code> is <code>null</code>.
     *
     * @param key The name of the metadata key to set
     * @param value The value to assign to the metadata key
     * @since 1.0.0
     */
    void setMetadata(String key, Object value);

    /**
     * Removes the metadata with the given key from this {@link Metadatable}
     * instance.
     *
     * <p>This is a convenience method for
     * <code>setMetadata(key, null)</code></p>
     *
     * @param key The key of the metadata value to remove
     * @since 1.0.0
     */
    void removeMetadata(String key);

    /**
     * Returns an immutable {@link Set} of all metadata keys carried by this
     * {@link Metadatable} instance.
     *
     * @return An immutable {@link Set} of all metadata keys carried by this
     *         {@link Metadatable} instance
     * @since 1.0.0
     */
    Set<String> getAllMetadata();

}
