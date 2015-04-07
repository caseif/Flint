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
package net.caseif.flint.api;

import net.caseif.flint.api.round.Round;

import com.google.common.base.Optional;

import java.util.Set;

/**
 * Represents a minigame registered with Flint.
 *
 * @author Max Roncacé
 * @since 0.1.0
 */
public interface Minigame {

    /**
     * Gets the name or ID of the plugin to which this {@link Minigame} belongs.
     *
     * @return the name or ID of the plugin to which this {@link Minigame}
     *         belongs.
     * @since 0.1.0
     */
    String getPlugin();

    /**
     * Gets the {@link Arena} by the given name within this {@link Minigame}.
     *
     * @param arenaName The name of the {@link Arena} to get
     * @return The {@link Arena} by the given name within this {@link Minigame}
     * @since 0.1.0
     */
    Optional<Arena> getArena(String arenaName);

    /**
     * Gets an immutable {@link Set} containing all {@link Arena}s owned by this
     * {@link Minigame}.
     *
     * @return an immutable {@link Set} containing all {@link Arena}s owned by
     * this {@link Minigame}.
     * @since 0.1.0
     */
    Set<Arena> getArenas();

    /**
     * Gets an immutable {@link Set} containing all active {@link Round}s owned
     * by this {@link Minigame}.
     *
     * @return an immutable {@link Set} containing all active {@link Round}s
     * owned by this {@link Minigame}.
     * @since 0.1.0
     */
    Set<Round> getRounds();

}
