package com.springsource.roo.pizzashop.web;

import com.springsource.roo.pizzashop.domain.Base;
import java.lang.Long;
import java.lang.String;
import javax.validation.Valid;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

privileged aspect BaseController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String BaseController.create(@Valid Base base, BindingResult result, ModelMap modelMap) {
        if (base == null) throw new IllegalArgumentException("A base is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("base", base);
            return "base/create";
        }
        base.persist();
        return "redirect:/base/" + base.getId();
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String BaseController.createForm(ModelMap modelMap) {
        modelMap.addAttribute("base", new Base());
        return "base/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String BaseController.show(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("base", Base.findBase(id));
        return "base/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String BaseController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, ModelMap modelMap) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            modelMap.addAttribute("bases", Base.findBaseEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Base.countBases() / sizeNo;
            modelMap.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            modelMap.addAttribute("bases", Base.findAllBases());
        }
        return "base/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String BaseController.update(@Valid Base base, BindingResult result, ModelMap modelMap) {
        if (base == null) throw new IllegalArgumentException("A base is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("base", base);
            return "base/update";
        }
        base.merge();
        return "redirect:/base/" + base.getId();
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String BaseController.updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("base", Base.findBase(id));
        return "base/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String BaseController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        Base.findBase(id).remove();
        return "redirect:/base?page=" + ((page == null) ? "1" : page.toString()) + "&size=" + ((size == null) ? "10" : size.toString());
    }
    
    Converter<Base, String> BaseController.getBaseConverter() {
        return new Converter<Base, String>() {
            public String convert(Base base) {
                return new StringBuilder().append(base.getName()).toString();
            }
        };
    }
    
    @InitBinder
    void BaseController.registerConverters(WebDataBinder binder) {
        if (binder.getConversionService() instanceof GenericConversionService) {
            GenericConversionService conversionService = (GenericConversionService) binder.getConversionService();
            conversionService.addConverter(getBaseConverter());
        }
    }
    
}
