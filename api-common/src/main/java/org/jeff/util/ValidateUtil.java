package org.jeff.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * 校验工具类
 *
 * @author jeff
 * @since 1.0.0
 */
public class ValidateUtil {

    /**
     * 校验器
     */
    public static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 参数校验
     */
    public static <T> void validate(T object, Class... groups) {
        Set<ConstraintViolation<T>> validate = validator.validate(object, groups);

        if (validate != null && !validate.isEmpty()) {
            StringBuilder exceptionMessage = new StringBuilder();
            validate.forEach(constraintViolation -> {
                exceptionMessage.append(constraintViolation.getMessage());
            });

            throw new RuntimeException(exceptionMessage.toString());
        }
    }
}
