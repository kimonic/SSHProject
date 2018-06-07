package mspring4.S_3_1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义限定符注解
 */
@Target({ElementType.CONSTRUCTOR,
        ElementType.FIELD,
        ElementType.METHOD,
        ElementType.TYPE,
})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Cold {
}
