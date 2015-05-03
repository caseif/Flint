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
package net.caseif.flint.util;

import java.util.Set;

/**
 * Represents an object which may carry metadata.
 *
 * @author Max Roncacé
 * @since 1.0
 */
public interface Metadatable {

    /**
     * Gets whether this {@link Metadatable} instanceof contains metadata with
     * the given key.
     *
     * @param key The key to search for
     * @return Whether this {@link Metadatable} instanceof contains metadata
     *         with the given key
     * @since 1.0
     */
    boolean hasMetadata(String key);

    /**
     * Gets the value of the metadata with the given key.
     *
     * @param key The key of the metadata value to retrieve
     * @return The value of the metadata with the given key, or
     *         <code>null</code> if the key is not defined
     * @since 1.0
     */
    Object getMetadata(String key);

    /**
     * Assigns the given value to the metadata with the given key, or clears it
     * if <code>value</code> is <code>null</code>.
     *
     * @param key The name of the metadata key to set
     * @param value The value to assign to the metadata key
     * @since 1.0
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
     * @since 1.0
     */
    void removeMetadata(String key);

    /**
     * Returns an immutable {@link Set} of all metadata keys carried by this
     * {@link Metadatable} instance.
     *
     * @return An immutable {@link Set} of all metadata keys carried by this
     *         {@link Metadatable} instance
     * @since 1.0
     */
    Set<String> getAllMetadata();

}
