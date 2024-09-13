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
public class Node<E extends Comparable<E>> implements Comparable<Node<E>>{

    public E data;
    public Node<E> next;

    public Node() {

    }

    public Node(E data) {
        this.data = data;
    }

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    public boolean equals(Node<E> node) {
        return node.data.equals(this.data);
    }

    @Override
    public int compareTo(Node<E> node) {
        if (true) {
            return data.compareTo(node.data);
        }
        
        if (data.getClass() == String.class) {
            return ((String) data).compareTo((String) node.data);
        } else if (data.getClass() == Short.class) {
            return ((Short) data).compareTo((Short) node.data);
        } else if (data.getClass() == Integer.class) {
            return ((Integer) data).compareTo((Integer) node.data);
        } else if (data.getClass() == Long.class) {
            return ((Long) data).compareTo((Long) node.data);
        } else if (data.getClass() == Float.class) {
            return ((Float) data).compareTo((Float) node.data);
        } else if (data.getClass() == Double.class) {
            return ((Double) data).compareTo((Double) node.data);
        } else if (data.getClass() == Character.class) {
            return ((Character) data).compareTo((Character) node.data);
        }
        return 0;
    }
}
