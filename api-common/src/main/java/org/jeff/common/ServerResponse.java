package org.jeff.common;


import lombok.Data;
import org.jeff.enums.ResponseCodeEnum;

import java.io.Serializable;

/**
 * 响应模型数据结构
 *
 * @param <T>
 * @author jeff
 * @since 1.0.0
 */
@Data
public class ServerResponse<T> implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -9219537639430264401L;

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 响应状态码
     */
    public Integer status;

    /**
     * 描述信息
     */
    private String message;

    /**
     * 响应结果数据
     */
    private T data;


    /**
     * 成功
     *
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> success() {
        return new ServerResponse<>(Boolean.TRUE, ResponseCodeEnum.SUCCESS.getStatus());
    }

    public static <T> ServerResponse<T> success(String message) {
        return new ServerResponse<>(Boolean.TRUE, ResponseCodeEnum.SUCCESS.getStatus(), message);
    }

    public static <T> ServerResponse<T> success(T data) {
        return new ServerResponse<>(Boolean.TRUE, ResponseCodeEnum.SUCCESS.getStatus(), data);
    }

    public static <T> ServerResponse<T> success(String message, T data) {
        return new ServerResponse<>(Boolean.TRUE, ResponseCodeEnum.SUCCESS.getStatus(), message, data);
    }

    /**
     * 失败
     *
     * @param status  状态码
     * @param message 描述
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> failure(Integer status, String message) {
        return new ServerResponse<>(Boolean.FALSE, status, message);
    }

    public static <T> ServerResponse<T> failure(ResponseCodeEnum codeEnum) {
        return failure(codeEnum.getStatus(), codeEnum.getMessage());
    }

    public ServerResponse() {
    }

    public ServerResponse(Boolean success, Integer status) {
        this.success = success;
        this.status = status;
    }

    public ServerResponse(Boolean success, Integer status, String message) {
        this.success = success;
        this.status = status;
        this.message = message;
    }

    public ServerResponse(Boolean success, Integer status, T data) {
        this.success = success;
        this.status = status;
        this.data = data;
    }

    public ServerResponse(Boolean success, Integer status, String message, T data) {
        this.success = success;
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
