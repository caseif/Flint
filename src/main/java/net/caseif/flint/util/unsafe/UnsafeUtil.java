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

package net.caseif.flint.util.unsafe;

import net.caseif.flint.lobby.populator.LobbySignPopulator;

/**
 * A collection of utilities for internal use which generally cannot be relied
 * upon to exhibit consistent behavior across API revisions. This class may not
 * be used outside the Flint engine - methods will throw an
 * {@link IllegalStateException} if invoked externally.
 */
public abstract class UnsafeUtil {

    protected static UnsafeUtil INSTANCE;

    public static UnsafeUtil instance() {
        return INSTANCE;
    }

    public abstract LobbySignPopulator getDefaultStatusLobbySignPopulator();

    public abstract LobbySignPopulator getDefaultChallengerListingLobbySignPopulator();

}
