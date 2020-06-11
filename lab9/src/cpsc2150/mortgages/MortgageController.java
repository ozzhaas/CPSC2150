package cpsc2150.mortgages;

public abstract class MortgageController implements IMortgageController {
    private IMortgageView view;


    MortgageController(IMortgageView v) {
        v = view;
    }


    public void submitApplication() {

    }
}
