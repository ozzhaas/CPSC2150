/*Kellen Haas
  CPSC 2150
  Lab6
  5/31/20
 */

package cpsc2150.MyQueue;

import java.util.*;

public class ListQueue<T> extends AbsQueue<T> implements IQueue<T>{

    /**
     * @invariants 0 <= depth <= MAX_DEPTH and
     * [depth = number of Ts in myQ]
     * Correspondence IQueue = myQ
     */

    //this time store the queue in a list
    //myQ.get(0) is the front of the queue
    private List<T> myQ;

    /**
     * @post myQ.size() = 0 and [myQ is empty]
     */
    public ListQueue() {
        myQ = new ArrayList<T>();
    }

    /**
     * @pre myQ.size() < MAX_DEPTH
     * @post myQ.size() = #myQ.size() + 1 and x = myQ[myQ.size()]
     * @param x The T being pushed into the end of the Queue
     */
    public void add(T x){
        myQ.add(x);
    }

    /**
     * @pre myQ.size() > 0
     * @post myQ.size() = #myQ.size() - 1
     * @return Returns the first T in the Queue
     */
    public T pop() {
        T x = myQ.get(0);

        myQ.remove(0);
        return x;
    }

    /**
     * @post 0 <= myQ.size() <= MAX_DEPTH
     * @return The current amount of Ts in myQ
     */
    public int size() {
        return myQ.size();
    }
}

