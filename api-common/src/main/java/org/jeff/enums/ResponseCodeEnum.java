package org.jeff.enums;

/**
 * 响应编码枚举
 *
 * @author jeff
 * @since 1.0.0
 */
public enum ResponseCodeEnum {
    // 成功
    SUCCESS(200, "操作成功"),


    // 1*** 参数异常
    PARAM_ERROR(1001, "参数异常"),
    PARAM_NULL(1002, "参数为空"),
    PARAM_FORMAT(1003, "参数格式不正确"),
    PARAM_VALUE_FORMAT(1004, "参数值不正确"),


    // 2*** 系统异常
    SYSTEM_ERROR(2001, "服务异常"),
    UNKNOWN_ERROR(2002, "未知异常"),

    // 3*** 业务异常
    XXX(3001, "业务异常"),
    INSERT_FAILURE(3002, "新增失败"),
    UPDATE_FAILURE(3003, "更新失败"),
    DELETE_FAILURE(3004, "删除失败"),
    FILE_UPLOAD_FAILURE(3005, "文件上传失败");

    ResponseCodeEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * 枚举状态
     */
    private Integer status;

    /**
     * 消息
     */
    private String message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
