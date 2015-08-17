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
package net.caseif.flint.lobby;

import net.caseif.flint.arena.Arena;
import net.caseif.flint.exception.OrphanedObjectException;
import net.caseif.flint.lobby.type.ChallengerListingLobbySign;
import net.caseif.flint.lobby.type.StatusLobbySign;
import net.caseif.flint.util.MinigameElement;
import net.caseif.flint.util.annotation.Orphanable;
import net.caseif.flint.util.annotation.Orphaner;
import net.caseif.flint.util.physical.Location3D;

/**
 * Represents a physical sign in the world which provides graphical information
 * to players regarding a particular arena.
 *
 * @author Max Roncacé
 * @since 1.0
 */
@Orphanable
public interface LobbySign extends MinigameElement {

    /**
     * Gets the physical {@link Location3D location} of this {@link LobbySign}.
     *
     * @return The physical {@link Location3D location} of this
     *     {@link LobbySign}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    Location3D getLocation() throws OrphanedObjectException;

    /**
     * Gets the {@link Arena} associated with this {@link LobbySign}.
     *
     * @return The {@link Arena} associated with this {@link LobbySign}
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    Arena getArena() throws OrphanedObjectException;

    /**
     * Gets the {@link LobbySign.Type} of this {@link LobbySign}.
     *
     * @return The {@link LobbySign.Type} of this {@link LobbySign}
     * @since 1.0
     */
    Type getType();

    /**
     * Updates this {@link LobbySign}'s display in the world.
     *
     * @since 1.0
     */
    void update();

    /**
     * Unregisters this {@link LobbySign} from the engine and blanks the
     * physical sign.
     *
     * <p>Note that calling this method will orphan this object, causing all of
     * its methods to throw {@link OrphanedObjectException}s.</p>
     *
     * @throws OrphanedObjectException If this object is orphaned (see
     *     {@link Orphanable} for details)
     * @since 1.0
     */
    @Orphaner
    void unregister() throws OrphanedObjectException;

    enum Type {
        /**
         * A status lobby sign. See {@link StatusLobbySign} for further
         * information.
         *
         * @since 1.0
         */
        STATUS,
        /**
         * A challenger listing lobby sign. See
         * {@link ChallengerListingLobbySign} for further information.
         *
         * @since 1.0
         */
        CHALLENGER_LISTING;
    }

}
