# Flint Implementation Guidelines

Flint is primarily self-documenting, though its specification includes certain
features which are not present in the API but should still be included by
implementations. Such features are specified in this document.

### Lobbies

Lobby signs are a way for players to easily see information about an arena as
well as join it themselves. Implementations should include a fully automated
lobby system as described below.

Lobby signs should be createable via a wizard, text-based, inventory-based, or
otherwise. Such a wizard should be well- and fully-documented. It should allow
players to easily customize their lobby signs with minimum knowledge. This
wizard should be initiated when a player places a sign containing the name of a
plugin utilizing Flint in square brackets in its first line.

Implementations should allow for two types of lobby signs: those which display
general information about a round, and those which display players currently in
the round. More types may be added, although they must be documented in full.

Informational lobby signs should contain general information about the round
including the name of the arena associated with the sign, current lifecycle
stage, the time remaining in the current lifecycle stage, and the current and
maximum number of players in the round.

Player-list signs should contain only a specific subset of players in the round.

### Minigame configuration

Implementaitons should provide functionality for each configuration node
contained by the
[`ConfigNode`](src/main/java/net/caseif/flint/config/ConfigNode.java) class. Each
node contains its own documentation, which should be noted and followed.

### Inventory Manipulation

When a player joins a round, their inventory should be automatically cleared by
the implementation and stored in a persistent format. When the player exits the
round, their inventory should be again automatically cleared and then restored
to its original state. In the event that it is impossible to restore the
inventory to its previous state (e.g. when a player exits a round by
disconnecting from the server), it should remain in persistent storage until it
is possible to.

### Footnote

This is an incomplete document, and will undergo changes as development of the
framework progresses.
