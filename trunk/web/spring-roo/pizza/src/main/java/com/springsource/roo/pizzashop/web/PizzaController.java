package com.springsource.roo.pizzashop.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.springsource.roo.pizzashop.domain.Pizza;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "pizza", automaticallyMaintainView = true, formBackingObject = Pizza.class)
@RequestMapping("/pizza/**")
@Controller
public class PizzaController {
}
