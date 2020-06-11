/* Sterling Rich and Kellen Haas
  CPSC 2150
  lab9
  6/10/20
*/

package cpsc2150.mortgages;

import java.util.Scanner;

public class MortgageView implements IMortgageView {
    Scanner scan;
    IMortgageController c;

    public MortgageView(){
        scan = new Scanner(System.in);
    }

    public void setController(IMortgageController c){
        this.c = c;
    }

    public double getHouseCost() {
        System.out.println("How much does the house cost?\n");
        String input = scan.nextLine();
        double houseCost = Double.parseDouble(input);
        return houseCost;
    }

    public double getDownPayment(){
        System.out.println("How much is the down payment?\n");
        String input = scan.nextLine();
        double downPayment = Double.parseDouble(input);
        return downPayment;
    }

    public int getYears() {
        System.out.println("How many years?\n");
        String input = scan.nextLine();
        int yrs = Integer.parseInt(input);
        return yrs;
    }

    public double getMonthlyDebt() {
        System.out.println("How much are your monthly debt payments?\n");
        String input = scan.nextLine();
        double monthlyDebt = Double.parseDouble(input);
        return monthlyDebt;
    }

    public double getYearlyIncome() {
        System.out.println("How much is your yearly income?\n");
        String input = scan.nextLine();
        double yearlyIncome = Double.parseDouble(input);
        return yearlyIncome;
    }

    public int getCreditScore() {
        System.out.println("What is your credit score?\n");
        String input = scan.nextLine();
        int creditScore = Integer.parseInt(input);
        return creditScore;
    }

    public String getName() {
        System.out.println("What's your name?\n");
        String name = scan.nextLine();
        return name;
    }

    public void printToUser(String s) {
        System.out.println(s);
    }

    public void displayPayment(double p) {
        String str = "";
        str += "Principal Amount: $" + p + "\n";
        System.out.println(str);
    }

    public void displayRate(double r) {
        String str = "";
        str += "Interest Rate: " + (r * 100) + "%\n";
        System.out.println(str);
    }

    public void displayApproved(boolean a) {

        //I'm not sure how this is supposed to be able to call the customer/Mortgage information
        if(!a){
            System.out.println("Loan was not approved");
        }

    }

    public boolean getAnotherMortgage() {
        System.out.println("Would you like to apply for another mortgage? Y/N\n");
        String input = scan.nextLine();
        if (input.equals("Y") || input.equals("y")) {
            return true;
        }
        else if (input.equals("N") || input.equals("n")) {
            return false;
        }
        return false;
    }

    public boolean getAnotherCustomer() {
        System.out.println("Would you like to consider another customer? Y/N\n");
        String input = scan.nextLine();
        if (input.equals("Y") || input.equals("y")) {
            return true;
        }
        else if (input.equals("N") || input.equals("n")) {
            return false;
        }
        return false;
    }

}
