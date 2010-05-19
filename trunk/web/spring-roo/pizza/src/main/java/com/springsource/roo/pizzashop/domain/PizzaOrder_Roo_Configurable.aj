package com.springsource.roo.pizzashop.domain;

import org.springframework.beans.factory.annotation.Configurable;

privileged aspect PizzaOrder_Roo_Configurable {
    
    declare @type: PizzaOrder: @Configurable;
    
}
