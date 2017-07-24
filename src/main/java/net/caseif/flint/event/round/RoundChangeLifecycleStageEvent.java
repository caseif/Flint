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

package net.caseif.flint.event.round;

import java.util.concurrent.Cancellable;
import net.caseif.flint.round.LifecycleStage;
import net.caseif.flint.round.Round;

/**
 * Called when a {@link Round} changes its {@link LifecycleStage}.
 *
 * @author Max Roncace
 * @since 1.0
 */
public interface RoundChangeLifecycleStageEvent extends RoundEvent, Cancellable {

    /**
     * Returns the {@link LifecycleStage} of the {@link Round} before the event.
     *
     * @return The {@link LifecycleStage} of the {@link Round} before the event
     * @since 1.0
     */
    LifecycleStage getStageBefore();

    /**
     * Returns the {@link LifecycleStage} of the {@link Round} after the event.
     *
     * @return The {@link LifecycleStage} of the {@link Round} after the event
     * @since 1.0
     */
    LifecycleStage getStageAfter();
    
    /**
     * Returns whether the {@link LifecycleStage} that came before the event completed
     * due to the timer expiring.
     *
     * @return Whether the {@link LifeCycleStage} that came before the event completed
     *     due to the timer expiring.
     * @since 1.3.2
     */
    boolean isDone();

}
