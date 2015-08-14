package net.caseif.flint.util.annotation;

import net.caseif.flint.exception.OrphanedObjectException;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation indicating that objects of a particular type are capable of being
 * orphaned. An object is considered orphaned when it is dissociated from its
 * parent container, leaving it for all intents and purposes obsolete. Orphaned
 * objects will throw an {@link OrphanedObjectException} in response to any
 * defined method being invoked upon them.
 *
 * @author Max Roncacé
 * @since 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Orphanable {
}
