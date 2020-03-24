package com.nero.mybatis.typehandler.domain;

/**
 * 性别的枚举类
 */
public enum SexEnum {
    MALE(1, "男"),
    FEMALE(0, "女");

    private int id;
    private String name;

    private SexEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //根据id获取枚举
    public static SexEnum getSexEnumById(int id) {
        for (SexEnum e : SexEnum.values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
