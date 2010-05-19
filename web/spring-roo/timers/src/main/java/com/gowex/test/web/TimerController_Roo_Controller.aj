package com.gowex.test.web;

import com.gowex.test.Timer;
import java.lang.Long;
import java.lang.String;
import javax.validation.Valid;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

privileged aspect TimerController_Roo_Controller {
    
    @RequestMapping(value = "/timer", method = RequestMethod.POST)
    public String TimerController.create(@Valid Timer timer, BindingResult result, ModelMap modelMap) {
        if (timer == null) throw new IllegalArgumentException("A timer is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("timer", timer);
            return "timer/create";
        }
        timer.persist();
        return "redirect:/timer/" + timer.getId();
    }
    
    @RequestMapping(value = "/timer/form", method = RequestMethod.GET)
    public String TimerController.createForm(ModelMap modelMap) {
        modelMap.addAttribute("timer", new Timer());
        return "timer/create";
    }
    
    @RequestMapping(value = "/timer/{id}", method = RequestMethod.GET)
    public String TimerController.show(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("timer", Timer.findTimer(id));
        return "timer/show";
    }
    
    @RequestMapping(value = "/timer", method = RequestMethod.GET)
    public String TimerController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, ModelMap modelMap) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            modelMap.addAttribute("timers", Timer.findTimerEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Timer.countTimers() / sizeNo;
            modelMap.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            modelMap.addAttribute("timers", Timer.findAllTimers());
        }
        return "timer/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String TimerController.update(@Valid Timer timer, BindingResult result, ModelMap modelMap) {
        if (timer == null) throw new IllegalArgumentException("A timer is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("timer", timer);
            return "timer/update";
        }
        timer.merge();
        return "redirect:/timer/" + timer.getId();
    }
    
    @RequestMapping(value = "/timer/{id}/form", method = RequestMethod.GET)
    public String TimerController.updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("timer", Timer.findTimer(id));
        return "timer/update";
    }
    
    @RequestMapping(value = "/timer/{id}", method = RequestMethod.DELETE)
    public String TimerController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        Timer.findTimer(id).remove();
        return "redirect:/timer?page=" + ((page == null) ? "1" : page.toString()) + "&size=" + ((size == null) ? "10" : size.toString());
    }
    
}
