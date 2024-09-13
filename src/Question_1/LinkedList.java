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
public class LinkedList<E extends Comparable<E>> {

    public int size = 0;
    public Node<E> head;

    public LinkedList() {

    }

    // Access
    public Node getHead() {
        return head;
    }

    public Node getNode(int index) {
        return getNode(index, head);
    }

    private Node getNode(int index, Node head) {
        if (head != null) {
            if (index == 0) {
                return head;
            } else {
                return getNode(--index, head.next);
            }
        }

        return null;
    }

    public E getData(int index) {
        return getData(index, head);
    }

    private E getData(int index, Node head) {
        if (head != null) {
            if (index == 0) {
                return (E) head.data;
            } else {
                return getData(--index, head.next);
            }
        }

        return null;
    }

    // Insertion
    public void addHead(E data) {
        Node<E> newHead = new Node<>(data, head);
        head = newHead;
        size++;
    }

    public void add(E data) {
        if (head == null) {
            addHead(data);
            return;
        }
        add(head, new Node(data, null));
    }

    private void add(Node head, Node node) {
        if (head.next == null) {
            head.next = node;
            size++;
        } else {
            add(head.next, node);
        }
    }

    public void addInOrder(E data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            size++;
        } else if (node.compareTo(head) <= 0) {
            addHead(data);
        } else {
            addInOrder(head, node);
        }
    }

    private void addInOrder(Node currentNode, Node newNode) {
        if (currentNode.next == null) {
            currentNode.next = newNode;
            size++;
            return;
        }

        if (newNode.compareTo(currentNode.next) <= 0) {
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            size++;
            return;
        }

        addInOrder(currentNode.next, newNode);
    }

    // Printing
    public void printLinkedList() {
        printLinkedList(head);
    }

    private void printLinkedList(Node node) {
        if (node != null) {
            System.out.println(node.data);
            printLinkedList(node.next);
        }
    }

    // Contains
    public boolean contains(Node node) {
        return contains(head, node);
    }

    private boolean contains(Node head, Node node) {
        if (head != null) {
            if (head.equals(node)) {
                return true;
            }

            return contains(head.next, node);
        }

        return false;
    }

    // Deletion
    public void remove(Node node) {
        if (head.equals(node)) {
            head = head.next;
            size--;
        } else {
            removeFromBody(head, node);
        }
    }

    public void remove(int position) {
        if (position == 0) {
            head = head.next;
            size--;

            return;
        }
        removeByIndex(head, position);
    }

    private void removeFromBody(Node head, Node node) {
        if (head != null) {
            if (head.next != null) {
                if (head.next.equals(node)) {
                    head.next = head.next.next;
                    size--;
                } else {
                    removeFromBody(head.next, node);
                }
            }
        }
    }

    private void removeByIndex(Node head, int position) {
        if (head != null) {
            if (position > 1) {
                removeByIndex(head.next, --position);
            } else {
                if (head.next != null) {
                    head.next = head.next.next;
                    size--;
                }
            }
        }
    }

    public Node removeFromHead() {
        if (head == null) {
            return null;
        }
        Node node = head;
        head = head.next;
        size--;

        return node;
    }

    public Node removeFromTail() {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            Node tail = head;
            head = null;
            size--;
            return tail;
        }
        return removeFromTail(head);
    }

    private Node removeFromTail(Node node) {
        if (node.next.next == null) {
            Node tail = node.next;
            node.next = null;
            size--;
            return tail;
        }

        return removeFromTail(node.next);
    }
}
