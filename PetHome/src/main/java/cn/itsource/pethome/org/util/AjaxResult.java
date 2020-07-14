package cn.itsource.pethome.org.util;

import lombok.Data;

import java.io.Serializable;

/**
 * success成功与否
 * message失败原因
 */
@Data
public class AjaxResult {
    private boolean success = true;
    private String message = "操作成功!";
    private Object resultObj;
    private Serializable sessionId;

    //默认成功
    public boolean isSuccess(){
        return this.success;
    }
    //是否成功，信息，对象
    public AjaxResult(boolean success, String message, Object resultObj) {
        this.success = success;
        this.message = message;
        this.resultObj = resultObj;
    }
    public AjaxResult setSuccess(boolean success){
        this.success=success;
        return this;
    }
    public AjaxResult setMessage(String message){
        this.message=message;
        return this;
    }
    public AjaxResult setResultObj(Object resultObj){
        this.resultObj=resultObj;
        return this;
    }

    public AjaxResult() {
    }
    //默认成功
    public static AjaxResult me(){
        return new AjaxResult();
    }
}
