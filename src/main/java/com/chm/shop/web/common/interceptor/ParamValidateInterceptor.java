package com.chm.shop.web.common.interceptor;

import com.chm.shop.app.common.anno.MyValid;
import com.chm.shop.app.util.ResponseUtils;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.lang.reflect.Parameter;
import java.util.*;

/**
 * @author chen-hongmin
 * @Type ParamValidateInterceptor
 * @Desc 参数验证拦截器
 * @date 2016-10-25
 * @Version V1.0
 */
public class ParamValidateInterceptor implements MethodInterceptor {

    private final static Logger LOGGER = LoggerFactory.getLogger(ParamValidateInterceptor.class);
    //换行
    private static final String lineSeparator;

    static {
        String ls = System.getProperty("line.separator"); //$NON-NLS-1$
        if (ls == null) {
            ls = "\n"; //$NON-NLS-1$
        }
        lineSeparator = ls;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Parameter[] parameters = invocation.getMethod().getParameters();
        Object[] arguments = invocation.getArguments();

        if (parameters == null || parameters.length == 0) {
            return invocation.proceed();
        }


        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Object>> set = null;
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];

            MyValid anno = parameter.getAnnotation(MyValid.class);
            if (anno == null) {
                continue;
            }
            Class<?>[] groups = anno.groups();
            Object argument = arguments[i];
            if (set == null) {
                set = validator.validate(argument,groups);
            } else {
                set.addAll(validator.validate(argument ,groups));
            }
        }

        if (set != null && !set.isEmpty()) {
            List<String> msg = process(set);

            return ResponseUtils.failResponse(msg.get(0));
        }

        return invocation.proceed();
    }

    /**
     * 处理校验结果
     *
     * @param result
     */
    private List<String> process(Set<ConstraintViolation<Object>> result) {

        List<String> msg = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Iterator<ConstraintViolation<Object>> iterator = result.iterator();

        while (iterator.hasNext()) {
            sb.delete(0, sb.length());
            ConstraintViolation<Object> next = iterator.next();
            sb.append("参数校验失败：").append(next.getRootBean())
                    .append("#filed : ").append(next.getPropertyPath())
                    .append("---").append(next.getMessage());
            sb.append(lineSeparator);

            msg.add(next.getMessage());
            LOGGER.info(sb.toString());
        }

        return msg;
    }
}
