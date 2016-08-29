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
package net.caseif.flint.lobby.template;

import net.caseif.flint.lobby.LobbySign;

import com.google.common.base.Function;

/**
 * Reperesents an object used to determine the lines to populate given
 * {@link LobbySign}s with.
 *
 * @since 1.3
 */
public interface LobbySignPopulator {

    /**
     * Computes the first line of the given {@link LobbySign}.
     *
     * @param sign The {@link LobbySign} to process
     * @return The first line of the given sign
     * @since 1.3
     */
    String first(LobbySign sign);

    /**
     * Computes the second line of the given {@link LobbySign}.
     *
     * @param sign The {@link LobbySign} to process
     * @return The second line of the given sign
     * @since 1.3
     */
    String second(LobbySign sign);

    /**
     * Computes the third line of the given {@link LobbySign}.
     *
     * @param sign The {@link LobbySign} to process
     * @return The third line of the given sign
     * @since 1.3
     */
    String third(LobbySign sign);

    /**
     * Computes the fourth line of the given {@link LobbySign}.
     *
     * @param sign The {@link LobbySign} to process
     * @return The fourth line of the given sign
     * @since 1.3
     */
    String fourth(LobbySign sign);

    /**
     * Returns the {@link Function} used to populate the first line of a
     * {@link LobbySign}.
     *
     * @return The {@link Function} used
     * @since 1.3
     */
    String getFirstFunc();

    /**
     * Returns the {@link Function} used to populate the second line of a
     * {@link LobbySign}.
     *
     * @return The {@link Function} used
     * @since 1.3
     */
    String getSecondFunc();

    /**
     * Returns the {@link Function} used to populate the third line of a
     * {@link LobbySign}.
     *
     * @return The {@link Function} used
     * @since 1.3
     */
    String getThirdFunc();

    /**
     * Returns the {@link Function} used to populate the fourth line of a
     * {@link LobbySign}.
     *
     * @return The {@link Function} used
     * @since 1.3
     */
    String getFourthFunc();

    /**
     * Builder for {@link LobbySignPopulator} objects.
     *
     * @since 1.3
     */
    interface Builder {

        /**
         * Sets the {@link Function} to be used to populate the first line of
         * a {@link LobbySign}.
         *
         * @param function The {@link Function} to be used to populate the first
         *     line of a {@link LobbySign}
         * @return This {@link Builder}, for chaining
         * @since 1.3
         */
        Builder first(Function<LobbySign, String> function);

        /**
         * Sets the {@link Function} to be used to populate the second line of
         * a {@link LobbySign}.
         *
         * @param function The {@link Function} to be used to populate the
         *     second line of a {@link LobbySign}
         * @return This {@link Builder}, for chaining
         * @since 1.3
         */
        Builder second(Function<LobbySign, String> function);

        /**
         * Sets the {@link Function} to be used to populate the third line of
         * a {@link LobbySign}.
         *
         * @param function The {@link Function} to be used to populate the third
         *     line of a {@link LobbySign}
         * @return This {@link Builder}, for chaining
         * @since 1.3
         */
        Builder third(Function<LobbySign, String> function);

        /**
         * Sets the {@link Function} to be used to populate the fourth line of
         * a {@link LobbySign}.
         *
         * @param function The {@link Function} to be used to populate the
         *     fourth line of a {@link LobbySign}
         * @return This {@link Builder}, for chaining
         * @since 1.3
         */
        Builder fourth(Function<LobbySign, String> function);

        /**
         * Constructs a new {@link LobbySignPopulator} based on this
         * {@link Builder}.
         *
         * <p>Note that if any {@link Function}s are {@code null}, a
         * {@link Function} returning an empty string will be used in their
         * respective places.</p>
         *
         * @return A new {@link LobbySignPopulator} based on this
         *     {@link Builder}
         * @since 1.3
         */
        LobbySignPopulator build();

    }

}
