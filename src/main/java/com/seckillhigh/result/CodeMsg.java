package com.seckillhigh.result;

public class CodeMsg {
    private int code;
    private String msg;

    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * General Error Message
     */
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "server error");
    public static CodeMsg BIND_ERROR = new CodeMsg(500102, "data bind error: %s");

    // Login Module Message
    public static CodeMsg PASSCODE_ERROR = new CodeMsg(500215, "password error");
    public static CodeMsg NO_USER_ERROR = new CodeMsg(500214, "no user exist");
    public static CodeMsg NO_ITEM_ERROR = new CodeMsg(500213, "no item exist");

    // Item Module Message

    // Order Module Message

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public CodeMsg fillArgs(Object... args){
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }
}
