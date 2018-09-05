package com.base;

/**
 * 1.它可以和类一样有自己的field和method    
 * 2.它的对象只能在所有的语法单元出现前定义，且为public static final的Field
 * 3.注意values方法
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Json
 * @since 1.0.0
 */
public enum UserTypeEnum {

    ADMIN(1, "超级管理员"), MEMBER(2, "普通用户"), ACQUITAINCE(3, "外来人员");

    private final int    type;
    private final String name;

    private UserTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public static String getNameByType(int type) {
        for (UserTypeEnum u : UserTypeEnum.values()) {
            System.out.println(u.name + "'s valye is:" + UserTypeEnum.valueOf(u.name));
            if (u.type == type) {
                return u.getName();
            }
        }
        throw new IllegalArgumentException("No such type:" + type);
    }

    public static void main(String[] args) {
        System.out.println(UserTypeEnum.getNameByType(1));
    }

}
