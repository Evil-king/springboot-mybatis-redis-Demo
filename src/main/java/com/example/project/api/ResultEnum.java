
package com.example.project.api;

/**
 * @author wenqing
 * @version 1.0
 * @Description Controller层返回的统一结果对象信息码
 * @date 2015年8月31日 下午11:58:29
 */
public enum ResultEnum {
    SUCCESS(200, "成功"),// 成功
    ERROR(-999, "系统错误"),// 系统错误
    BAD_PARAM(-998, "参数错误"),// 参数错误
    NOT_FOUND(-997, "接口不存在"),// 接口不存在
    SERVIE_FAIL(-996, "服务调用失败"),// 服务调用失败
    BUSINESS_ERROE(-995, "业务异常"), // 默认服务层抛出异常的状态码,可细分下发具体服务的异常码
    ACCESS_TOKEN_ERROE(-994,"访问令牌错误或过期"),


    // 用户服务异常-100开始

    // 账户服务异常-200开始

    // 商品服务异常-300开始

    // 交易服务异常-400开始

    // 公共服务异常-500开始

    // 行情服务异常-600开始

    // 出入金服务异常-700开始
    ;

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据状态码获取到对应的提示信息
     *
     * @param code
     * @return
     */
    public static String getMsg(int code) {
        for (ResultEnum resultCodeMsg : values()) {
            if (resultCodeMsg.getCode() == code) {
                return resultCodeMsg.getMsg();
            }
        }
        return null;
    }
}
