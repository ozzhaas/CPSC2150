package cpsc2150.MyQueue;

public class testApp {
    public static void main(String [] arr) {
        IQueue<Integer> q = new ArrayQueue<>();

        q.add(5);
        System.out.println(q);
    }
}
