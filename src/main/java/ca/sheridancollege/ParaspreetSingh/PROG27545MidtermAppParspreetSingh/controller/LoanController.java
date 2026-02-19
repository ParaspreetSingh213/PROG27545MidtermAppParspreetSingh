// LoanController

package ca.sheridancollege.ParaspreetSingh.PROG27545MidtermAppParspreetSingh.controller;

import ca.sheridancollege.ParaspreetSingh.PROG27545MidtermAppParspreetSingh.model.LoanApplication;
import ca.sheridancollege.ParaspreetSingh.PROG27545MidtermAppParspreetSingh.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/apply")
    public String showForm(Model model) {
        model.addAttribute("loanApplication", new LoanApplication());
        return "loanForm";
    }

    @PostMapping("/result")
    public String processForm(@Valid @ModelAttribute LoanApplication loanApplication,
                              BindingResult result,
                              Model model) {

        if (result.hasErrors()) {
            return "loanForm";
        }

        double dti = loanService.calculateDTI(
                loanApplication.getAnnualIncome(),
                loanApplication.getMonthlyExpenses()
        );

        boolean approved = loanService.isApproved(
                loanApplication.getCreditScore(),
                dti
        );

        double payment = loanService.calculateMonthlyPayment(
                loanApplication.getLoanAmount(),
                loanApplication.getLoanTerm()
        );

        model.addAttribute("dti", dti);
        model.addAttribute("approved", approved);
        model.addAttribute("payment", payment);

        return "result";
    }
}
