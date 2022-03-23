/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015-2022, Max Roncace <me@caseif.net>
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

package net.caseif.flint.event.round.challenger;

import net.caseif.flint.challenger.Challenger;
import net.caseif.flint.util.physical.Location3D;

/**
 * Called when a {@link Challenger} leaves a
 * {@link net.caseif.flint.round.Round}.
 *
 * <p><strong>Note:</strong> This event is called <em>before</em> the target
 * {@link Challenger} is invalidated and before the player is teleported, so as
 * to allow the return location to be modified.</p>
 *
 * @author Max Roncace
 * @since 1.0
 */
public interface ChallengerLeaveRoundEvent extends ChallengerEvent {

    /**
     * Gets the {@link Location3D} the subject of this event will be moved to.
     *
     * @return The {@link Location3D} the subject of this event will be moved to
     * @since 1.0
     */
    Location3D getReturnLocation();

    /**
     * Sets the {@link Location3D} the subject of this event will be moved to.
     *
     * @param location The {@link Location3D} the subject of this event will be
     *     moved to
     * @since 1.0
     */
    void setReturnLocation(Location3D location);

}
