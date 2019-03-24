import java.util.HashMap;
import java.util.HashSet;

public class Amazon {

    public static void main(String[] args) {
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);

        Node m = new Node(2);
        m.next = new Node(3);

        System.out.println(compare(n, m ));
    }

    static class Node {
        int value;
        Node next;

        public Node(int val) {
            this.value = val;
        }
    }

    public static boolean compare(Node n1, Node n2) {

        Node p1 = n1;
        Node toCheck1 = n1;
        Node head2 = n2;
        Node toCheck2 = n2;

        //I think I should use two while loops because I want to come back to the original point from where I started the comparision when I find a mismatch.

        while (p1 != null && head2 != null) {
            Node toReturn = p1;
            while (p1!=null && head2!=null && p1.value == head2.value) {

                if (head2.next == null) {
                    return true;
                }

                p1 = p1.next;
                head2 = head2.next;
            }

            p1 = toReturn.next;
            head2 = toCheck2;
        }
        return false;
    }


}
