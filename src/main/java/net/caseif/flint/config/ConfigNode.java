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
package net.caseif.flint.config;

import net.caseif.flint.arena.Arena;
import net.caseif.flint.arena.SpawningMode;
import net.caseif.flint.challenger.Challenger;
import net.caseif.flint.challenger.Team;
import net.caseif.flint.event.lobby.PlayerClickLobbySignEvent;
import net.caseif.flint.lobby.LobbySign;
import net.caseif.flint.minigame.Minigame;
import net.caseif.flint.round.LifecycleStage;
import net.caseif.flint.round.Round;
import net.caseif.flint.util.physical.Boundary;

import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
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
     * non-spectators. If true, spectators will see all messages, but
     * non-spectators will not see messages sent by spectators.
     *
     * <p><strong>Default:</strong> {@code true}</p>
     *
     * @since 1.0
     */
    public static final RoundConfigNode<Boolean> WITHHOLD_SPECTATOR_CHAT = new RoundConfigNode<>(true);

    /**
     * Whether {@link Round}s shall be rolled back by default upon ending.
     *
     * <p><strong>Default:</strong> {@code true}</p>
     *
     * @since 1.0
     */
    public static final RoundConfigNode<Boolean> ROLLBACK_ON_END = new RoundConfigNode<>(true);

    /**
     * The mode which should be used when selecting spawn points. (See
     * {@link SpawningMode} for more information.)
     *
     * <p><strong>Default:</strong> {@link SpawningMode#SEQUENTIAL}</p>
     *
     * @since 1.1
     */
    public static final RoundConfigNode<SpawningMode> SPAWNING_MODE = new RoundConfigNode<>(SpawningMode.SEQUENTIAL);

    /**
     * Whether spawn points should be selected for {@link Challenger}s entering
     * rounds randomly. If {@code false}, spawn points will be selected
     * sequentially.
     *
     * <p><strong>Default:</strong> {@code false}</p>
     *
     * @since 1.0
     * @deprecated Use {@link ConfigNode#SPAWNING_MODE}
     */
    @Deprecated
    public static final RoundConfigNode<Boolean> RANDOM_SPAWNING = new RoundConfigNode<>(false);

    /**
     * A {@link Set} of commands forbidden from use by player entered into
     * minigame {@link Round}s.
     *
     * <p><strong>Default:</strong> empty set</p>
     *
     * @since 1.1
     */
    // I truly have no idea why I need to cast HashSet to Set for this declaration to work. Fucking generics.
    // Okay, I now realize my mistake, but now I'm not sure if fixing it constitutes a breaking binary change.
    public static final RoundConfigNode<Set<String>> FORBIDDEN_COMMANDS
            = new RoundConfigNode<>((Set<String>) new HashSet<String>());

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
