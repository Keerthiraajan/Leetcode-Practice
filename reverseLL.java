class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class reverseLL {

    static Node head;

    public static void main(String[] args) {

        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.print("Original: ");
        display();

        reverse();

        System.out.print("Reversed: ");
        display();
    }

    static void reverse() {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        head = prev;
    }

    static void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }
}
