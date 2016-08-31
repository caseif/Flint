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

package net.caseif.flint.lobby.type;

import net.caseif.flint.arena.Arena;
import net.caseif.flint.challenger.Challenger;
import net.caseif.flint.component.Component;
import net.caseif.flint.component.exception.OrphanedComponentException;
import net.caseif.flint.lobby.LobbySign;
import net.caseif.flint.round.Round;

/**
 * Represents a {@link LobbySign} which displays a subset of the
 * {@link Challenger}s currently contained by a {@link Round}.
 *
 * <p>This sign type is meant to be used in conjunction with a
 * {@link StatusLobbySign}, and will not contain any information about its
 * respective {@link Round} or {@link Arena} other than player names.</p>
 *
 * @author Max Roncacé
 * @since 1.0
 */
public interface ChallengerListingLobbySign extends LobbySign {

    /**
     * Gets the index of this {@link ChallengerListingLobbySign}.
     *
     * <p>The subset of {@link Challenger}s displayed by a sign based on its
     * index can be represented by the range {@code [index * 4, index * 4 + 3]},
     * inclusive (assuming 4 lines per sign). Therefore, a sign of index
     * {@code 0} would display players with indexes within the range
     * {@code [0, 3]}. Index {@code 1} would display the range {@code [4, 7]},
     * and so on.</p>
     *
     * @return The index of this {@link ChallengerListingLobbySign}
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @since 1.0
     */
    int getIndex() throws OrphanedComponentException;

}
