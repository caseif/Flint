package net.caseif.flint.util;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * A {@link LinkedHashSet} which may not be modified. Calls to mutators will
 * throw {@link UnsupportedOperationException}s.
 *
 * @param <T> The object type this {@link ImmutableLinkedHashSet} will contain
 * @since 1.0
 */
public class ImmutableLinkedHashSet<T> extends LinkedHashSet<T> {

    private ImmutableLinkedHashSet(LinkedHashSet<T> handle) {
        super(handle);
    }

    /**
     * Creates a new {@link ImmutableLinkedHashSet} from the contents of the
     * given {@link LinkedHashSet}.
     *
     * @param set The {@link LinkedHashSet} to copy the contents of
     * @param <T> The type of objects to be contained by the new
     *            {@link ImmutableLinkedHashSet}
     * @return The newly created {@link ImmutableLinkedHashSet}
     * @since 1.0
     */
    public static <T> ImmutableLinkedHashSet<T> copyOf(LinkedHashSet<T> set) {
        return new ImmutableLinkedHashSet<>(set);
    }

    /**
     * Mutators are unsupported by this implementation.
     *
     * @throws UnsupportedOperationException Unconditionally
     * @since 1.0
     */
    @Override
    public boolean add(T e) {
        throw new UnsupportedOperationException();
    }

    /**
     * Mutators are unsupported by this implementation.
     *
     * @throws UnsupportedOperationException Unconditionally
     * @since 1.0
     */
    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    /**
     * Mutators are unsupported by this implementation.
     *
     * @throws UnsupportedOperationException Unconditionally
     * @since 1.0
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    /**
     * Mutators are unsupported by this implementation.
     *
     * @throws UnsupportedOperationException Unconditionally
     * @since 1.0
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    /**
     * Mutators are unsupported by this implementation.
     *
     * @throws UnsupportedOperationException Unconditionally
     * @since 1.0
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    /**
     * Mutators are unsupported by this implementation.
     *
     * @throws UnsupportedOperationException Unconditionally
     * @since 1.0
     */
    public void clear() {
        throw new UnsupportedOperationException();
    }

}
