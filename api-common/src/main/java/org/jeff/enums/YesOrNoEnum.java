package org.jeff.enums;

public enum YesOrNoEnum {

    NO(0, "否"),
    YES(1, "是")
    ;

    private final Integer type;

    private final String value;

    YesOrNoEnum(Integer type, String value) {
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
