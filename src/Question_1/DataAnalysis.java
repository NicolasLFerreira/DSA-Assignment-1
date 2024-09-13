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
public class DataAnalysis<E extends Comparable<E>> {

    private final Queue<E> queue;
    private final Stack<E> stack;
    private final E[] data;

    public DataAnalysis(E[] data) {
        this.stack = new Stack();
        this.queue = new Queue();
        this.data = data;

        for (int i = 0; i < data.length; i++) {
            queue.enqueue(data[i]);
            stack.push(data[i]);
        }
    }

    public boolean isPalindrome() {
        for (int i = 0; i < data.length; i++) {
            if (queue.dequeue() != stack.pop()) return false;
        }
        return true;
    }
}
