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
package net.caseif.flint.config;

import net.caseif.flint.Minigame;
import net.caseif.flint.challenger.Challenger;
import net.caseif.flint.challenger.Team;
import net.caseif.flint.round.LifecycleStage;
import net.caseif.flint.round.Round;

import com.google.common.collect.ImmutableSet;

import java.util.Objects;
import java.util.UUID;

/**
 * Pseudo-enum representing a configuration node for a {@link Minigame}.
 *
 * @param <T> The value type associated with this {@link ConfigNode}
 * @author Max Roncacé
 * @since 1.0
 */
@SuppressWarnings("unused")
public class ConfigNode<T> {

    // GENERAL CONFIG NODES
    /**
     * The default {@link LifecycleStage}s to apply to new {@link Round}s.
     *
     * <p><em>Default: <code>null</code></em></p>
     *
     * @since 1.0
     */
    public static final ConfigNode<ImmutableSet<LifecycleStage>> DEFAULT_LIFECYCLE_STAGES = new ConfigNode<>(null);

    // ROUND CONFIG NODES
    /**
     * The maximum permitted player count.
     *
     * <p><em>Default: <code>32</code></em></p>
     *
     * @since 1.0
     */
    public static final RoundConfigNode<Integer> MAX_PLAYERS = new RoundConfigNode<>(32);
    /**
     * Whether {@link Challenger}s are permitted to teleport.
     *
     * <p><em>Default: <code>true</code></em></p>
     *
     * @since 1.0
     */
    public static final RoundConfigNode<Boolean> ALLOW_TELEPORT = new RoundConfigNode<>(true);
    /**
     * Whether {@link Challenger}s are permitted to damage one another.
     *
     * <p><em>Default: <code>true</code></em></p>
     *
     * @since 1.0
     */
    public static final RoundConfigNode<Boolean> ALLOW_DAMAGE = new RoundConfigNode<>(true);
    /**
     * Whether {@link Challenger}s are permitted to damage teammates.
     *
     * <p><em>Default: <code>false</code></em></p>
     *
     * @since 1.0
     */
    public static final RoundConfigNode<Boolean> ALLOW_FRIENDLY_FIRE = new RoundConfigNode<>(false);
    /**
     * Whether {@link Team}s are to use separate chat channels.
     *
     * <p><em>Default: <code>false</code></em></p>
     *
     * @since 1.0
     */
    public static final RoundConfigNode<Boolean> SEPARATE_TEAM_CHATS = new RoundConfigNode<>(false);
    /**
     * Whether {@link Round}s shall be rolled back by default upon ending.
     *
     * <p><em>Default: <code>true</code></em></p>
     *
     * @since 1.0
     */
    public static final RoundConfigNode<Boolean> ROLLBACK_ON_END = new RoundConfigNode<>(true);
    /**
     * Whether spawn points should be selected for {@link Challenger}s entering
     * rounds randomly. If <code>false</code>, spawn points will be selected
     * sequentially.
     *
     * <p><em>Default: <code>false</code></em></p>
     *
     * @since 1.0
     */
    public static final RoundConfigNode<Boolean> RANDOM_SPAWNING = new RoundConfigNode<>(false);

    private final UUID uuid;
    private final T defaultValue;

    protected ConfigNode(T defaultValue) {
        this.uuid = UUID.randomUUID();
        this.defaultValue = defaultValue;
    }

    /**
     * Returns this {@link ConfigNode}'s default value.
     *
     * @return This {@link ConfigNode}'s default value
     */
    public T getDefaultValue() {
        return this.defaultValue;
    }

    @Override
    public boolean equals(Object otherOption) {
        return otherOption instanceof ConfigNode && this.uuid.equals(((ConfigNode)otherOption).uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getClass(), uuid);
    }

}
