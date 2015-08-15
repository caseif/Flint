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
package net.caseif.flint.challenger;

import net.caseif.flint.exception.OrphanedObjectException;
import net.caseif.flint.metadata.Metadatable;
import net.caseif.flint.round.Round;
import net.caseif.flint.util.MinigameElement;
import net.caseif.flint.util.annotation.Orphanable;

import com.google.common.collect.ImmutableList;

/**
 * Represents a team containing {@link Challenger}s in a
 * {@link Round}.
 *
 * @author Max Roncacé
 * @since 1.0
 */
@Orphanable
public interface Team extends Metadatable, MinigameElement {

    /**
     * Gets the internal identifier of this {@link Team}.
     *
     * @return The internal identifier of this {@link Team}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    String getId() throws OrphanedObjectException;

    /**
     * Gets the display name of this {@link Team}.
     *
     * @return The display name of this {@link Team}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    String getName() throws OrphanedObjectException;

    /**
     * Sets the display name of this {@link Team}.
     *
     * @param name The new display name of this {@link Team}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    void setName(String name) throws OrphanedObjectException;

    /**
     * Returns the {@link Round} containing this {@link Team}.
     *
     * @return The {@link Round} containing this {@link Team}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    Round getRound() throws OrphanedObjectException;

    /**
     * Returns an {@link ImmutableList} of all {@link Challenger}s on this
     *     {@link Team}.
     *
     * @return An {@link ImmutableList} of all {@link Challenger}s on this
     *     {@link Team}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    ImmutableList<Challenger> getChallengers() throws OrphanedObjectException;

    /**
     * Adds the given {@link Challenger} to this {@link Team} and implicitly
     * removing it from its current {@link Team} if applicable.
     *
     * @param challenger The {@link Challenger} to add
     * @throws IllegalArgumentException If the givene {@link Challenger} is
     *     owned by a different {@link Round} than the one parenting this
     *     {@link Team}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    void addChallenger(Challenger challenger) throws IllegalArgumentException, OrphanedObjectException;

    /**
     * Removes the given {@link Challenger} from this {@link Team}.
     *
     * @param challenger The {@link Challenger} to remove
     * @throws IllegalArgumentException If the given {@link Challenger} is not
     *     on this {@link Team}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    void removeChallenger(Challenger challenger) throws IllegalArgumentException, OrphanedObjectException;

}
