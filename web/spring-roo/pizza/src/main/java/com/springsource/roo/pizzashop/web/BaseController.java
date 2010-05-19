package com.springsource.roo.pizzashop.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.springsource.roo.pizzashop.domain.Base;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "base", automaticallyMaintainView = true, formBackingObject = Base.class)
@RequestMapping("/base/**")
@Controller
public class BaseController {
}
