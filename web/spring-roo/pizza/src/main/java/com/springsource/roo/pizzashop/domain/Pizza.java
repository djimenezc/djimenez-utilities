package com.springsource.roo.pizzashop.domain;

import javax.persistence.Entity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import com.springsource.roo.pizzashop.domain.Topping;
import java.util.HashSet;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import com.springsource.roo.pizzashop.domain.Base;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@RooJavaBean
@RooToString
@RooEntity(finders = { "findPizzasByBase" })
public class Pizza {

    @NotNull
    @Size(min = 2)
    private String name;

    private Float price;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Topping> toppings = new HashSet<Topping>();

    @ManyToOne(targetEntity = Base.class)
    @JoinColumn
    private Base base;
}