package org.lyon_yan.app.android.lib.epay;

/**
 * Created by yanni on 2016/2/14.
 */
public abstract class EpayResponseCode {
    private String code;
    private String msg;
    private String sub_code;
    private String sub_desc;
    /**
     * 是否结果成功
     */
    private boolean isCodeSuccess;
    /**
     * 是否访问成功
     */
    private boolean is_success = false;

    private String main_class_name;

    public String getMain_class_name() {
        return main_class_name;
    }

    public void setMain_class_name(String main_class_name) {
        this.main_class_name = main_class_name;
    }

    public boolean is_success() {
        return is_success;
    }

    public void setIs_success(boolean is_success) {
        this.is_success = is_success;
    }

    public boolean isCodeSuccess() {

        return isCodeSuccess;
    }

    public void setIsCodeSuccess(boolean isCodeSuccess) {
        this.isCodeSuccess = isCodeSuccess;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSub_code() {
        return sub_code;
    }

    public void setSub_code(String sub_code) {
        this.sub_code = sub_code;
    }

    public String getSub_desc() {
        return sub_desc;
    }

    public void setSub_desc(String sub_desc) {
        this.sub_desc = sub_desc;
    }
}
