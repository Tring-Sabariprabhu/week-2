import java.util.LinkedList;
import java.util.Queue;
class LearnQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(20);
        queue.add(10);
        queue.add(30);
        System.out.println("Element at Front position : " + queue.peek());
        System.out.println("Queue : " + queue);
        System.out.println("Queue size : " + queue.size());

        
    }
}