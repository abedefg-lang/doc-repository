package pers.tom.docwarehouse.model.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

/**
 * @author lijia
 * @description 文档权限类型
 * @date 2021-01-29 17:33
 */
public enum DocumentPermissionType implements IEnum<Integer> {

    /**只读权限*/
    READ_ONLY(1, "只读"),

    /**可写权限*/
    WRITABLE(2, "可写");

    private final Integer value;

    private final String message;

    DocumentPermissionType(Integer value, String message){
        this.value = value;
        this.message = message;
    }

    @Override
    public Integer getValue() {

        return this.value;
    }

    public String getMessage() {
        return message;
    }
}
