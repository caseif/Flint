package net.caseif.flint.api.round;

/**
 * Represents an immutable lifecycle stage of a {@link Round}.
 *
 * @since 0.1.0
 */
public final class LifecycleStage {

    private final String id;
    private final int duration;

    /**
     * Constructs a new {@link LifecycleStage} with the given ID and duration.
     *
     * @param id The stage's ID
     * @param duration The duration of the stage
     * @since 0.1.0
     */
    public LifecycleStage(String id, int duration) {
        this.id = id;
        this.duration = duration;
    }

    /**
     * Gets the ID of this {@link LifecycleStage}.
     *
     * @return The ID of this {@link LifecycleStage}
     * @since 0.1.0
     */
    public final String getId() {
        return this.id;
    }

    /**
     * Gets the duration of this {@link LifecycleStage}.
     *
     * @return The duration of this {@link LifecycleStage}
     */
    public final int getDuration() {
        return this.duration;
    }

}
