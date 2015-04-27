package net.caseif.flint.api.locale;

import net.caseif.flint.api.Minigame;

/**
 * Provides localization support for a particular {@link Minigame}.
 *
 * <p>Locales are loaded as <code>.properties</code> files from the
 * <code>/locales</code> directory of the archive of the plugin owning this
 * {@link LocaleManager}'s {@link Minigame}.</p>
 *
 * @author Max Roncacé
 * @since 1.0.0
 */
public interface LocaleManager {

    /**
     * Gets the {@link Minigame} owning this {@link LocaleManager}.
     *
     * @return The {@link Minigame} owning this {@link LocaleManager}
     * @since 1.0.0
     */
    Minigame getMinigame();

    /**
     * Gets the server's default locale.
     *
     * @return A string representing the server's default locale. This follows
     *         the ISO 639-1 and ISO 3166-1 standards, respectively (e.g. en_US
     *         or enUS).
     * @since 1.0.0
     */
    String getServerLocale();

}
