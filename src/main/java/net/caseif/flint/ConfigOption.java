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

import java.util.Objects;
import java.util.UUID;

/**
 * Represents a configuration option for a {@link Minigame}.
 *
 * @param <T> The value type associated with this {@link ConfigOption}
 */
@SuppressWarnings("unused")
public class ConfigOption<T> {

    //TODO: this is just a demo, these fields will be replaced with actual ones later on
    public static final ConfigOption<Integer> FOO = new ConfigOption<>();
    public static final ConfigOption<String> BAR = new ConfigOption<>();
    public static final ConfigOption<Boolean> QUUX = new ConfigOption<>();

    private final UUID uuid;

    private ConfigOption() {
        this.uuid = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object otherOption) {
        return otherOption instanceof ConfigOption && this.uuid.equals(((ConfigOption)otherOption).uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

}
