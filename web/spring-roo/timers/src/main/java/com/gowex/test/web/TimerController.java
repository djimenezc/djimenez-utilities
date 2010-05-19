package com.gowex.test.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import com.gowex.test.Timer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "timer", automaticallyMaintainView = true, formBackingObject = Timer.class)
@RequestMapping("/timer/**")
@Controller
public class TimerController {
}
