/* Sterling Rich and Kellen Haas
  CPSC 2150
  Lab4
  5/24/20s
 */

package cpsc2150.MyQueue;

import java.util.Scanner;

public class QueueApp {

    public static void main(String[] args) {
        IQueue q;

        //Initializing Queue through user input
        Scanner scan = new Scanner(System.in);
        System.out.println("What kind of implementation would you like?");
        System.out.println("ArrayQueue or ListQueue");
        String in = scan.nextLine();

        if (in.equals("ArrayQueue"))
            q = new ArrayQueue();
        else
            q = new ListQueue();


        //Premade by instructor
        Integer x = 42;
        q.add(x);
        x = 17;
        q.add(x);
        x = 37;
        q.add(x);
        x = 36;
        q.add(x);
        x = 12;
        q.add(x);
        /*
        Add the code to print the queue. After the code is finished,
        the queue should still contain all its values in order
        */
        System.out.println("Elements of the Queue: ");
        System.out.println(q.size());
        IQueue temp = q;
        for (Integer k = 0; k < q.size(); k++) {
            Integer holder = q.pop();
            System.out.println(holder + " ");
            temp.add(holder);
        }
    }
}
