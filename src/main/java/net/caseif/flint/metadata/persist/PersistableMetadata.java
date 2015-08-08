/*
 * New BSD License (BSD-new)
 *
 * Copyright (c) 2015 Maxim Roncacé
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     - Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     - Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     - Neither the name of the copyright holder nor the names of its contributors
 *       may be used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.caseif.flint.metadata.persist;

import net.caseif.flint.metadata.Metadata;

import com.google.common.base.Optional;

import java.util.List;

/**
 * Represents a set of persistable data associated with a
 * {@link PersistentMetadatable} instance.
 *
 * @author Max Roncacé
 * @since 1.0
 */
public interface PersistableMetadata extends Metadata {

    /**
     * Gets the value assigned to the given key.
     *
     * @param key The key of the value to retrieve
     * @param serializer The {@link Serializer} to apply to the retrieved value
     * @param <T> The type of data associated with the given key
     * @return The value assigned to the given key, or {@link Optional#absent()}
     *     if the key is not defined
     * @throws ClassCastException If the value associated with the given key is
     *     assignable from the generic parameter type <code>T</code> (Note that
     *     this exception is not thrown by this method directly, but rather by
     *     the JVM upon its invocation)
     * @throws IllegalArgumentException If the value associated with
     *     <code>key</code> is a {@link PersistableMetadata} structure, or if
     *     the value is an invalid serial for the provided {@link Serializer}
     * @since 1.0
     */
    <T> T get(String key, Serializer<T> serializer) throws ClassCastException, IllegalArgumentException;

    /**
     * {@inheritDoc}
     *
     * <p><strong>This method is not supported for {@link PersistableMetadata}
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
     * @param <T> The object type accepted by <code>serializer</code>
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
     * @param <T> The object type accepted by <code>serializer</code>
     * @since 1.0
     */
    <T> void set(String key, List<T> value, Serializer<T> serializer);

    @Override
    PersistableMetadata createStructure(String key);

}
