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

package net.caseif.flint.challenger;

import net.caseif.flint.component.Component;
import net.caseif.flint.component.exception.OrphanedComponentException;
import net.caseif.flint.metadata.MetadataHolder;
import net.caseif.flint.round.Round;

import com.google.common.collect.ImmutableList;

/**
 * Represents a team containing {@link Challenger}s in a
 * {@link Round}.
 *
 * @author Max Roncace
 * @since 1.0
 */
public interface Team extends MetadataHolder, Component<Round> {

    /**
     * Gets the {@link Round} this {@link Team} is owned by.
     *
     * <p><strong>Note:</strong> This a convenience method for
     * {@link Team#getOwner()}.</p>
     *
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @return The {@link Round} this {@link Team} is owned by
     * @since 1.0
     */
    Round getRound() throws OrphanedComponentException;

    /**
     * Gets the internal identifier of this {@link Team}.
     *
     * @return The internal identifier of this {@link Team}
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @since 1.0
     */
    String getId() throws OrphanedComponentException;

    /**
     * Gets the display name of this {@link Team}.
     *
     * @return The display name of this {@link Team}
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @since 1.0
     */
    String getName() throws OrphanedComponentException;

    /**
     * Sets the display name of this {@link Team}.
     *
     * @param name The new display name of this {@link Team}
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @since 1.0
     */
    void setName(String name) throws OrphanedComponentException;

    /**
     * Returns an {@link ImmutableList} of all {@link Challenger}s on this
     *     {@link Team}.
     *
     * @return An {@link ImmutableList} of all {@link Challenger}s on this
     *     {@link Team}
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @since 1.0
     */
    ImmutableList<Challenger> getChallengers() throws OrphanedComponentException;

    /**
     * Adds the given {@link Challenger} to this {@link Team} and implicitly
     * removing it from its current {@link Team} if applicable.
     *
     * @param challenger The {@link Challenger} to add
     * @throws IllegalArgumentException If the givene {@link Challenger} is
     *     owned by a different {@link Round} than the one parenting this
     *     {@link Team}
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @since 1.0
     */
    void addChallenger(Challenger challenger) throws IllegalArgumentException, OrphanedComponentException;

    /**
     * Removes the given {@link Challenger} from this {@link Team}. This
     * implicitly removes it from its current {@link Team} if applicable.
     *
     * @param challenger The {@link Challenger} to remove
     * @throws IllegalArgumentException If the given {@link Challenger} is not
     *     on this {@link Team}
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @since 1.0
     */
    void removeChallenger(Challenger challenger) throws IllegalArgumentException, OrphanedComponentException;

}
