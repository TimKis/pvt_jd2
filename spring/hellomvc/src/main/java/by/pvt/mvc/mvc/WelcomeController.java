package by.pvt.mvc.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 */
@Controller
@RequestMapping(value = "/welcome")
public class WelcomeController {


    @RequestMapping(method = RequestMethod.GET)
    public String getWelcome(Model model) {
        model.addAttribute("greeting", "Hello Spring MVC!");
        return "welcome";
    }
}
