package questions.linked_list;

/**
 * Created by deepanshu.saxena on 17/06/16.
 */
public class DoublyLinkedList {

    public static void main(String[] args) {
        System.out.println("in main");
        DLLOperations dLLOperations = new DLLOperations();
        dLLOperations.add(10);
        dLLOperations.add(20);
        dLLOperations.add(30);
        dLLOperations.add(50);

        dLLOperations.addAfter(40);

//        dLLOperations.traverse();
        System.out.println(" \n After deletion ---------- \n \n");
//        dLLOperations.deleteAfter(40);
        dLLOperations.traverse();
        DLLNode dllNode = dLLOperations.reverseDLL();
        dLLOperations.print(dllNode);

    }

}


class DLLOperations {
    private DLLNode head;
    private DLLNode tail;

    public DLLNode getHead() {
        return head;
    }

    public DLLNode getTail() {
        return tail;
    }

    public void add(int data) {
        DLLNode temp = new DLLNode(data);
        temp.setNext(null);
        temp.setPrevious(null);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.setNext(temp);
            temp.setPrevious(tail);
            tail = temp;

        }
    }

    public void addAfter(int data) {
        DLLNode temp = new DLLNode(data);
        temp.setNext(null);
        temp.setPrevious(null);
        DLLNode current = head;
        while (current.getNext().getData() < data) {
            current = current.getNext();
        }
        temp.setNext(current.getNext());
        temp.setPrevious(current);
        current.getNext().setPrevious(temp);
        current.setNext(temp);
    }

    public void deleteAfter(int data) {
        DLLNode current = head;
        DLLNode previous = null;
        while (current.getData() != data) {
            previous = current;
            current = current.getNext();
        }
        previous.setNext(current.getNext());
        current.getNext().setPrevious(previous);
    }

    public void traverse() {
        if (head == null) {
            return;
        } else {
            DLLNode current = head;
            while (current != null) {
                System.out.println("data ::  " + current.getData());
                current = current.getNext();
            }
        }
    }

    public DLLNode reverseDLL() {
        DLLNode current = head;
        DLLNode temp = null;
        while (current != null) {
            temp = current.getPrevious();   //swap the next and prev pointer
            current.setPrevious(current.getNext());
            current.setNext(temp);
            current = current.getPrevious();
        }
        return temp.getPrevious();
    }

    public void print(DLLNode head) {
        DLLNode current = head;
        while (current != null) {
            System.out.print("  " + current.getData());

            current = current.getNext();
        }
    }
}


class DLLNode {
    private int data;
    private DLLNode next;
    private DLLNode previous;

    public DLLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public DLLNode getPrevious() {
        return previous;
    }

    public void setPrevious(DLLNode previous) {
        this.previous = previous;
    }


}

