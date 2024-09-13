/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_1;

/**
 *
 * @author xhu
 */
public class Queue<E extends Comparable<E>> {

    private final LinkedList<E> queue;

    public Queue() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(E data) {
        queue.add(data);
    }

    public E dequeue() {
        return (E) queue.removeFromHead().data;
    }

    public void printQueue() {
        Node n = queue.head;
        while (n != null){
            System.out.println(n.data);
            n = n.next;
        }
    }

    public int getSize() {
        return 0;
    }
}
