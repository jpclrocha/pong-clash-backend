package com.jopezin.pongclash.domain.enums;

public enum Category {
    DIVISAO_1(1),
    DIVISAO_2(2),
    DIVISAO_3(3),
    DIVISAO_4(4),
    DIVISAO_5(5);

    private int code;

    private Category(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }

    public static Category valueOf(int code){
        for(Category value : Category.values()){
            if(value.getCode() == code){
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid category code");
    }

}
