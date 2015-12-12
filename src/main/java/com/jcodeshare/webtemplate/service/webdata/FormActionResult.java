package com.jcodeshare.webtemplate.service.webdata;

import com.jcodeshare.webtemplate.service.webdata.FormData;

public class FormActionResult {

    private String msg;
    private String code;
    private FormData formData;
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
   
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public FormData getFormData() {
        return formData;
    }

    public void setFormData(FormData formData) {
        this.formData = formData;
    }
        
    @Override
    public String toString() {
        return "{ \"msg\"= \"" + msg + "\", \"code\"=\"" + code + ", \"formData\"=\"" + formData + "\"}";
    }

}
