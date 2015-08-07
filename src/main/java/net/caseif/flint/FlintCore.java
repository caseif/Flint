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
package net.caseif.flint;

import net.caseif.flint.minigame.Minigame;

/**
 * The core class for the Flint framework.
 *
 * @author Max Roncacé
 * @version 1.0-SNAPSHOT
 * @since 1.0
 */
public abstract class FlintCore {

    protected static FlintCore INSTANCE;

    /**
     * Gets the current API revision. Note that this is not necessarily parallel
     * to its version string.
     *
     * <p>The API revision is incremented for each version (discounting snapshot
     * builds) which modifies Flint's API.</p>
     *
     * @return The current API revision
     * @since 1.0
     */
    public static int getApiRevision() {
        return 1;
    }

    /**
     * Registers a plugin as a Flint-backed {@link Minigame}.
     *
     * @param pluginId The name or ID of the plugin to register
     * @return The newly created {@link Minigame} associated with the plugin
     * @throws IllegalArgumentException If a plugin with the given ID has
     *                                  already been registered as a
     *                                  {@link Minigame}
     * @since 1.0
     */
    public static Minigame registerPlugin(String pluginId) throws IllegalArgumentException {
        return INSTANCE.registerPlugin0(pluginId);
    }

    protected abstract Minigame registerPlugin0(String pluginId) throws IllegalArgumentException;

}
