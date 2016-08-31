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

package net.caseif.flint.round;

/**
 * Represents an immutable lifecycle stage of a {@link Round}.
 *
 * @author Max Roncacé
 * @since 1.0
 */
public final class LifecycleStage {

    private final String id;
    private final int duration;

    /**
     * Constructs a new {@link LifecycleStage} with the given ID and duration.
     *
     * @param id The stage's ID
     * @param duration The duration of the stage
     * @since 1.0
     */
    public LifecycleStage(String id, int duration) {
        this.id = id;
        this.duration = duration;
    }

    /**
     * Gets the ID of this {@link LifecycleStage}.
     *
     * @return The ID of this {@link LifecycleStage}
     * @since 1.0
     */
    public final String getId() {
        return this.id;
    }

    /**
     * Gets the duration of this {@link LifecycleStage}.
     *
     * @return The duration of this {@link LifecycleStage}
     * @since 1.0
     */
    public final int getDuration() {
        return this.duration;
    }

}
