package com.chm.shop.app.common.anno;

import com.chm.shop.app.common.enums.SystemModuleEnum;
import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * @author chen-hongmin
 * @since 2017/11/7 17:49
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface SysLog {

    String message() default "";

    SystemModuleEnum module();
}
