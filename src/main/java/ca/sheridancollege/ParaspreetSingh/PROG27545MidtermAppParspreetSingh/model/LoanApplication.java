// LoanApplication

package ca.sheridancollege.ParaspreetSingh.PROG27545MidtermAppParspreetSingh.model;

import jakarta.validation.constraints.*;

public class LoanApplication {

    @NotNull(message = "Annual income is required")
    @Positive(message = "Annual income must be positive")
    private Double annualIncome;

    @NotNull(message = "Monthly expenses required")
    @Min(value = 0, message = "Monthly expenses cannot be negative")
    private Double monthlyExpenses;

    @NotNull(message = "Loan amount required")
    @Positive(message = "Loan amount must be positive")
    private Double loanAmount;

    @NotNull(message = "Loan term required")
    @Min(value = 1)
    @Max(value = 30)
    private Integer loanTerm;

    @NotNull(message = "Credit score required")
    @Min(value = 300)
    @Max(value = 850)
    private Integer creditScore;

    // Getters and Setters

    public Double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public Double getMonthlyExpenses() {
        return monthlyExpenses;
    }

    public void setMonthlyExpenses(Double monthlyExpenses) {
        this.monthlyExpenses = monthlyExpenses;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(Integer loanTerm) {
        this.loanTerm = loanTerm;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }
}
