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
package net.caseif.flint.event.round.challenger;

import net.caseif.flint.util.physical.Location3D;

/**
 * Called when a {@link net.caseif.flint.challenger.Challenger} leaves a
 * {@link net.caseif.flint.round.Round}.
 *
 * <p><strong>Note:</strong> This event is called <em>before</em> the player is
 * teleported, so as to allow the return location to be modified.</p>
 *
 * @author Max Roncacé
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
