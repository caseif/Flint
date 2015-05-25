package net.caseif.flint.event.round;

import net.caseif.flint.round.LifecycleStage;

/**
 * Called when a {@link Round} changes its {@link LifecycleStage}.
 *
 * @author Max Roncacé
 * @since 1.0
 */
public interface RoundChangeLifecycleStageEvent extends RoundEvent {

    /**
     * Returns the {@link LifecycleStage} of the {@link Round} before the event.
     *
     * @return The {@link LifecycleStage} of the {@link Round} before the event
     * @since 1.0
     */
    LifecycleStage getStageBefore();

    /**
     * Returns the {@link LifecycleStage} of the {@link Round} before the event.
     *
     * @return The {@link LifecycleStage} of the {@link Round} before the event
     * @since 1.0
     */
    LifecycleStage getStageAfter();

}
