package com.neotys.gremlin.common.datamodel.jsonattack;

public enum TargetSelectionTypeEnum {
    PERCENT("percent"),

    EXACT("exact");

    private String value;

    TargetSelectionTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static TargetSelectionTypeEnum fromValue(String text) {
        for (TargetSelectionTypeEnum b : TargetSelectionTypeEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
