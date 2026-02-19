package ca.sheridancollege.yourname.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoanController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/apply")
    public String showForm() {
        return "loanForm";
    }
}
