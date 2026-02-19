package ca.sheridancollege.yourname.service;

import org.springframework.stereotype.Service;

@Service
public class LoanService {

    public double calculateDTI(double annualIncome, double monthlyExpenses) {
        double monthlyIncome = annualIncome / 12;
        return (monthlyExpenses / monthlyIncome) * 100;
    }

    public boolean isApproved(int creditScore, double dti) {
        return creditScore >= 600 && dti <= 40;
    }

    public double calculateMonthlyPayment(double loanAmount, int loanTerm) {
        return loanAmount / (loanTerm * 12);
    }
}
