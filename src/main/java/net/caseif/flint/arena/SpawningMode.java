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

package net.caseif.flint.arena;

/**
 * The mode by which spawn points in an arena are selected.
 *
 * @author Max Roncace
 * @since 1.1
 */
public enum SpawningMode {

    /**
     * Spawn points will be selected in respective order.
     *
     * @since 1.1
     */
    SEQUENTIAL,
    /**
     * Spawn points will be selected completely randomly.
     *
     * @since 1.1
     */
    RANDOM,
    /**
     * Available spawn points will be shuffled and then selected sequentially
     * from the new, shuffled list.
     *
     * <p>Note: modifying an arena's spawn list will reset its shuffle order, as
     * will restarting/reloading the plugin.</p>
     *
     * @since 1.2
     */
    SHUFFLE,
    /**
     * Spawn points will be selected based on proximity to other players. The
     * spawn point with the greatest average distance to all other players in
     * the arena will be used.
     *
     * @since 1.2
     */
    PROXIMITY_HIGH

}
