package com.ninjaduoduo.common.model;

public enum ErrorCode {
    SUCCESS(0);
    private int code;
    private String desc;

    ErrorCode(int code) {
        this.code = code;
        this.desc = name();
    }

    ErrorCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return name();
    }

    public String getDesc() {
        return this.desc;
    }

    static public ErrorCode fromCode(int code) {
        for (ErrorCode errorCode : values()) {
            if (code == errorCode.getCode()) {
                return errorCode;
            }
        }

        throw new IllegalArgumentException("Code not exist.");
    }

    static public ErrorCode fromString(String name) {
        for (ErrorCode errorCode : values()) {
            if (name.equalsIgnoreCase(errorCode.name())) {
                return errorCode;
            }
        }

        throw new IllegalArgumentException("Code not exist.");
    }

}
