package com.springsource.roo.pizzashop.domain;

import org.springframework.beans.factory.annotation.Configurable;

privileged aspect Pizza_Roo_Configurable {
    
    declare @type: Pizza: @Configurable;
    
}
