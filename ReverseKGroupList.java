class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class ReverseKGroupList {

    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static Node findKthNode(Node head, int k) {
        Node temp = head;

        for (int i = 0; i < k - 1; i++) {
            if (temp == null)
                return null;
            temp = temp.next;
        }

        return temp;
    }

    static Node reverseKGroup(Node head, int k) {
        Node start = head;
        Node result = new Node(-1);
        Node temp = result;
        Node end = null;
        Node newStart = null;

        while (start != null) {
            end = findKthNode(start, k);

            if (end != null) {
                newStart = end.next;
                end.next = null;
                temp.next = reverse(start);
                temp = start;
                start = newStart;
            } else {
                temp.next = reverse(start);
                break;
            }
        }

        return result.next;
    }

    static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        int k = 3;

        System.out.print("Original List: ");
        display(head);

        head = reverseKGroup(head, k);

        System.out.print("Reversed in K-Groups: ");
        display(head);
    }
}
