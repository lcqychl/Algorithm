package dataStructure;

public class Linked {
    static class Node {
        char data;
        Node next;

        public Node(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node head, node;
        head = node = new Node('A');
        for (int i = 1; i < 26; i++) {
            Node p = new Node((char) ('A' + i));
            node.next = p;
            node = p;
        }

        print(head);

        head = reverse(head, 5);

        print(head);
    }

    private static void print(Node head) {
        Node nade = head;
        while (nade != null) {
            System.out.print(nade.data + "  ");
            nade = nade.next;
        }
        System.out.println();
    }

    private static Node reverse(Node head, int k) {

        Node first = null;
        Node left = head;
        Node right = null;

        int c = 0;
        while (head != null && head.next != null) {
            Node p = head.next;
            head.next = p.next;
            p.next = left;
            left = p;

            c++;
            if (c < k) {
                first = left;
            }

            if (right != null) {
                right.next = left;
            }

            if (c % (k - 1) == 0) {
                right = head;
                left = head = head.next;
            }

        }
        return first;
    }

}
