// Delete the kth node from the end of the singly linked list

// Input: 10 -> 20 -> 30 -> 40 -> 50 -> 60
// K = 2

// res: 10 -> 20 -> 30 -> 40 -> 60

// In-place (O(1) memory complexity)

public class FB_3_1_DeleteKthFromEnd {

    Node head;

    public static void main(String[] args) {
        FB_3_1_DeleteKthFromEnd list = new FB_3_1_DeleteKthFromEnd();
        list.head = new Node(10);
        list.head.next = new Node(20);
    }

    public void deleteKthNode(int k) {
        Node p1 = head;
        Node p2 = head;

        // k = 2
        for (int i=0; i < k; i++) {
            // if k is larger than the size
            if (p1 == null) return;
            p1 = p1.next;
        }

        if (p1 == null) {
            return;
        }

        // p1 -> 20
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        // kth node from the end
        p2.next = p2.next.next;
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

