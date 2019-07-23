package mfh.learn.hib.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mfh.learn.hib.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import mfh.learn.hib.service.CustomerService;

import java.util.List;

// ctrl+shift+back slash
@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(value = {"/"})
    public ModelAndView getHomeView() {
        log.info("Getting the all customers.");
        ModelAndView modelAndView = new ModelAndView("index");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping(value = {"/customer-form"})
    public ModelAndView getCustomerFormView() {
        ModelAndView modelAndView = new ModelAndView("customerForm");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping(value = {"/addCustomer"})
    public ModelAndView addCustomer( @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("customer_form");
        } else {
            customerService.save(customer);
            modelAndView.addObject("customer", customer);
            modelAndView.setViewName("redirect: /");
        }

        return modelAndView;
    }

}