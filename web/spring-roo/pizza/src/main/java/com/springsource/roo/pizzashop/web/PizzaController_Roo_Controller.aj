package com.springsource.roo.pizzashop.web;

import com.springsource.roo.pizzashop.domain.Base;
import com.springsource.roo.pizzashop.domain.Pizza;
import com.springsource.roo.pizzashop.domain.Topping;
import java.lang.Long;
import java.lang.String;
import javax.validation.Valid;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

privileged aspect PizzaController_Roo_Controller {
    
    @RequestMapping(value = "/pizza", method = RequestMethod.POST)
    public String PizzaController.create(@Valid Pizza pizza, BindingResult result, ModelMap modelMap) {
        if (pizza == null) throw new IllegalArgumentException("A pizza is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("pizza", pizza);
            modelMap.addAttribute("bases", Base.findAllBases());
            modelMap.addAttribute("toppings", Topping.findAllToppings());
            return "pizza/create";
        }
        pizza.persist();
        return "redirect:/pizza/" + pizza.getId();
    }
    
    @RequestMapping(value = "/pizza/form", method = RequestMethod.GET)
    public String PizzaController.createForm(ModelMap modelMap) {
        modelMap.addAttribute("pizza", new Pizza());
        modelMap.addAttribute("bases", Base.findAllBases());
        modelMap.addAttribute("toppings", Topping.findAllToppings());
        return "pizza/create";
    }
    
    @RequestMapping(value = "/pizza/{id}", method = RequestMethod.GET)
    public String PizzaController.show(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("pizza", Pizza.findPizza(id));
        return "pizza/show";
    }
    
    @RequestMapping(value = "/pizza", method = RequestMethod.GET)
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
            modelMap.addAttribute("bases", Base.findAllBases());
            modelMap.addAttribute("toppings", Topping.findAllToppings());
            return "pizza/update";
        }
        pizza.merge();
        return "redirect:/pizza/" + pizza.getId();
    }
    
    @RequestMapping(value = "/pizza/{id}/form", method = RequestMethod.GET)
    public String PizzaController.updateForm(@PathVariable("id") Long id, ModelMap modelMap) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        modelMap.addAttribute("pizza", Pizza.findPizza(id));
        modelMap.addAttribute("bases", Base.findAllBases());
        modelMap.addAttribute("toppings", Topping.findAllToppings());
        return "pizza/update";
    }
    
    @RequestMapping(value = "/pizza/{id}", method = RequestMethod.DELETE)
    public String PizzaController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        if (id == null) throw new IllegalArgumentException("An Identifier is required");
        Pizza.findPizza(id).remove();
        return "redirect:/pizza?page=" + ((page == null) ? "1" : page.toString()) + "&size=" + ((size == null) ? "10" : size.toString());
    }
    
}
