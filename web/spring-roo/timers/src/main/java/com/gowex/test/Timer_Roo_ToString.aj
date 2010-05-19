package com.gowex.test;

import java.lang.String;

privileged aspect Timer_Roo_ToString {
    
    public String Timer.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Message: ").append(getMessage());
        return sb.toString();
    }
    
}
