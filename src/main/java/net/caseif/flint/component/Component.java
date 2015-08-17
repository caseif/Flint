package net.caseif.flint.component;

import net.caseif.flint.component.exception.OrphanedComponentException;

/**
 * Represents an object which is owned by a {@link ComponentOwner}.
 *
 * <p>All {@link Component}s are inherently orphanable. An object is considered
 * orphaned when it is dissociated from its parent container, leaving it for all
 * intents and purposes obsolete. Orphaned objects will throw an
 * {@link OrphanedComponentException} in response to any defined method being
 * invoked upon them.</p>
 *
 * @param <H> The {@link ComponentOwner} type this {@link Component} is owned
 *     by
 * @since 1.0
 */
public interface Component<H extends ComponentOwner> {

    /**
     * Gets the {@link ComponentOwner owner} of this object.
     *
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @return The {@link ComponentOwner owner} of this object
     * @since 1.0
     */
    H getOwner() throws OrphanedComponentException;

}
