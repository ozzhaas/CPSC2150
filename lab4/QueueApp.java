package cpsc2150.MyQueue;

import java.util.*;
import java.lang.*;
import java.io.*;

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
        //Add the code to print the queue. After the code is finished,
        //the queue should still contain all its values in order
    }
}
