/* Sterling Rich and Kellen Haas
  CPSC 2150
  lab10
  6/14/20
*/

package cpsc2150.mortgages;
/**
 * @invariants APR >= 0.025 AND
 *      payment = (Rate * Principal) / (1-(1+Rate)^ -NumberOfPayments AND
 *      0 <= Rate <= 1 AND
 *      0 < DebtToIncomeRatio AND
 *      MIN_YEARS * 12 <= NumberOfPayments <= MAX_YEARS * 12 AND
 *      0 < Principal AND
 *      0 <= PercentDown < 1
 *
 *
 * @Correspondence rate = Rate AND
 *      payment = Payment AND
 *      principal = Principal AND
 *
 */
public class Mortgage implements IMortgage{

    private double rate;
    private int numberOfPayments;
    private double debtToIncomeRatio;
    private double principal;
    private double percentDown;
    private double payment;
    private ICustomer customer;

    /**
     * @param homeCost The cost of the home
     * @param down The down payment towards buying the home
     * @param numYears The number of years for the loan
     * @param customer The customer who is getting the loan
     * @pre homeCost > 0 AND 0.035 <= percentDown AND rate [aka APR] >= 0.025 AND 15 <= numYears <= 30
     * @post (principal = homeCost) AND (rate = APR) AND (percentDown = down/homeCost) AND
     *          (numberOfPayments = numYears * 12) AND (this.customer = customer) AND
     *          (payment = (Rate * Principal) / (1-(1+Rate)^ -NumberOfPayments))
     */
    public Mortgage(double homeCost, double down, int numYears, ICustomer customer){
        principal = homeCost - down;
        percentDown = down/homeCost;
        numberOfPayments = numYears * 12;
        this.customer = customer;

        rate = BASERATE;

        //numYears affects rate
        if(numYears < MAX_YEARS)
            rate += GOODRATEADD;
        else
            rate += NORMALRATEADD;

        //Percent down affects rate
        if(percentDown < PREFERRED_PERCENT_DOWN)
            rate += GOODRATEADD;

        //Credit affects rate
        if(customer.getCreditScore() < BADCREDIT)
            rate += VERYBADRATEADD;
        else if (customer.getCreditScore() < FAIRCREDIT)
            rate += BADRATEADD;
        else if(customer.getCreditScore() < GOODCREDIT)
            rate += NORMALRATEADD;
        else if(customer.getCreditScore() < GREATCREDIT)
            rate += GOODRATEADD;

        rate = rate/12;

        payment = (rate * principal) / (1-Math.pow(1+rate, -numberOfPayments));

        debtToIncomeRatio = (customer.getMonthlyDebtPayments() + getPayment())/(customer.getIncome()/12);
    }


    /**
     * @pre
     * @post
     */
    public boolean loanApproved() {
        if(getRate() >= RATETOOHIGH || percentDown < MIN_PERCENT_DOWN || debtToIncomeRatio > DTOITOOHIGH)
            return false;
        else
            return true;
    }


    /**
     * @post getPayment = Payment
     */
    public double getPayment() {
        return payment;
    }


    /**
     * @post getPrincipal = Principal
     */
    public double getPrincipal() {
        return principal;
    }

    /**
     * @post getRate = Rate = rate * 12
     */
    public double getRate() {
        return rate*12;
    }

    /**
     * @post getYears = Years = numberOfPayments / 12
     */
    public int getYears() {
        return numberOfPayments/12;
    }

    /**
     *
     * @return the string representation of this loan details, or a notice that the loan was not approved
     * @requires this != null and [interestRate and payment have been calculated]
     * @ensures [toString = The string value of the loan, or "Loan was not approved"]
     */
    @Override
    public String toString()
    {
        String str = "";

        str += "Principal Amount: $" + getYears() + "\n";
        str += "Interest Rate: " + (getRate() * 100) + "%\n";
        str += "Term: " + getYears() + " years\n";
        str += "Monthly Payment: $" + getPayment() + "\n";

        return str;
    }
}