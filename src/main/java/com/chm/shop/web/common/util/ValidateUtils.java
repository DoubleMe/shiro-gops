package com.chm.shop.web.common.util;

import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.*;

/**
 * @author chen-hongmin
 * @since 2017/11/23 10:07
 */
public class ValidateUtils {


    private static Validator validator;

    static {

        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 校验参数
     * @param object
     * @param groups
     * @param <T>
     * @return
     */
    public static<T> Set<ConstraintViolation<T>> validate(T object, Class<?>... groups){

        return validator.validate(object, groups);
    }


    /**
     * 处理校验结果
     * 返回校验结果（不为null）
     * @param result
     */
    public static<T> List<String> process(Set<ConstraintViolation<T>> result) {

        if (CollectionUtils.isEmpty(result)){
            return Collections.EMPTY_LIST;
        }
        List<String> msg = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Iterator<ConstraintViolation<T>> iterator = result.iterator();

        while (iterator.hasNext()) {
            sb.delete(0, sb.length());
            ConstraintViolation<T> next = iterator.next();
            msg.add(next.getMessage());
        }

        return msg;
    }

    /**
     * 检验并处理结果
     * @param object
     * @param groups
     * @param <T>
     * @return
     */
    public static<T> List<String> validateAndProcess(T object, Class<?>... groups) {

        Set<ConstraintViolation<T>> validate = validate(object, groups);
        List<String> process = process(validate);

        return process;
    }
}
