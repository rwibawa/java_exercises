/*
* Write a method to find the middle node of a linked list.
* */

public class FindMiddle<T> {
    public static class Node<E> {
        E item;
        Node<E> next;
    }

    public static void main(String[] args) {
        FindMiddle solution = new FindMiddle<>();
        Node<Integer> head = null;
        Node<Integer> pointer = null;

        for (int i = 1; i <= 11; i++) {
            Node<Integer> current = new Node<>();
            current.item = i;
            if (head == null) {
                head = current;
                pointer = head;
            } else {
                pointer.next = current;
                pointer = current;
            }
        }

        pointer = head;
        while (pointer != null) {
            System.out.println(pointer.item);
            pointer = pointer.next;
        }

        pointer = solution.findMiddle(head);
        if (pointer != null) {
            System.out.println("The middle is: " + pointer.item);
        } else {
            System.out.println("There is no middle part!");
        }
    }

    private Node<T> findMiddle(Node<T> head) {
        Node<T> middle = head;
        Node<T> tail = head;

        while (tail != null && tail.next != null) {
            middle = middle.next;
            tail = tail.next.next;
        }

        return middle;
    }
}
