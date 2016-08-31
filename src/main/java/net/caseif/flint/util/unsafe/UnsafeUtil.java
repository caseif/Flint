package net.caseif.flint.util.unsafe;

import net.caseif.flint.lobby.populator.LobbySignPopulator;

/**
 * A collection of utilities for internal use which generally cannot be relied
 * upon to exhibit consistent behavior across API revisions. This class may not
 * be used outside the Flint engine - methods will throw an
 * {@link IllegalStateException} if invoked externally.
 */
public abstract class UnsafeUtil {

    protected static UnsafeUtil INSTANCE;

    public static UnsafeUtil instance() {
        return INSTANCE;
    }

    public abstract LobbySignPopulator getDefaultStatusLobbySignPopulator();

    public abstract LobbySignPopulator getDefaultChallengerListingLobbySignPopulator();

}
