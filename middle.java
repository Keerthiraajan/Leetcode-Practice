class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class middle {

    static Node head;

    public static void main(String[] args) {

        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        findMiddle();
    }

    static void findMiddle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow != null) {
            System.out.println("Middle element: " + slow.data);
        }
    }
}
