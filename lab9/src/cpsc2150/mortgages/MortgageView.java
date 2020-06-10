package cpsc2150.mortgages;

import java.util.Scanner;

public abstract class MortgageView implements IMortgage {
    Scanner scan = new Scanner(System.in);

    public void setController(IMortgageController c) {

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

        displayPayment();
        displayRate();
    }

    public void displayPayment(double p) {

    }

    public void displayRate(double r) {

    }

    public void displayApproved(boolean a) {

    }

    public boolean getAnotherMortgage() {

    }

    public boolean getAnotherCustomer() {

    }


}
