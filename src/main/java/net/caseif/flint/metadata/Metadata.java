package net.caseif.flint.metadata;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;

/**
 * Represents a set of data associated with a {@link Metadatable} instance.
 *
 * @author Max Roncacé
 * @since 1.0
 */
public interface Metadata {

    /**
     * Gets the value assigned to the given key.
     *
     * @param key The key of the value to retrieve
     * @param <T> The type of data associated with the given key
     * @return The value assigned to the given key, or {@link Optional#absent()}
     *     if the key is not defined
     * @throws ClassCastException If the value associated with the given key is
     *     assignable from the generic parameter type <code>T</code> (Note that
     *     this exception is not thrown by this method directly, but rather by
     *     the JVM upon its invocation)
     * @since 1.0
     */
    <T> Optional<T> get(String key) throws ClassCastException;

    /**
     * Assigns the given value to the given key.
     *
     * @param key The key to set
     * @param value The value to assign to the given key
     * @param <T> The type of data to be assigned
     * @since 1.0
     */
    <T> void set(String key, T value);

    /**
     * Creates a structure within this {@link Metadata} object as another
     * {@link Metadata} instance and assigns it to the given key.
     *
     * @param key The key to assign the new structure to
     * @return The newly-created structure as a {@link Metadata} object
     * @throws IllegalArgumentException If a value is already assigned to the
     *     given key
     * @since 1.0
     */
    Metadata createStructure(String key) throws IllegalArgumentException;

    /**
     * Removes the given key and its data from this {@link Metadata} object.
     *
     * @param key The key to remove
     * @return <code>true</code> if the key was removed; <code>false</code> if
     *     it was not present in this {@link Metadata} object
     * @since 1.0
     */
    boolean remove(String key);

    /**
     * Returns an {@link ImmutableSet} of all keys contained by this
     * {@link Metadata} objecjt.
     *
     * @return An {@link ImmutableSet} of all keys contained by this
     *     {@link Metadata} object
     * @since 1.0
     */
    ImmutableSet<String> getAllKeys();

    /**
     * Clears all key-value pairs from this {@link Metadata} object.
     *
     * @since 1.0
     */
    void clear();

}
