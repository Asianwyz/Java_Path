package Improve.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 描述需要执行的类名，和方法名
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface ProAnno {
    String className();
    String methodName();
}
