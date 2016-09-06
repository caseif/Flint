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

package net.caseif.flint.metadata;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;

import java.util.Map;

/**
 * Represents a set of data associated with a {@link MetadataHolder} instance or
 * a parent {@link Metadata} object.
 *
 * @author Max Roncace
 * @since 1.0
 */
public interface Metadata {

    /**
     * Returns whether the given key is defined for this {@link Metadata}
     * object.
     *
     * @param key The key to check
     * @return Whether the given key is defined for this {@link Metadata} object
     * @since 1.3
     */
    boolean containsKey(String key);

    /**
     * Returns whether the given value is contained by this {@link Metadata}
     * object.
     *
     * @param value The value to check
     * @return Whether the given value is contained by this {@link Metadata}
     *     object
     * @since 1.3
     */
    boolean containsValue(Object value);

    /**
     * Returns whether the given key is defined for this {@link Metadata}
     * object.
     *
     * @param key The key to check
     * @return Whether the given key is defined for this {@link Metadata} object
     * @deprecated Ambiguous name - use {@link #containsKey}
     * @since 1.0
     */
    @Deprecated
    boolean has(String key);

    /**
     * Gets the value assigned to the given key.
     *
     * @param key The key of the value to retrieve
     * @param <T> The type of data associated with the given key
     * @return The value assigned to the given key, or {@link Optional#absent()}
     *     if the key is not defined
     * @throws ClassCastException If the value associated with the given key is
     *     assignable from the generic parameter type {@code T} (Note that
     *     this exception is not thrown by this method directly, but rather by
     *     the JVM upon its invocation)
     * @since 1.0
     */
    <T> Optional<T> get(String key) throws ClassCastException;

    /**
     * Assigns the given value to the given key.
     *
     * @param key The key to set
     * @param value The value to assign to the key
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
     * @return {@code true} if the key was removed; {@code false} if
     *     it was not present in this {@link Metadata} object
     * @since 1.0
     */
    boolean remove(String key);

    /**
     * Returns an {@link ImmutableSet} of all keys contained by this
     * {@link Metadata} object.
     *
     * @return An {@link ImmutableSet} of all keys contained by this
     *     {@link Metadata} object
     * @deprecated Poorly named - use {@link #keySet}
     * @since 1.0
     */
    @Deprecated
    ImmutableSet<String> getAllKeys();

    /**
     * Returns an {@link ImmutableSet} of all keys contained by this
     * {@link Metadata} object.
     *
     * @return An {@link ImmutableSet} of all keys contained by this
     *     {@link Metadata} object
     * @since 1.3
     */
    ImmutableSet<String> keySet();

    /**
     * Returns an {@link ImmutableCollection} of all values contained by this
     * {@link Metadata} object.
     *
     * @return An {@link ImmutableCollection} of all values contained by this
     *     {@link Metadata} object
     * @since 1.3
     */
    ImmutableCollection<?> values();

    /**
     * Returns an {@link ImmutableSet} of all {@link Map.Entry entries}
     * contained by this {@link Metadata} object.
     *
     * @return An {@link ImmutableSet} of all {@link Map.Entry entries}
     *     contained by this {@link Metadata} object
     * @since 1.3
     */
    ImmutableSet<? extends Map.Entry<String, ?>> entrySet();

    /**
     * Clears all key-value pairs from this {@link Metadata} object.
     *
     * @since 1.0
     */
    void clear();

}
