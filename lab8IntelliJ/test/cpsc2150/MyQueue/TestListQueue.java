/* Sterling Rich and Kellen Haas
  CPSC 2150
  Lab8
  6/7/20
 */

package cpsc2150.MyQueue;

import java.lang.*;
import java.util.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestListQueue {

    public static Integer MY_INT = 17;

    private IQueue<Integer> MakeQueue(){
        IQueue<Integer> thisQueue = new ListQueue<Integer>();
        return thisQueue;
    }

    @Test
    public void test_add_size_increase(){
        IQueue<Integer> myQueue = MakeQueue();
        int init_size = myQueue.size();

        myQueue.add(MY_INT);

        assertTrue(myQueue.size() == (init_size + 1));
    }

    @Test
    public void test_add_position(){
        IQueue<Integer> myQueue = MakeQueue();

        myQueue.add(MY_INT);

        assertTrue(myQueue.get(myQueue.size()).equals(MY_INT));
    }

    @Test
    public void test_add_MAX_DEPTH(){

        IQueue<Integer> myQueue = MakeQueue();
        myQueue.add(MY_INT);

        assertTrue(myQueue.size() == 1);
    }

    @Test
    public void test_peek_several_items(){
        IQueue<Integer> myQueue = MakeQueue();

        myQueue.add(MY_INT+1);

        for(int i = 0; i < MY_INT; i++){
            myQueue.add(MY_INT);
        }

        assertTrue(myQueue.peek() != MY_INT);
    }

    @Test
    public void test_peek_one_item(){
        IQueue<Integer> myQueue = MakeQueue();
        myQueue.add(MY_INT);

        assertTrue(myQueue.peek().equals(MY_INT));
    }

    @Test
    public void test_peek_same_Queue(){
        IQueue<Integer> myQueue = MakeQueue();

        for(Integer i = 0; i < myQueue.MAX_DEPTH - 1; i++){
            myQueue.add(i);
        }

        Integer peek = myQueue.peek();

        for(Integer k = 0; k < myQueue.MAX_DEPTH - 1; k++){
            assertEquals(myQueue.get(k + 1), k);
        }
    }

    @Test
    public void test_endOfQueue_several_items(){
        IQueue<Integer> myQueue = MakeQueue();

        for(int i = 0; i < MY_INT; i++){
            myQueue.add(MY_INT);
        }

        myQueue.add(MY_INT + 1);

        assertTrue(myQueue.endOfQueue() != MY_INT);
    }

    @Test
    public void test_endOfQueue_one(){
        IQueue<Integer> myQueue = MakeQueue();
        myQueue.add(MY_INT);

        assertTrue(myQueue.endOfQueue().equals(MY_INT));
    }

    @Test
    public void test_endOfQueue_same_Queue(){
        IQueue<Integer> myQueue = MakeQueue();

        for(Integer i = 0; i < myQueue.MAX_DEPTH - 1; i++){
            myQueue.add(i);
        }

        Integer peek = myQueue.peek();

        for(Integer k = 0; k < myQueue.MAX_DEPTH - 1; k++){
            assertEquals(myQueue.get(k + 1),k);
        }
    }

    @Test
    public void test_insert_empty_size(){
        IQueue<Integer> myQueue = MakeQueue();
        int init_size = myQueue.size();
        myQueue.insert(MY_INT,1);

        assertTrue(myQueue.size() == (init_size+1));
    }

    @Test
    public void test_insert_back(){
        IQueue<Integer> myQueue = MakeQueue();
        for(int i = 1; i < MY_INT; i++){
            myQueue.insert(MY_INT, i);
        }

        myQueue.insert(MY_INT + 1, MY_INT);

        assertTrue(myQueue.endOfQueue() == (MY_INT + 1));
    }

    @Test
    public void test_insert_front(){
        IQueue<Integer> myQueue = MakeQueue();
        for(int i = 1; i < MY_INT; i++){
            myQueue.insert(MY_INT, i);
        }

        myQueue.insert(MY_INT + 1, 1);

        assertTrue(myQueue.peek() == (MY_INT+1));
    }

    @Test
    public void test_remove_one(){
        IQueue<Integer> myQueue = MakeQueue();

        myQueue.add(MY_INT);
        myQueue.remove(1);

        assertTrue(myQueue.size() == 0);
    }

    @Test
    public void test_remove_size(){
        IQueue<Integer> myQueue = MakeQueue();

        for(int i = 0; i < MY_INT; i++){
            myQueue.add(MY_INT);
        }

        myQueue.remove(1);

        assertTrue(myQueue.size() == (MY_INT - 1));
    }

    @Test
    public void test_remove_middle(){
        IQueue<Integer> myQueue = MakeQueue();

        for(int i = 0; i < MY_INT; i++){
            myQueue.add(MY_INT);
        }

        myQueue.add(MY_INT + 1);

        for(int i = 0; i < MY_INT; i++){
            myQueue.add(MY_INT);
        }

        myQueue.remove(MY_INT + 1);

        for(int i = 0; i < MY_INT; i++){
            assertEquals(myQueue.get(i + 1), (MY_INT));
        }

        for(int i = MY_INT; i < myQueue.size(); i++){
            assertEquals(myQueue.get(i + 1), (MY_INT));
        }
    }

    @Test
    public void test_get_same_Queue(){
        IQueue<Integer> myQueue = MakeQueue();

        for(Integer i = 0; i < myQueue.MAX_DEPTH - 1; i++){
            myQueue.add(i);
        }

        Integer peek = myQueue.peek();

        for(Integer k = 0; k < myQueue.MAX_DEPTH - 1; k++){
            assertEquals(myQueue.get(k + 1), k);
        }
    }

    @Test
    public void test_get_middle(){
        IQueue<Integer> myQueue = MakeQueue();

        for(int i = 0; i < MY_INT; i++){
            myQueue.add(MY_INT);
        }

        myQueue.add(MY_INT+1);

        for(int i = 0; i < MY_INT; i++){
            myQueue.add(MY_INT);
        }

        assertTrue(myQueue.get(MY_INT + 1) != MY_INT);
    }

    @Test
    public void test_get_beginning(){
        IQueue<Integer> myQueue = MakeQueue();

        myQueue.add(MY_INT + 1);

        for(int i = 0; i < MY_INT; i++){
            myQueue.add(MY_INT);
        }

        assertTrue(myQueue.get(1) != MY_INT);
    }
}
