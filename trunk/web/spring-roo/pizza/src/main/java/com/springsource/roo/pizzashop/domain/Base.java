package com.springsource.roo.pizzashop.domain;

import javax.persistence.Entity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@RooJavaBean
@RooToString
@RooEntity
public class Base {

    @NotNull
    @Size(min = 2)
    private String name;
}
