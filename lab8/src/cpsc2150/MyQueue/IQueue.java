/* Sterling Rich and Kellen Haas
  CPSC 2150
  Lab8
  6/7/20
 */

package cpsc2150.MyQueue;

/**
 * A queue containing T.
 * A queue is a data structure where the first item added to the
 * structure is the first item removed from the structure
 * This queue is bounded by MAX_DEPTH
 */
public interface IQueue<T> {
    int MAX_DEPTH = 100;

    /**
     * @pre Queue size() < MAX_DEPTH
     * @param x The T being pushed into the end of the Queue
     * @post [x is in the last position of the Queue] and
     *      size() = #size() + 1
     * @return void
     */
    public void add(T x);

    /**
     * @pre Queue size() > 0
     * @post size() = #size() - 1
     * @return the T from the front of the Queue
     */
    public T pop();

    /**
     * @pre 0 <= amount of objects in Queue <= MAX_DEPTH
     * @post 0 <= size <= MAX_DEPTH
     * @return the number of T in the Queue
     */
    public int size();

    /**
     * @pre size() > 0
     * @post Queue = #Queue
     * @return The T in the front of the Queue
     */
    default T peek(){
        return get(1);
    }

    /**
     * @pre depth > 0
     * @post Queue = #Queue
     * @return The T at the end of the Queue
     */
    default T endOfQueue(){
        return get(size());
    }

    /**
     * @pre 1 <= pos <= size() + 1 < MAX_DEPTH
     * @post size() = #size() + 1 and [(positions > pos) = #position + 1]
     * @param x The T being inserted into the Queue
     * @param pos The position in the Queue where x will be placed
     *              where 1 is the front of the Queue
     */
    default void insert(T x, int pos){

        int size = size()+1;

        //temporary array to store the Queue
        T [] tempQ = (T[]) new Object [size];

        //Ts from 0-pos into tempQ
        for(int i = 1;i < pos;i++) {
            tempQ[i-1] = pop();
        }

        //add x into tempQ
        tempQ[pos-1] = x;

        //add the rest of the Queue into tempQ
        for(int i = 0; i < size - pos;i++){
            tempQ[pos+i] = pop();
        }

        //refill the Queue from tempQ
        for(int k = 0; k < size; k++){
            add(tempQ[k]);
        }
    }

    /**
     * @pre 1 <= pos <= size()
     * @post size() = #size() - 1 and [(positions > pos) = #position - 1]
     * @param pos The position in Queue to remove
     * @return The T that was in the position pos of the Queue
     *          where 1 is the front of the Queue
     */
    default T remove(int pos){

        int size = size()-1;
        T rem;

        //temporary array to store the Queue
        T [] tempQ = (T[]) new Object [size];

        //Ts from 0-pos into tempQ
        for(int i = 1;i < pos;i++) {
            tempQ[i-1] = pop();
        }

        rem = pop();

        //add the rest of the Queue into tempQ
        for(int i = -1; i < size - pos;i++){
            tempQ[pos+i] = pop();
        }

        //refill the Queue from tempQ
        for(int k = 0; k < size; k++){
            add(tempQ[k]);
        }

        return rem;
    }

    /**
     * @pre 1 <= pos <= size()
     * @post Queue = #Queue
     * @param pos The position in the Queue of an T you want to see
     *              where 1 is the front of the Queue
     * @return The T in position pos of the Queue
     */
    default T get(int pos){

        int size = size();
        T atPos;

        //temporary array to store the Queue
        T [] tempQ = (T[]) new Object [size];

        //Ts from 0-pos into tempQ
        for(int i = 0;i < pos;i++) {
            tempQ[i] = pop();
        }

        atPos = tempQ[pos-1];

        //add the rest of the Queue into tempQ
        for(int i = 0; i < size - pos;i++){
            tempQ[pos+i] = pop();
        }

        //refill the Queue from tempQ
        for(int k = 0; k < size; k++){
            add(tempQ[k]);
        }

        return atPos;
    }

}