package com.chm.shop.web.common.interceptor;

import com.chm.shop.app.common.anno.MyValid;
import com.chm.shop.app.constants.SystemConstants;
import com.chm.shop.app.util.JsonUtils;
import com.chm.shop.app.util.ResponseUtils;
import com.chm.shop.web.common.exception.ParamValidException;
import com.chm.shop.web.common.util.ValidateUtils;
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


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Parameter[] parameters = invocation.getMethod().getParameters();
        Object[] arguments = invocation.getArguments();

        if (parameters == null || parameters.length == 0) {
            return invocation.proceed();
        }

        List<String> message = new ArrayList<>();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];

            MyValid valid = parameter.getAnnotation(MyValid.class);
            if (valid == null) {
                continue;
            }
            Class<?>[] groups = valid.groups();
            Object argument = arguments[i];
            message.addAll(ValidateUtils.validateAndProcess(argument, groups));
        }

        if (!message.isEmpty()) {

            throw new ParamValidException(JsonUtils.ObjToJson(message));
        }

        return invocation.proceed();
    }


}
