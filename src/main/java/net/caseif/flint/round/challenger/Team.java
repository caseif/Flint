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

import java.util.Set;

/**
 * Represents a team containing {@link Challenger}s in a
 * {@link Round}.
 *
 * @author Max Roncacé
 * @since 1.0.0
 */
public interface Team extends Metadatable {

    /**
     * Gets the internal identifier of this {@link Team}.
     *
     * @return The internal identifier of this {@link Team}
     * @since 1.0.0
     */
    String getId();

    /**
     * Gets the display name of this {@link Team}.
     *
     * @return The display name of this {@link Team}
     * @since 1.0.0
     */
    String getDisplayName();

    /**
     * Returns the {@link Round} containing this {@link Team}.
     *
     * @return The {@link Round} containing this {@link Team}
     * @since 1.0.0
     */
    Round getRound();

    /**
     * Returns an immutable {@link Set} of all {@link Challenger}s on this
     *         {@link Team}.
     *
     * @return An immutable {@link Set} of all {@link Challenger}s on this
     *         {@link Team}
     * @since 1.0.0
     */
    Set<Challenger> getChallengers();

    /**
     * Adds the given {@link Challenger} to this {@link Team} and implicitly
     * removing it from its current {@link Team} if applicable.
     *
     * @param challenger The {@link Challenger} to add
     * @since 1.0.0
     */
    void addChallenger(Challenger challenger);

}
