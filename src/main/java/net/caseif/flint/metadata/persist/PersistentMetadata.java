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

package net.caseif.flint.metadata.persist;

import net.caseif.flint.metadata.Metadata;
import net.caseif.flint.serialization.Serializer;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;

import java.util.List;
import java.util.Map;

/**
 * Represents a set of persistable data associated with a
 * {@link PersistentMetadataHolder} instance or a parent
 * {@link PersistentMetadata} object.
 *
 * @author Max Roncace
 * @since 1.0
 */
public interface PersistentMetadata extends Metadata {

    /**
     * Gets the value assigned to the given key.
     *
     * @param key The key of the value to retrieve
     * @param serializer The {@link Serializer} to apply to the retrieved value
     * @param <T> The type of data associated with the given key
     * @return The value assigned to the given key, or {@link Optional#absent()}
     *     if the key is not defined
     * @throws ClassCastException If the value associated with the given key is
     *     assignable from the generic parameter type {@code T} (Note that
     *     this exception is not thrown by this method directly, but rather by
     *     the JVM upon its invocation)
     * @throws IllegalArgumentException If the value associated with
     *     {@code key} is a {@link PersistentMetadata} structure, or if
     *     the value is an invalid serial for the provided {@link Serializer}
     * @since 1.0
     */
    <T> T get(String key, Serializer<T> serializer) throws ClassCastException, IllegalArgumentException;

    /**
     * {@inheritDoc}
     *
     * <p><strong>This method is not supported for {@link PersistentMetadata}
     * objects.</strong></p>
     *
     * @throws UnsupportedOperationException Always
     * @since 1.0
     */
    @Override
    void set(String key, Object value) throws UnsupportedOperationException;

    /**
     * Assigns the given string to the given key in a persistent manner.
     *
     * @param key The key to set
     * @param value The string to assign to the key
     * @since 1.0
     */
    void set(String key, String value);

    /**
     * Assigns the given boolean to the given key in a persistent manner.
     *
     * @param key The key to set
     * @param value The boolean to assign to the key
     * @since 1.0
     */
    void set(String key, boolean value);

    /**
     * Assigns the given byte to the given key in a persistent manner.
     *
     * @param key The key to set
     * @param value The byte to assign to the key
     * @since 1.0
     */
    void set(String key, byte value);

    /**
     * Assigns the given short to the given key in a persistent manner.
     *
     * @param key The key to set
     * @param value The short to assign to the key
     * @since 1.0
     */
    void set(String key, short value);

    /**
     * Assigns the given char to the given key in a persistent manner.
     *
     * @param key The key to set
     * @param value The char to assign to the key
     * @since 1.0
     */
    void set(String key, char value);

    /**
     * Assigns the given int to the given key in a persistent manner.
     *
     * @param key The key to set
     * @param value The int to assign to the key
     * @since 1.0
     */
    void set(String key, int value);

    /**
     * Assigns the given long to the given key in a persistent manner.
     *
     * @param key The key to set
     * @param value The long to assign to the key
     * @since 1.0
     */
    void set(String key, long value);

    /**
     * Assigns the given float to the given key in a persistent manner.
     *
     * @param key The key to set
     * @param value The float to assign to the key
     * @since 1.0
     */
    void set(String key, float value);

    /**
     * Assigns the given double to the given key in a persistent manner.
     *
     * @param key The key to set
     * @param value The double to assign to the key
     * @since 1.0
     */
    void set(String key, double value);

    /**
     * Assigns the given object to the given key in a persistent manner, using
     * the provided {@link Serializer} to serialize it to a string.
     *
     * @param key The key to set
     * @param value The object to assign to the key
     * @param serializer The {@link Serializer} to apply to the provided value
     * @param <T> The object type accepted by {@code serializer}
     * @since 1.0
     */
    <T> void set(String key, T value, Serializer<T> serializer);

    /**
     * Assigns the given string {@link List} to the given key in a persistent
     * manner.
     *
     * @param key The key to set
     * @param value The string {@link List} to assign to the key
     * @since 1.0
     */
    void set(String key, List<String> value);

    /**
     * Assigns the given {@link List} to the given key in a persistent
     * manner, using the provided {@link Serializer} to serialize its respective
     * values to strings.
     *
     * @param key The key to set
     * @param value The {@link List} to assign to the key
     * @param serializer The {@link Serializer} to apply to the provided list's
     *     elements
     * @param <T> The object type accepted by {@code serializer}
     * @since 1.0
     */
    <T> void set(String key, List<T> value, Serializer<T> serializer);

    /**
     * Creates a structure within this {@link PersistentMetadata} object as
     * another {@link PersistentMetadata} instance and assigns it to the given
     * key.
     *
     * @return The newly-created structure as a {@link PersistentMetadata}
     *     object
     * @since 1.0
     */
    @Override
    PersistentMetadata createStructure(String key);

    /**
     * <strong>Note:</strong> This method will return the serialized string
     * values of {@link PersistentMetadata} objects. To obtain the original
     * values, see {@link #values(Function)}.
     *
     * Returns an {@link ImmutableCollection} of all values contained by this
     * {@link Metadata} object.
     *
     * @since 1.3
     */
    ImmutableCollection<String> values();

    /**
     * Returns an {@link ImmutableCollection} of all deserialized values
     * contained by this {@link Metadata} object per the given {@link Function}.
     *
     * @param transformer The {@link Function} used to transform serialized
     *     values to their original {@link Object}s
     * @return An {@link ImmutableCollection} of all values contained by this
     *     {@link Metadata} object
     * @since 1.3
     */
    ImmutableCollection<Object> values(Function<String, Object> transformer);

    /**
     * <strong>Note:</strong> This method will return the serialized string
     * values of {@link PersistentMetadata} objects. To obtain the original
     * values, see {@link #values(Function)}.
     *
     * @since 1.3
     */
    ImmutableSet<? extends Map.Entry<String, String>> entrySet();

    /**
     * Returns an {@link ImmutableSet} of all {@link Map.Entry entries}
     * contained by this {@link Metadata} object with values deserialized per
     * the given {@link Function}.
     *
     * @param transformer The {@link Function} used to transform serialized
     *     values to their original {@link Object}s
     * @return An {@link ImmutableSet} of all {@link Map.Entry entries}
     *     contained by this {@link Metadata} object
     * @since 1.3
     */
    ImmutableSet<? extends Map.Entry<String, Object>> entrySet(Function<String, Object> transformer);

}
