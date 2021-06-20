/*Kellen Haas
  CPSC 2150
  Lab6
  5/31/20
 */

package cpsc2150.MyQueue;

import sun.awt.X11.XSystemTrayPeer;

import java.util.*;
import java.lang.*;


public class DoubleQueueApp {



    public static void main(String[] args) {
        IQueue<Double> q;

        //Initializing Queue through user input
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a number for the kind of implementation you would like:");
        System.out.println("1. ArrayQueue\n2. ListQueue");
        String in = scan.nextLine();
        double typeOfQ = Double.parseDouble(in);
        System.out.println(typeOfQ);

        //error checking Queue decision
        while(typeOfQ != 1 && typeOfQ != 2){
            System.out.println("Please enter a number for the kind of implementation you would like:");
            System.out.println("1. ArrayQueue\n2. ListQueue");
            in = scan.nextLine();
            typeOfQ = Double.parseDouble(in);
        }

        //Initialization type of Queue
        if (typeOfQ == 1) {
            q = new ArrayQueue<>();
            System.out.println("ArrayQueue made");
            System.out.println(q);
        }
        else {
            System.out.println("ListQueue made");
            q = new ListQueue<>();
        }
        //menu
        String menuSelec = "10";
        while(!menuSelec.equals("8")){
            System.out.println("Select and option:\n");
            System.out.println("\t1. Add to the Queue\n\t2. Get next number from the Queue\n\t" +
                    "3. Peek at the front of the Queue\n\t4. Peek at the end of the Queue\n\t5. Insert in the Queue\n\t" +
                    "6. Get a position in the Queue\n\t7. Remove from a position in the Queue\n\t8. Quit\n");

            menuSelec = scan.nextLine();
            switch (menuSelec) {
                case "1":
                    System.out.println("What number would you like to add to the Queue?");
                    String temp = scan.nextLine();
                    Double numToAdd = Double.parseDouble(temp);
                    System.out.println(numToAdd);
                    q.add(numToAdd);
                    break;

                case "2":
                    if(isEmpty(q))
                        break;

                    System.out.println("Next number is: " + q.pop());
                    break;

                case "3":
                    if(isEmpty(q))
                        break;

                    Double frontNum = q.peek();
                    System.out.println("Peek: " + frontNum);
                    break;

                case "4":
                    if(isEmpty(q))
                        break;

                    Double endNum = q.endOfQueue();
                    System.out.println("Peek at the end:" + endNum);
                    break;

                case "5":
                    System.out.println("What number do you want to add to the Queue?\n");
                    String tempInsNum = scan.nextLine();
                    Double insNum = Double.parseDouble(tempInsNum);

                    System.out.println("What position do you want to insert it in?\n");
                    String tempInsPos = scan.nextLine();
                    Integer insPos = Integer.parseInt(tempInsPos);

                    while ((insPos < 1) || (insPos > q.size()+1)) {
                        System.out.println("Not a valid position in the Queue!\n");
                        System.out.println("What position in the Queue do you want to see?\n");
                        tempInsPos = scan.nextLine();
                        insPos = Integer.parseInt(tempInsPos);
                    }


                    q.insert(insNum, insPos);
                    break;

                case "6":
                    if(isEmpty(q))
                        break;

                    System.out.println("What position in the Queue do you want to see?\n");
                    String getPos = scan.nextLine();
                    Integer pos = Integer.parseInt(getPos);

                    while ((pos < 1) || (pos > q.size())) {
                        System.out.println("Not a valid position in the Queue!\n");
                        System.out.println("What position in the Queue do you want to see?\n");
                        getPos = scan.nextLine();
                        pos = Integer.parseInt(getPos);
                    }

                    Double nextNum = q.get(pos);
                    System.out.println(nextNum + " is at position " + pos + " in the Queue.\n");
                    break;

                case "7":
                    if(isEmpty(q))
                        break;

                    System.out.println("What position would you like to remove from the Queue?\n");
                    String tempRemPos = scan.nextLine();
                    Integer remPos = Integer.parseInt(tempRemPos);

                    while ((remPos < 1) || (remPos > (q.size()+1))) {
                        System.out.println("Not a valid position in the Queue!\n");
                        System.out.println("What position would you like to remove from the Queue?\n");
                        tempRemPos = scan.nextLine();
                        remPos = Integer.parseInt(tempRemPos);
                    }

                    Double removed = q.remove(remPos);
                    System.out.println(removed + " was at position " + remPos + " in the Queue.\n");
                    break;

                case "8":
                    System.out.println("Exiting menu.");
                    break;

                default:
                    System.out.println("\nYou must enter a number 1-8.\n");
            }
            System.out.println("Queue is: ");
            System.out.println(q);
            System.out.print("\n");
        }
    }

//    static private void printQ(IQueue<Double> printer) {
//        if(printer.size() == 0) {
//            System.out.println("Queue is empty!");
//            System.out.println("Queue is: ");
//        }
//        else {
//
//        }
//    }

    static private boolean isEmpty(IQueue<Double> myQ){
        if(myQ.size() == 0) {
            System.out.println("Queue is empty!");
            System.out.println("Queue is: ");
            return true;
        }
        else
            return false;
    }
}
