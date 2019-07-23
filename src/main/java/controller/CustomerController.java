package controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.CustomerService;

import java.util.List;

// ctrl+shift+back slash
@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = {"/"})
    public ModelAndView getHomeView() {
        log.info("Getting the all customers.");
        ModelAndView modelAndView = new ModelAndView("index");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

}