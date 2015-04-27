package net.caseif.flint.api.locale;

import net.caseif.flint.api.round.FlintPlayer;

import java.util.UUID;

//TODO: class documentation probably needs some work
/**
 * Represents a message or other string which may be translated into different
 * locales.
 *
 * <p>This may represent an ordered collection of strings and/or other
 * {@link Localizable}s.</p>
 *
 * <p>In the event that a {@link Localizable} cannot be localized in the given
 * locale, it will output its internal key instead.</p>
 *
 * @author Max Roncacé
 * @since 1.0.0
 */
public interface Localizable {

    /**
     * Gets the parent {@link LocaleManager} for this {@link Localizable}.
     *
     * @return The parent {@link LocaleManager} for this {@link Localizable}.
     * @since 1.0.0
     */
    LocaleManager getParent();

    /**
     * Localizes this {@link Localizable} in the server's default locale.
     *
     * @return The appropriate localization for this {@link Localizable}.
     * @since 1.0.0
     */
    String localize();

    /**
     * Localizes this {@link Localizable} in the given locale.
     *
     * @param locale The locale to localize this {@link Localizable} in
     * @return A string representing the localized message. This should follow
     *         the ISO 639-1 and ISO 3166-1 standards, respectively (e.g. en_US
     *         or enUS).
     * @since 1.0.0
     */
    String localizeIn(String locale);

    /**
     * Localizes this {@link Localizable} in the given player's locale.
     *
     * @param locale The player to localize this {@link Localizable} for
     * @return A string representing the localized message
     * @since 1.0.0
     */
    String localizeFor(FlintPlayer player);

    /**
     * Localizes this {@link Localizable} in the locale of the player with the
     * given UUID.
     *
     * @param locale The UUID of the player to localize this {@link Localizable}
     *        for
     * @return A string representing the localized message
     * @since 1.0.0
     */
    String localizeFor(UUID playerUuid);

    /**
     * Sends this {@link Localizable} to the given player in their respective
     * locale.
     *
     * @param player The player to send this [@link Localizable} to
     * @since 1.0.0
     */
    void sendTo(FlintPlayer player);

    /**
     * Sends this {@link Localizable} to the player with the given UUID in their
     * respective locale.
     *
     * @param player The UUID of the player to send this [@link Localizable} to
     * @since 1.0.0
     */
    void sendTo(UUID playerUuid);

    /**
     * Appends the given {@link Object} to this {@link Localizable}.
     *
     * <p>If <code>obj</code> is a {@link Localizable}, it will be handled
     * normally when the object this method returns is localized. Otherwise,
     * <code>toString</code> will be called upon <code>obj</code>.</p>
     *
     * @param obj The object to append to this {@link Localizable}
     * @return The newly-created {@link Localizable} with the appended object
     * @since 1.0.0
     */
    Localizable append(Object obj);

}
