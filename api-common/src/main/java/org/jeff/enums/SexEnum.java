package org.jeff.enums;

/**
 * 性别枚举
 */
public enum SexEnum {

    SCREEN(0, "保密"),
    MAN(1, "男"),
    WOMAN(2, "女");

    private final Integer type;

    private final String value;

    SexEnum(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
