package com.springsource.roo.pizzashop.domain;

import java.lang.String;

privileged aspect Pizza_Roo_ToString {
    
    public String Pizza.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("Price: ").append(getPrice()).append(", ");
        sb.append("Toppings: ").append(getToppings() == null ? "null" : getToppings().size()).append(", ");
        sb.append("Base: ").append(getBase());
        return sb.toString();
    }
    
}
