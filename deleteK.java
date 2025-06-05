class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class deleteK {

    
    public static Node deleteKthNode(Node head, int k) {
        if (head == null || k <= 0) return head;
        if (k == 1) return null; 

        Node temp = head;
        int count = 1;

        while (temp != null && temp.next != null) {

            if ( (count + 1) % k == 0) {
                temp.next = temp.next.next;
                
            } else {
                temp = temp.next;
                
            }
            count++;
        }

        return head;
    }

    
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.println("Original List:");
        printList(head);

        int k = 3;
        head = deleteKthNode(head, k);

        System.out.println("After deleting every " + k + "-th node:");
        printList(head);
    }
}
