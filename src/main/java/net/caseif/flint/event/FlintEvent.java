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
package net.caseif.flint.event;

import net.caseif.flint.component.Component;
import net.caseif.flint.minigame.Minigame;

/**
 * Represents an event triggered by Flint.
 *
 * <p>Flint events by are posted <em>after</em> their respective actions have
 * occured, unless otherwise noted by their documentation.</p>
 *
 * <p>Flint's event classes are contained by a hierarchy separate from that of
 * the native platform and handled by a different bus. These two separate
 * systems do not and may not intermingle.</p>
 *
 * @author Max Roncacé
 * @since 1.0
 */
public interface FlintEvent extends Component<Minigame> {

    /**
     * Gets the {@link Minigame} this {@link FlintEvent} is owned by.
     *
     * <p><strong>Note:</strong> This a convenience method for
     * {@link FlintEvent#getOwner()}.</p>
     *
     * @return The {@link Minigame} this {@link FlintEvent} is owned by
     * @since 1.0
     */
    Minigame getMinigame();

}
