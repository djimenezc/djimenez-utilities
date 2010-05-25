package com.springsource.roo.pizzashop.web;

import com.springsource.roo.pizzashop.domain.Base;
import com.springsource.roo.pizzashop.domain.Pizza;
import com.springsource.roo.pizzashop.domain.Topping;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import javax.validation.Valid;
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

privileged aspect PizzaController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String PizzaController.create(@Valid Pizza pizza, BindingResult result, ModelMap modelMap) {
        if (pizza == null) throw new IllegalArgumentException("A pizza is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("pizza", pizza);
            return "pizza/create";
        }
        pizza.persist();
        return "redirect:/pizza/" + pizza.getId();
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String PizzaController.createForm(ModelMap modelMap) {
        modelMap.addAttribute("pizza", new Pizza());
        return "pizza/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String PizzaController.show(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("pizza", Pizza.findPizza(id));
        return "pizza/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String PizzaController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, ModelMap modelMap) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            modelMap.addAttribute("pizzas", Pizza.findPizzaEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Pizza.countPizzas() / sizeNo;
            modelMap.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            modelMap.addAttribute("pizzas", Pizza.findAllPizzas());
        }
        return "pizza/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String PizzaController.update(@Valid Pizza pizza, BindingResult result, ModelMap modelMap) {
        if (pizza == null) throw new IllegalArgumentException("A pizza is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("pizza", pizza);
            return "pizza/update";
        }
        pizza.merge();
        return "redirect:/pizza/" + pizza.getId();
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String PizzaController.updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("pizza", Pizza.findPizza(id));
        return "pizza/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String PizzaController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        Pizza.findPizza(id).remove();
        return "redirect:/pizza?page=" + ((page == null) ? "1" : page.toString()) + "&size=" + ((size == null) ? "10" : size.toString());
    }
    
    @RequestMapping(params = {"find=ByBase", "form"}, method = RequestMethod.GET)
    public String PizzaController.findPizzasByBaseForm(ModelMap modelMap) {
        modelMap.addAttribute("bases", Base.findAllBases());
        return "pizza/findPizzasByBase";
    }
    
    @RequestMapping(params = "find=ByBase", method = RequestMethod.GET)
    public String PizzaController.findPizzasByBase(@RequestParam("base") Base base, ModelMap modelMap) {
        if (base == null) throw new IllegalArgumentException("A Base is required.");
        modelMap.addAttribute("pizzas", Pizza.findPizzasByBase(base).getResultList());
        return "pizza/list";
    }
    
    @ModelAttribute("bases")
    public Collection<Base> PizzaController.populateBases() {
        return Base.findAllBases();
    }
    
    @ModelAttribute("toppings")
    public Collection<Topping> PizzaController.populateToppings() {
        return Topping.findAllToppings();
    }
    
    Converter<Base, String> PizzaController.getBaseConverter() {
        return new Converter<Base, String>() {
            public String convert(Base base) {
                return new StringBuilder().append(base.getName()).toString();
            }
        };
    }
    
    Converter<Pizza, String> PizzaController.getPizzaConverter() {
        return new Converter<Pizza, String>() {
            public String convert(Pizza pizza) {
                return new StringBuilder().append(pizza.getName()).append(" ").append(pizza.getPrice()).toString();
            }
        };
    }
    
    Converter<Topping, String> PizzaController.getToppingConverter() {
        return new Converter<Topping, String>() {
            public String convert(Topping topping) {
                return new StringBuilder().append(topping.getName()).toString();
            }
        };
    }
    
    @InitBinder
    void PizzaController.registerConverters(WebDataBinder binder) {
        if (binder.getConversionService() instanceof GenericConversionService) {
            GenericConversionService conversionService = (GenericConversionService) binder.getConversionService();
            conversionService.addConverter(getBaseConverter());
            conversionService.addConverter(getPizzaConverter());
            conversionService.addConverter(getToppingConverter());
        }
    }
    
}
