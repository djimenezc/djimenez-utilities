package com.springsource.roo.pizzashop.domain;

import java.lang.String;

privileged aspect Base_Roo_ToString {
    
    public String Base.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Name: ").append(getName());
        return sb.toString();
    }
    
}
