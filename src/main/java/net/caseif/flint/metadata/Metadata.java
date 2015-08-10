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
     * @return {@code true</code> if the key was removed; <code>false} if
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
