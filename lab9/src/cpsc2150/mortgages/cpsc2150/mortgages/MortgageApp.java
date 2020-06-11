/* Sterling Rich and Kellen Haas
  CPSC 2150
  lab9
  6/10/20
*/

package cpsc2150.mortgages;

import java.util.*;
import java.lang.*;

public class MortgageApp {
    public static void main(String [] args) {
        IMortgageView view = new MortgageView();
        IMortgageController controller = new MortgageController(view);
        view.setController(controller);
        controller.submitApplication();
    }
}