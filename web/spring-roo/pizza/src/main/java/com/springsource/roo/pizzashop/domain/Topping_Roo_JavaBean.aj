package com.springsource.roo.pizzashop.domain;

import java.lang.String;

privileged aspect Topping_Roo_JavaBean {
    
    public String Topping.getName() {
        return this.name;
    }
    
    public void Topping.setName(String name) {
        this.name = name;
    }
    
}
