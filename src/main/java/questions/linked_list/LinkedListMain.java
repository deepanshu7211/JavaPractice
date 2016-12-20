package questions.linked_list;

/**
 * Created by deepanshu.saxena on 17/06/16.
 */

public class LinkedListMain {

    public static void main(String[] args) {
        System.out.println("in main");
        LinkedListOperation linkedListOperation = new LinkedListOperation();
        linkedListOperation.add(10);
        linkedListOperation.add(20);
        linkedListOperation.add(30);
        linkedListOperation.addAfter(25, 2);
        linkedListOperation.addbegnning(5);
        // linkedListOperation.deleteAfter(3);
//        linkedListOperation.traverse();
//        int length=linkedListOperation.getLength(linkedListOperation.getHead());
//        System.out.println("length is  " + length);
        //int found=linkedListOperation.search(linkedListOperation.getHead(), 300);
        //System.out.println("found or not " + found);
        // For reversing
        // linkedListOperation.reverse();
        //linkedListOperation.traverse();

        //linkedListOperation.printReverseList(linkedListOperation.getHead());

//        linkedListOperation.pairwiseswap();
        linkedListOperation.reverseUsingRecursion(linkedListOperation.getHead());
//        System.out.println(" \n ---------- \n");
        linkedListOperation.traverse();
//        linkedListOperation.nthNodeFromEnd(2);

    }
}


class LinkedListOperation {
    private Node head = null;
    private Node tail = null;

    public Node getHead() {
        return head;
    }


    public Node getTail() {
        return tail;
    }


    public void add(int data) {
        //System.out.println("inn add ");
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            // System.out.println("in else part ");
            tail.setNext(temp);
            tail = temp;
        }
    }

    public void traverse() {
        if (head == null)
            return;
        else {
            Node currentNode = head;
            while (currentNode != null) {
                System.out.println("Data :: " + currentNode.getData());
                currentNode = currentNode.getNext();
            }
        }
    }

    public void addAfter(int data, int position) {
        Node temp = new Node(data);
        int count = 1;
        Node currentNode = head;
        while (count < position) {
            count++;
            currentNode = currentNode.getNext();

        }
        // System.out.println("head data " + head.getData());
        //System.out.println("count " + count +  " " +currentNode.getData() + " " );
        temp.setNext(currentNode.getNext());
        currentNode.setNext(temp);
    }

    public void addbegnning(int data) {
        Node temp = new Node(data);
        Node currentNode = head;
        temp.setNext(currentNode);
        head = temp;
    }

    public void deleteAfter(int position) {
        int count = 1;
        Node currentNode = head;
        while (count < position - 1) {
            count++;
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(currentNode.getNext().getNext());
    }

    public int getLength(Node head) {
        if (head.getNext() == null)
            return 1;
        else
            return 1 + getLength(head.getNext());
    }

    public int search(Node head, int data) {
        if (head == null)
            return 0;
        if (head.getData() == data)
            return 1;

        return search(head.getNext(), data);
    }

    public void reverse() {
        Node previous = null, current = head, next;

        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }

    public void printReverseList(Node head) {
        if (head == null)
            return;

        printReverseList(head.getNext());

        System.out.println(head.getData());


    }

    public void pairwiseswap() {
        Node temp = head;

        while (temp != null && temp.getNext() != null) {
            int t = temp.getData();
            temp.setData(temp.getNext().getData());
            temp.getNext().setData(t);
            temp = temp.getNext().getNext();
        }
    }

    public Node reverseUsingRecursion(Node current) {
        System.out.println(" before current value :: " + current.getData());
        if (current == null)
            return null;
        if (current.getNext() == null) {
            System.out.println(" head :: " + current.getData());
            head = current;
            return null;
        }

        reverseUsingRecursion(current.getNext());
        System.out.println(" current value :: " + current.getData() + " next :: " + current.getNext().getData());
        current.getNext().setNext(current);
        current.setNext(null);
        return head;
    }

    public void nthNodeFromEnd(int count) {
        Node pnthNode = null, temp;
        temp = head;
        for (int i = 1; i < count; i++) {
            temp = temp.getNext();
        }
        while (temp != null) {
            if (pnthNode == null) {
                pnthNode = head;
            } else {
                pnthNode = pnthNode.getNext();
            }
            temp = temp.getNext();
        }

        if (pnthNode != null) {
            System.out.println("pnthnode data :: " + pnthNode.getData());
        }
    }
}

//Delete a Node in the Middle of a linked list, Given only access to that Node
//Approach is tricky and simple
//        Copy the value of next node to the node which you want to delete
//        Delete the next node
//http://algorithms.tutorialhorizon.com/find-intersection-point-in-two-linked-list/


class Node {
    private int data;
    private Node next;

    public Node() {

    }

    public Node(int data) {
        this.data = data;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}