/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015-2022, Max Roncace <me@caseif.net>
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

package net.caseif.flint.serialization;

/**
 * Represents an object which may serialize and deserialize objects to strings.
 *
 * @param <T> The type of object which may be serialized by this
 *     {@link Serializer}
 * @since 1.0
 * @author Max Roncace
 */
public interface Serializer<T> {

    /**
     * Serializes a given object to a string.
     *
     * @param object The object to serialize
     * @return The string representing the serialized object
     * @since 1.0
     */
    String serialize(T object);

    /**
     * Deserializes the given string to an object.
     *
     * @param serial The string to deserialize
     * @return The deserialized object
     * @throws IllegalArgumentException If an invalid serial is provided
     * @since 1.0
     */
    T deserialize(String serial) throws IllegalArgumentException;

}
