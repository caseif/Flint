package net.caseif.flint.api;

/**
 * The core class for the Flint framework.
 *
 * @author Maxim Roncacé
 * @since 0.1.0
 */
public abstract class FlintCore {

    protected static FlintCore INSTANCE;

    /**
     * Gets the primary instance of this class.
     *
     * @return The primary instance of this class
     * @since 0.1.0
     */
    public static FlintCore getInstance() {
        return INSTANCE;
    }

    /**
     * Registers a plugin as a Flint-backed {@link Minigame}.
     *
     * @param pluginId The name or ID of the plugin to register
     * @return The newly created {@link Minigame} associated with the plugin
     * @since 0.1.0
     */
    public abstract Minigame registerPlugin(String pluginId);

}
