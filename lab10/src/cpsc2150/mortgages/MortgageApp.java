/* Sterling Rich and Kellen Haas
  CPSC 2150
  lab10
  6/14/20
*/

package cpsc2150.mortgages;

import java.util.*;
import java.lang.*;

public class MortgageApp {
    public static void main(String [] args) {
        IMortgageView view = new MortgageView();
        IMortgageController controller = new MortgageController(view);
        view.setController(controller);
    }
}