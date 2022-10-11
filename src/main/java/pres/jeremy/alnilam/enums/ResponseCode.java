package pres.jeremy.alnilam.enums;


import pres.jeremy.alnilam.support.IMessageCode;
import pres.jeremy.alnilam.utils.RequestUtil;

public enum ResponseCode implements IMessageCode {

    OPERATE_SUCCESS(1, "OPERATE_SUCCESS"),

    OPERATE_FAILED(-1, "OPERATE_FAILED"),

    /**
     * 请求异常
     */
    REQUEST_ERROR(1000, "REQUEST_ERROR"),

    /**
     * 当前用户登录信息有误
     */
    LOGIN_ERROR(1001, "LOGIN_ERROR"),

    /**
     * 场站不存在
     */
    WP_NOT_EXISTS(1002, "WP_NOT_EXISTS"),

    /**
     * 无值，不能进行查询
     */
    EMPTY_RESULT_BREAK_QUERY(1003, "EMPTY_RESULT_BREAK_QUERY");

    private int code;
    private String msg;

    ResponseCode() {
    }

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String msg() {
        return msg;
    }

    @Override
    public String toString() {
        return msg;
    }

    @Override
    public String message() {
        return msg();
    }
}
