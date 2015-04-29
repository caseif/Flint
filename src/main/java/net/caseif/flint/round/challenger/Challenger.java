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
package net.caseif.flint.round.challenger;

import net.caseif.flint.round.Round;
import net.caseif.flint.util.Metadatable;

import com.google.common.base.Optional;

import java.util.UUID;

/**
 * Represents a player actively in a minigame {@link Round} backed by Flint.
 *
 * @author Max Roncacé
 * @since 1.0.0
 */
public interface Challenger extends Metadatable {

    /**
     * Gets the username of this {@link Challenger}.
     *
     * @return The username of this {@link Challenger}
     * @since 1.0.0
     */
    String getName();

    /**
     * Gets the unique ID of this {@link Challenger}.
     *
     * @return The unique ID of this {@link Challenger}
     * @since 1.0.0
     */
    UUID getUniqueId();

    /**
     * Gets the {@link Round} which this challenger is currently in.
     *
     * <p>This should never return <code>null</code> when used properly, as
     * references to a {@link Challenger}s should under no circumstances be
     * retained beyond it fully exiting a {@link Round}.</p>
     *
     * @return The {@link Round} which this challenger is currently in.
     * @since 1.0.0
     */
    Round getRound();

    /**
     * Gets the {@link Team} this challenger belongs to.
     *
     * @return The {@link Team} this challenger belongs to
     * @since 1.0.0
     */
    Optional<Team> getTeam();

    /**
     * Sets the {@link Team} this challenger belongs to. This implicitly removes
     * it from the team it currently belongs to if applicable.
     *
     * @param team The new {@link Team} this challenger will belong to (pass
     *             <code>null</code> to remove them from their current
     *             {@link Team})
     * @since 1.0.0
     */
    void setTeam(Team team);

    /**
     * Returns whether this {@link Challenger} is currently spectating.
     *
     * <p>Spectators are not visible to others and may not interact with the
     * {@link Round} they are contained by.</p>
     *
     * @return Whether this {@link Challenger} is currently spectating
     * @since 1.0.0
     */
    boolean isSpectating();

    /**
     * Sets whether this {@link Challenger} is currently spectating.
     *
     * <p>Spectators are not visible to others and may not interact with the
     * {@link Round} they are contained by.</p>
     *
     * @param spectating Whether this {@link Challenger} is currently spectating
     * @since 1.0.0
     */
    void setSpectating(boolean spectating);

}
