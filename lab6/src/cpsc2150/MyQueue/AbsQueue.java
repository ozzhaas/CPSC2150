/* Sterling Rich and Kellen Haas
  CPSC 2150
  Lab6
  5/31/20
 */

package cpsc2150.MyQueue;

import java.lang.*;
import java.util.*;

public abstract class AbsQueue<T> implements cpsc2150.MyQueue.IQueue<T> {

    @Override
    public String toString(){

        String qString = "";

        for(int i = 1; i < size() + 1;i++){
            qString += get(i).toString();
        }

        return qString;
    }
}