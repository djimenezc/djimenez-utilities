package com.springsource.roo.pizzashop.web;

import com.springsource.roo.pizzashop.domain.Pizza;
import com.springsource.roo.pizzashop.domain.PizzaOrder;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

privileged aspect PizzaOrderController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String PizzaOrderController.create(@Valid PizzaOrder pizzaOrder, BindingResult result, ModelMap modelMap) {
        if (pizzaOrder == null) throw new IllegalArgumentException("A pizzaOrder is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("pizzaOrder", pizzaOrder);
            addDateTimeFormatPatterns(modelMap);
            return "pizzaorder/create";
        }
        pizzaOrder.persist();
        return "redirect:/pizzaorder/" + pizzaOrder.getId();
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String PizzaOrderController.createForm(ModelMap modelMap) {
        modelMap.addAttribute("pizzaOrder", new PizzaOrder());
        addDateTimeFormatPatterns(modelMap);
        return "pizzaorder/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String PizzaOrderController.show(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        addDateTimeFormatPatterns(modelMap);
        modelMap.addAttribute("pizzaorder", PizzaOrder.findPizzaOrder(id));
        return "pizzaorder/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String PizzaOrderController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, ModelMap modelMap) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            modelMap.addAttribute("pizzaorders", PizzaOrder.findPizzaOrderEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) PizzaOrder.countPizzaOrders() / sizeNo;
            modelMap.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            modelMap.addAttribute("pizzaorders", PizzaOrder.findAllPizzaOrders());
        }
        addDateTimeFormatPatterns(modelMap);
        return "pizzaorder/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String PizzaOrderController.update(@Valid PizzaOrder pizzaOrder, BindingResult result, ModelMap modelMap) {
        if (pizzaOrder == null) throw new IllegalArgumentException("A pizzaOrder is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("pizzaOrder", pizzaOrder);
            addDateTimeFormatPatterns(modelMap);
            return "pizzaorder/update";
        }
        pizzaOrder.merge();
        return "redirect:/pizzaorder/" + pizzaOrder.getId();
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String PizzaOrderController.updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("pizzaOrder", PizzaOrder.findPizzaOrder(id));
        addDateTimeFormatPatterns(modelMap);
        return "pizzaorder/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String PizzaOrderController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        PizzaOrder.findPizzaOrder(id).remove();
        return "redirect:/pizzaorder?page=" + ((page == null) ? "1" : page.toString()) + "&size=" + ((size == null) ? "10" : size.toString());
    }
    
    @ModelAttribute("pizzas")
    public Collection<Pizza> PizzaOrderController.populatePizzas() {
        return Pizza.findAllPizzas();
    }
    
    Converter<Pizza, String> PizzaOrderController.getPizzaConverter() {
        return new Converter<Pizza, String>() {
            public String convert(Pizza pizza) {
                return new StringBuilder().append(pizza.getName()).append(" ").append(pizza.getPrice()).toString();
            }
        };
    }
    
    Converter<PizzaOrder, String> PizzaOrderController.getPizzaOrderConverter() {
        return new Converter<PizzaOrder, String>() {
            public String convert(PizzaOrder pizzaOrder) {
                return new StringBuilder().append(pizzaOrder.getName()).append(" ").append(pizzaOrder.getAddress()).append(" ").append(pizzaOrder.getTotal()).toString();
            }
        };
    }
    
    @InitBinder
    void PizzaOrderController.registerConverters(WebDataBinder binder) {
        if (binder.getConversionService() instanceof GenericConversionService) {
            GenericConversionService conversionService = (GenericConversionService) binder.getConversionService();
            conversionService.addConverter(getPizzaConverter());
            conversionService.addConverter(getPizzaOrderConverter());
        }
    }
    
    void PizzaOrderController.addDateTimeFormatPatterns(ModelMap modelMap) {
        modelMap.addAttribute("pizzaOrder_deliverydate_date_format", DateTimeFormat.patternForStyle("S-", LocaleContextHolder.getLocale()));
    }
    
}
