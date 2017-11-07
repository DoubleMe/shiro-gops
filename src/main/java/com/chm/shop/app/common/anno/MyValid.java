package com.chm.shop.app.common.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author chen-hongmin
 * @since 2017/10/31 14:57
 */
@Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface MyValid {

    Class<?>[] groups() default {};
}
