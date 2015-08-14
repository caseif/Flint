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
package net.caseif.flint.event.lobby;

import net.caseif.flint.lobby.LobbySign;

import java.util.UUID;

/**
 * Called when an in-game player clicks a {@link LobbySign}.
 *
 * <p>This event will not be called for clicks which break and unregister the
 * sign, nor for middle-mouse clicks.</p>
 *
 * @author Max Roncacé
 * @since 1.0
 */
public interface PlayerClickLobbySignEvent {

    /**
     * Returns the {@link UUID} of the player involved in this event.
     *
     * @return The {@link UUID} of the player involved in this event
     * @since 1.0
     */
    UUID getPlayer();

    /**
     * Returns the {@link LobbySign} involved in this event.
     *
     * @return The {@link LobbySign} involved in this event
     * @since 1.0
     */
    LobbySign getLobbySign();

    /**
     * Returns the {@link ClickType type} of click involved in this event.
     *
     * @return The {@link ClickType type} of click involved in this event
     * @since 1.0
     */
    ClickType getClickType();

    enum ClickType {

        /**
         * Represents a left-mouse click.
         *
         * @since 1.0
         */
        LEFT,
        /**
         * Represents a right-mouse click.
         *
         * @since 1.0
         */
        RIGHT,

    }

}
