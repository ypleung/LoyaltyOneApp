package com.jcodeshare.webtemplate.service.webdata;

import java.util.List;
import com.jcodeshare.webtemplate.service.webdata.FormData;
import com.jcodeshare.webtemplate.data.model.Comments;


public class FormActionResult {

    private String msg;
    private String code;
    private FormData formData;
    private List<Comments> comments;
    
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
    
    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }
    
        
    @Override
    public String toString() {
        return "{ \"msg\"= \"" + msg + "\", \"code\"=\"" + code + ", \"formData\"=\"" + formData + "\"}";
    }

}
