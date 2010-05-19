package com.gowex.test;

import java.lang.String;

privileged aspect Timer_Roo_JavaBean {
    
    public String Timer.getMessage() {
        return this.message;
    }
    
    public void Timer.setMessage(String message) {
        this.message = message;
    }
    
}
