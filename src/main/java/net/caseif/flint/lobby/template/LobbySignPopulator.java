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
public final class LobbySignPopulator {

    private Function<LobbySign, String> first;
    private Function<LobbySign, String> second;
    private Function<LobbySign, String> third;
    private Function<LobbySign, String> fourth;

    /**
     * Constructs a new {@link LobbySignPopulator} using the given
     * {@link Function}s as line populators.
     *
     * @param first The {@link Function} used to populate the first line of
     *     signs
     * @param second The {@link Function} used to populate the second line of
     *     signs
     * @param third The {@link Function} used to populate the third line of
     *     signs
     * @param fourth The {@link Function} used to populate the fourth line of
     *     signs
     */
    public LobbySignPopulator(Function<LobbySign, String> first, Function<LobbySign, String> second,
                              Function<LobbySign, String> third, Function<LobbySign, String> fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    /**
     * Computes the first line of the given {@link LobbySign}.
     *
     * @param sign The {@link LobbySign} to process
     * @return The first line of the given sign
     * @since 1.3
     */
    public String first(LobbySign sign) {
        return first.apply(sign);
    }

    /**
     * Computes the second line of the given {@link LobbySign}.
     *
     * @param sign The {@link LobbySign} to process
     * @return The second line of the given sign
     * @since 1.3
     */
    public String second(LobbySign sign) {
        return second.apply(sign);
    }

    /**
     * Computes the third line of the given {@link LobbySign}.
     *
     * @param sign The {@link LobbySign} to process
     * @return The third line of the given sign
     * @since 1.3
     */
    public String third(LobbySign sign) {
        return third.apply(sign);
    }

    /**
     * Computes the fourth line of the given {@link LobbySign}.
     *
     * @param sign The {@link LobbySign} to process
     * @return The fourth line of the given sign
     * @since 1.3
     */
    public String fourth(LobbySign sign) {
        return fourth.apply(sign);
    }

    /**
     * Sets the {@link Function} used to calculate the first line of given
     * {@link LobbySign}s.
     *
     * @param function The {@link Function} to use to calculate the first line
     *     of given signs
     * @since 1.3
     */
    public void setFirstLineFunc(Function<LobbySign, String> function) {
        this.first = function;
    }

    /**
     * Sets the {@link Function} used to calculate the second line of given
     * {@link LobbySign}s.
     *
     * @param function The {@link Function} to use to calculate the second line
     *     of given signs
     * @since 1.3
     */
    public void setSecondLineFunc(Function<LobbySign, String> function) {
        this.second = function;
    }

    /**
     * Sets the {@link Function} used to calculate the third line of given
     * {@link LobbySign}s.
     *
     * @param function The {@link Function} to use to calculate the third line
     *     of given signs
     * @since 1.3
     */
    public void setThirdLineFunc(Function<LobbySign, String> function) {
        this.third = function;
    }

    /**
     * Sets the {@link Function} used to calculate the fourth line of given
     * {@link LobbySign}s.
     *
     * @param function The {@link Function} to use to calculate the fourth line
     *     of given signs
     * @since 1.3
     */
    public void setFourthLineFunc(Function<LobbySign, String> function) {
        this.fourth = function;
    }

}
