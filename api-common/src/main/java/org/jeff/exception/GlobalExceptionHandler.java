package org.jeff.exception;


import lombok.extern.slf4j.Slf4j;
import org.jeff.common.ServerResponse;
import org.jeff.enums.ResponseCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常统一处理器
 *
 * @author jeff
 * @since 1.0.0
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public ServerResponse businessException(BusinessException e) {
        log.info("捕捉到业务类异常: ", e);
        return ServerResponse.failure(e.getCode(), e.getMessage());
    }

    /**
     * 拦截运行时异常
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public ServerResponse runtimeException(RuntimeException e) {
        log.info("捕捉到运行时异常: ", e);
        return ServerResponse.failure(ResponseCodeEnum.UNKNOWN_ERROR.getStatus(), e.getMessage());
    }


    /**
     * 拦截系统级异常
     *
     * @param th
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Throwable.class)
    public ServerResponse errorException(Throwable th) {
        log.info("捕捉到系统级别异常: " + th);
        return ServerResponse.failure(ResponseCodeEnum.SYSTEM_ERROR.getStatus(), th.getMessage());
    }


}
