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

package net.caseif.flint.component;

import net.caseif.flint.component.exception.OrphanedComponentException;

/**
 * Represents an object which is owned by a {@link ComponentOwner}.
 *
 * <p>All {@link Component}s are inherently orphanable. An object is considered
 * orphaned when it is dissociated from its parent container, leaving it for all
 * intents and purposes obsolete. Orphaned objects will throw an
 * {@link OrphanedComponentException} in response to any defined method being
 * invoked upon them.</p>
 *
 * @param <T> The {@link ComponentOwner} type this {@link Component} is owned
 *     by
 * @since 1.0
 */
public interface Component<T extends ComponentOwner> {

    /**
     * Gets the {@link ComponentOwner owner} of this object.
     *
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @return The {@link ComponentOwner owner} of this object
     * @since 1.0
     */
    T getOwner() throws OrphanedComponentException;

}
