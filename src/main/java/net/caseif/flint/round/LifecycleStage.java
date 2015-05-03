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
