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

import net.caseif.flint.arena.Arena;
import net.caseif.flint.event.lobby.PlayerClickLobbySignEvent;
import net.caseif.flint.lobby.LobbySign;
import net.caseif.flint.minigame.Minigame;
import net.caseif.flint.round.LifecycleStage;
import net.caseif.flint.round.Round;
import net.caseif.flint.challenger.Challenger;
import net.caseif.flint.challenger.Team;
import net.caseif.flint.util.physical.Boundary;

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
     * <p><strong>Default:</strong> An empty {@link ImmutableSet}</p>
     *
     * @since 1.0
     */
    public static final ConfigNode<ImmutableSet<LifecycleStage>> DEFAULT_LIFECYCLE_STAGES
            = new ConfigNode<>(ImmutableSet.<LifecycleStage>of());

    /**
     * Whether the integrated lobby wizard is enabled for a {@link Minigame}.
     *
     * <p>When enabled, the lobby wizard will be available to in-game players
     * with the permission nodes {@code <minigame name>.lobby.create},
     * {@code <minigame name>.lobby.*}, or {@code <minigame name>.*}, or with
     * server operator status. It will be activated when a sign is placed in the
     * world with the first line being the {@link Minigame}'s name within square
     * brackets ("[" and "]") and guide the player through the process of
     * creating the sign.</p>
     *
     * <p><strong>Defualt:</strong> {@code true}</p>
     *
     * @since 1.0
     */
    public static final ConfigNode<Boolean> ENABLE_LOBBY_WIZARD = new ConfigNode<>(true);

    /**
     * Whether an in-game player must be sneaking in order to destroy a physical
     * {@link LobbySign}.
     *
     * <p>If {@code true}, left-clicking the lobby sign without sneaking will
     * not break it, regardless of gamemode or permissions. Rather, a
     * {@link PlayerClickLobbySignEvent} will be called.</p>
     *
     * <p>If {@code false}, the sign will not be prevented from breaking, and if
     * broken, the sign will be unregistered and an event will not be called.
     * </p>
     *
     * <p><strong>Default:</strong> true</p>
     *
     * @since 1.0
     */
    public static final ConfigNode<Boolean> REQUIRE_SNEAK_TO_DESTROY_LOBBY = new ConfigNode<>(true);

    // ROUND CONFIG NODES
    /**
     * The maximum permitted player count.
     *
     * <p><strong>Default:</strong> {@code 32}</p>
     *
     * @since 1.0
     */
    public static final RoundConfigNode<Integer> MAX_PLAYERS = new RoundConfigNode<>(32);

    /**
     * Whether {@link Challenger}s are permitted to physically leave their
     * {@link Arena}s' {@link Boundary Boundaries}. If {@code false} (default),
     * they will be unconditionally forbidden from physically exiting the
     * boundary region while in a {@link Round}. If {@code true}, they will be
     * removed from the {@link Round} upon leaving.
     *
     * <p><strong>Default:</strong> {@code false}</p>
     *
     * @since 1.0
     */
    public static final RoundConfigNode<Boolean> ALLOW_EXIT_BOUNDARY = new RoundConfigNode<>(false);

    /**
     * Whether {@link Challenger}s are permitted to damage one another.
     *
     * <p><strong>Default:</strong> {@code true}</p>
     *
     * @since 1.0
     */
    public static final RoundConfigNode<Boolean> ALLOW_DAMAGE = new RoundConfigNode<>(true);

    /**
     * Whether {@link Challenger}s are permitted to damage teammates.
     *
     * <p><strong>Default:</strong> {@code true}</p>
     *
     * @since 1.0
     */
    public static final RoundConfigNode<Boolean> ALLOW_FRIENDLY_FIRE = new RoundConfigNode<>(true);

    /**
     * Whether {@link Team}s are to use separate chat channels.
     *
     * <p><strong>Default:</strong> {@code false}</p>
     *
     * @since 1.0
     */
    public static final RoundConfigNode<Boolean> SEPARATE_TEAM_CHATS = new RoundConfigNode<>(false);

    /**
     * Whether {@link Round}s are to use separate chat channels.
     *
     * <p><strong>Default:</strong> {@code true}</p>
     *
     * @since 1.0
     */
    public static final RoundConfigNode<Boolean> SEPARATE_ROUND_CHATS = new RoundConfigNode<>(true);

    /**
     * Whether messages sent by spectators are to be withheld from
     * non-spectators. If true, spectators will be able to see messages sent by
     * non-spectators, but not vice-versa.
     *
     * <p><strong>Default:</strong> {@code false}</p>
     *
     * @since 1.0
     */
    public static final RoundConfigNode<Boolean> ISOLATE_SPECTATOR_MESSAGES = new RoundConfigNode<>(true);

    /**
     * Whether {@link Round}s shall be rolled back by default upon ending.
     *
     * <p><strong>Default:</strong> {@code true}</p>
     *
     * @since 1.0
     */
    public static final RoundConfigNode<Boolean> ROLLBACK_ON_END = new RoundConfigNode<>(true);

    /**
     * Whether spawn points should be selected for {@link Challenger}s entering
     * rounds randomly. If {@code false}, spawn points will be selected
     * sequentially.
     *
     * <p><strong>Default:</strong> {@code false}</p>
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
     * @since 1.0
     */
    public T getDefaultValue() {
        return this.defaultValue;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof ConfigNode && this.uuid.equals(((ConfigNode) other).uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getClass(), uuid);
    }

}
