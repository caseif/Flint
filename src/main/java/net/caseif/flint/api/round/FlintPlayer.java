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
package net.caseif.flint.api.round;

import net.caseif.flint.api.util.Metadatable;

import java.util.UUID;

/**
 * Represents a player actively in a minigame {@link Round} backed by Flint.
 *
 * @author Max Roncacé
 * @since 0.1.0
 */
public interface FlintPlayer extends Metadatable {

    /**
     * Gets the username of this {@link FlintPlayer}.
     *
     * @return The username of this {@link FlintPlayer}
     * @since 0.1.0
     */
    String getName();

    /**
     * Gets the unique ID of this {@link FlintPlayer}.
     *
     * @return The unique ID of this {@link FlintPlayer}
     * @since 0.1.0
     */
    UUID getUniqueId();

    /**
     * Gets the {@link Round} which this player is currently in.
     *
     * <p>This should never return <code>null</code> when used properly, as
     * references to a {@link FlintPlayer}s should under no circumstances be
     * retained beyond it fully exiting a {@link Round}.</p>
     *
     * @return The {@link Round} which this player is currently in.
     * @since 0.1.0
     */
    Round getRound();

}
