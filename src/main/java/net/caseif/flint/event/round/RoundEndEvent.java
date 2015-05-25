package net.caseif.flint.event.round;

/**
 * Called when a {@link Round} ends.
 *
 * @author Max Roncacé
 * @since 1.0
 */
public interface RoundEndEvent extends RoundEvent {

    /**
     * Returns whether the {@link Round} was ended by the framework due to the
     * timer expiring.
     *
     * @return Whether the {@link Round} was ended by the framework due to the
     *         timer expiring
     * @since 1.0
     */
    boolean isNatural();

}
