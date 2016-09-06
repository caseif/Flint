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

package net.caseif.flint.challenger;

import net.caseif.flint.component.Component;
import net.caseif.flint.component.exception.OrphanedComponentException;
import net.caseif.flint.metadata.MetadataHolder;
import net.caseif.flint.round.Round;
import net.caseif.flint.util.annotation.Orphaner;

import com.google.common.base.Optional;

import java.util.UUID;

/**
 * Represents a player actively in a minigame {@link Round} backed by Flint.
 *
 * @author Max Roncace
 * @since 1.0
 */
public interface Challenger extends MetadataHolder, Component<Round> {

    /**
     * Gets the {@link Round} this {@link Challenger} is owned by.
     *
     * <p><strong>Note:</strong> This a convenience method for
     * {@link Challenger#getOwner()}.</p>
     *
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @return The {@link Round} this {@link Challenger} is owned by
     * @since 1.0
     */
    Round getRound() throws OrphanedComponentException;

    /**
     * Gets the username of this {@link Challenger}.
     *
     * @return The username of this {@link Challenger}
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @since 1.0
     */
    String getName() throws OrphanedComponentException;

    /**
     * Gets the unique ID of this {@link Challenger}.
     *
     * @return The unique ID of this {@link Challenger}
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @since 1.0
     */
    UUID getUniqueId() throws OrphanedComponentException;

    /**
     * Removes this {@link Challenger} from its current {@link Round}.
     *
     * <p>Note that calling this method will orphan this object, causing all of
     * its methods to throw {@link OrphanedComponentException}s.</p>
     *
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @since 1.0
     */
    @Orphaner
    void removeFromRound() throws OrphanedComponentException;

    /**
     * Gets the {@link Team} this challenger belongs to.
     *
     * @return The {@link Team} this challenger belongs to
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @since 1.0
     */
    Optional<Team> getTeam() throws OrphanedComponentException;

    /**
     * Sets the {@link Team} this challenger belongs to.
     *
     * @param team The {@link Team} the challenger will be moved to
     * @throws IllegalArgumentException If the provided {@link Team} does not
     *     belong to this challenger's {@link Round}
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @since 1.1
     */
    void setTeam(Team team) throws IllegalArgumentException, OrphanedComponentException;

    /**
     * Returns whether this {@link Challenger} is currently spectating.
     *
     * <p>Spectators are not visible to others and may not interact with the
     * {@link Round} they are contained by.</p>
     *
     * @return Whether this {@link Challenger} is currently spectating
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @since 1.0
     */
    boolean isSpectating() throws OrphanedComponentException;

    /**
     * Sets whether this {@link Challenger} is currently spectating.
     *
     * <p>Spectators are not visible to others and may not interact with the
     * {@link Round} they are contained by.</p>
     *
     * @param spectating Whether this {@link Challenger} is currently spectating
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @since 1.0
     */
    void setSpectating(boolean spectating) throws OrphanedComponentException;

}
