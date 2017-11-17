package org.star4j.cloudshopper.enums;

import lombok.Getter;

/**
 * @Author: WuYL
 * @Description:
 * @Date: Create in 2017/11/5 22:04
 * @Modified By:
 */
@Getter
public enum ResultState {


    RESULT_SUCCESS(0, "成功"),

    RESULT_ERROR(1, "系统未知错误"),

    RESULT_FALLBACKERROR(1001, "断路器启动调用 FALLBACK");

    private Integer code;

    private String message;

    ResultState(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
