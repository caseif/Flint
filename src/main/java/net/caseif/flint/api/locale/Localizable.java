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
package net.caseif.flint.api.locale;

import net.caseif.flint.api.round.player.FlintPlayer;

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
     * @param player The player to localize this {@link Localizable} for
     * @return A string representing the localized message
     * @since 1.0.0
     */
    String localizeFor(FlintPlayer player);

    /**
     * Localizes this {@link Localizable} in the locale of the player with the
     * given UUID.
     *
     * @param playerUuid The UUID of the player to localize this {@link Localizable}
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
     * @param playerUuid The UUID of the player to send this [@link Localizable} to
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
