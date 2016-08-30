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
package net.caseif.flint;

import net.caseif.flint.minigame.Minigame;
import net.caseif.flint.util.unsafe.UnsafeUtil;

/**
 * The core class for the Flint framework.
 *
 * @author Max Roncacé
 * @version 1.3-SNAPSHOT
 * @since 1.0
 */
public abstract class FlintCore {

    protected static FlintCore INSTANCE;
    protected static UnsafeUtil UNSAFE;

    private static final int API_REVISION = 4;
    private static final String CODENAME = "Dagur";


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
        return API_REVISION;
    }

    /**
     * Gets the codename of the current API revision. This method is intended
     * for internal use by implementations of the engine.
     *
     * @return The codename of the current API revision
     * @since 1.3
     */
    protected static String getCodename() {
        return CODENAME;
    }

    /**
     * Gets the name of the software currently implementing Flint.
     *
     * @return The name of the software currently implementing Flint
     * @since 1.0
     */
    public static String getImplementationName() {
        return INSTANCE.getImplementationName0();
    }

    protected abstract String getImplementationName0();

    /**
     * Registers a plugin as a Flint-backed {@link Minigame}.
     *
     * @param pluginId The name or ID of the plugin to register
     * @return The newly created {@link Minigame} associated with the plugin
     * @throws IllegalStateException If a plugin with the given ID has already
     *     been registered as a {@link Minigame}
     * @since 1.0
     */
    public static Minigame registerPlugin(String pluginId) throws IllegalStateException {
        return INSTANCE.registerPlugin0(pluginId);
    }

    protected abstract Minigame registerPlugin0(String pluginId) throws IllegalStateException;

}
