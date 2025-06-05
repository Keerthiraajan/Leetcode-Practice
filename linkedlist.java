class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class linkedlist {

    static Node head;

    static void addAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    static void addAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    static void deleteAtBeginning() {
        if (head != null) {
            head = head.next;
        }
    }

    static void deleteAtEnd() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
    }

    static void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        addAtBeginning(10);
        addAtBeginning(5);
        addAtEnd(15);
        addAtEnd(20);

        display();

        deleteAtBeginning();
        deleteAtEnd();

        display();
    }
}
