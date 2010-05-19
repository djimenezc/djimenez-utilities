package com.springsource.roo.pizzashop.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.springsource.roo.pizzashop.domain.Topping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "topping", automaticallyMaintainView = true, formBackingObject = Topping.class)
@RequestMapping("/topping/**")
@Controller
public class ToppingController {
}
