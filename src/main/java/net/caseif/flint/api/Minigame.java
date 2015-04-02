/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Maxim Roncacé
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
package net.caseif.flint.api;

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
