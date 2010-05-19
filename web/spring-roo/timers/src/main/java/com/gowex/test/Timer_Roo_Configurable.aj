package com.gowex.test;

import org.springframework.beans.factory.annotation.Configurable;

privileged aspect Timer_Roo_Configurable {
    
    declare @type: Timer: @Configurable;
    
}
