package com.springsource.roo.pizzashop.domain;

import java.lang.String;

privileged aspect Topping_Roo_ToString {
    
    public String Topping.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Name: ").append(getName());
        return sb.toString();
    }
    
}