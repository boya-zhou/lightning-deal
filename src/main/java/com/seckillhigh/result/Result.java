package com.seckillhigh.result;

public class Result<T> {

    private int code;
    private String msg;
    private T data;

    /**
     * Constructor called by success method
     *
     * @param data
     */
    public Result(CodeMsg codeMsg, T data) {
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
        this.data = data;
    }

    /**
     * Constructor called by error method
     *
     * @param codeMsg
     */
    public Result(CodeMsg codeMsg) {
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
        this.data = null;
    }

    /**
     * When success, call this method
     *
     * @param data
     * @return
     */
    public static <T> Result<T> success(CodeMsg codeMsg, T data) {
        return new Result<T>(codeMsg, data);
    }

    /**
     * When it contains error, call this method
     *
     * @param codeMsg
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(CodeMsg codeMsg) {

        if (codeMsg == null) {
            return null;
        } else {
            return new Result<T>(codeMsg);
        }
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
