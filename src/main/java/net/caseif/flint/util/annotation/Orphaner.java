package net.caseif.flint.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates a method which, when invoked, will orphan one or more
 * {@link Orphanable} objects
 *
 * @author Max Roncacé
 * @since 1.0
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface Orphaner {
}
