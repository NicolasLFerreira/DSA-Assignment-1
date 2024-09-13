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
public class Stack <E extends Comparable<E>>{
    
    LinkedList<E> stack;

    public Stack() {
        this.stack = new LinkedList();
    }
    
    public void push(E data)
    {
        stack.add(data);
    }
    
    public E pop()
    {
        return (E) stack.removeFromTail().data;
    }
    
    public void printStack()
    {
        stack.printLinkedList();
    }
    
    public int getSize()
    {
        return stack.size;
    }
}
