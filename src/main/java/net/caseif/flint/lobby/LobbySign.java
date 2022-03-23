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

package net.caseif.flint.lobby;

import net.caseif.flint.arena.Arena;
import net.caseif.flint.component.Component;
import net.caseif.flint.component.exception.OrphanedComponentException;
import net.caseif.flint.lobby.type.ChallengerListingLobbySign;
import net.caseif.flint.lobby.type.StatusLobbySign;
import net.caseif.flint.util.annotation.Orphaner;
import net.caseif.flint.util.physical.Location3D;

/**
 * Represents a physical sign in the world which provides graphical information
 * to players regarding a particular arena.
 *
 * @author Max Roncace
 * @since 1.0
 */
public interface LobbySign extends Component<Arena> {

    /**
     * Gets the {@link Arena} this {@link LobbySign} is owned by.
     *
     * <p><strong>Note:</strong> This a convenience method for
     * {@link LobbySign#getOwner()}.</p>
     *
     * @return The {@link Arena} this {@link LobbySign} is owned by
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @since 1.0
     */
    Arena getArena() throws OrphanedComponentException;

    /**
     * Gets the physical {@link Location3D location} of this {@link LobbySign}.
     *
     * @return The physical {@link Location3D location} of this
     *     {@link LobbySign}
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @since 1.0
     */
    Location3D getLocation() throws OrphanedComponentException;

    /**
     * Gets the {@link LobbySign.Type} of this {@link LobbySign}.
     *
     * @return The {@link LobbySign.Type} of this {@link LobbySign}
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @since 1.0
     */
    Type getType() throws OrphanedComponentException;

    /**
     * Updates this {@link LobbySign}'s display in the world.
     *
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @since 1.0
     */
    void update() throws OrphanedComponentException;

    /**
     * Unregisters this {@link LobbySign} from the engine and blanks the
     * physical sign.
     *
     * <p>Note that calling this method will orphan this object, causing all of
     * its methods to throw {@link OrphanedComponentException}s.</p>
     *
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @since 1.0
     */
    @Orphaner
    void unregister() throws OrphanedComponentException;

    /**
     * An {@code enum} representing a specific type of lobby sign.
     *
     * @since 1.0
     */
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
