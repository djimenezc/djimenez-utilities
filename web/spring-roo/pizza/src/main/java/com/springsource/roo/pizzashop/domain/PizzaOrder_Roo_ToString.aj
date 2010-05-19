package com.springsource.roo.pizzashop.domain;

import java.lang.String;

privileged aspect PizzaOrder_Roo_ToString {
    
    public String PizzaOrder.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("Address: ").append(getAddress()).append(", ");
        sb.append("Total: ").append(getTotal()).append(", ");
        sb.append("DeliveryDate: ").append(getDeliveryDate()).append(", ");
        sb.append("Pizzas: ").append(getPizzas() == null ? "null" : getPizzas().size());
        return sb.toString();
    }
    
}
