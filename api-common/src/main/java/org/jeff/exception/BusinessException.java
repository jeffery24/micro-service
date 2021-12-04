package org.jeff.exception;


import org.jeff.enums.ResponseCodeEnum;

/**
 * 业务类异常
 *
 * @author jeff
 * @since 1.0.0
 */
public class BusinessException extends RuntimeException {

    private final Integer code;

    /**
     * 根据枚构造业务类异常
     *
     * @param error
     */
    public BusinessException(ResponseCodeEnum error) {
        super(error.getMessage());
        this.code = error.getStatus();
    }


    /**
     * 自定义消息体构造业务类异常
     *
     * @param error
     * @param message
     */
    public BusinessException(ResponseCodeEnum error, String message) {
        super(message);
        this.code = error.getStatus();
    }


    /**
     * 根据异常构造业务类异常
     *
     * @param error
     * @param cause
     */
    public BusinessException(ResponseCodeEnum error, Throwable cause) {
        super(cause);
        this.code = error.getStatus();
    }

    public Integer getCode() {
        return code;
    }
}
