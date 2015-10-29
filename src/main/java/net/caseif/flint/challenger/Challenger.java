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
 * @author Max Roncacé
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
