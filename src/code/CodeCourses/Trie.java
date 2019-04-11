package code.CodeCourses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Trie {

    Node head;

    public Trie() {
        this.head = new Node('C');
    }

    public void addString(String input) {

        ArrayList<Character> c = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            c.add(input.charAt(i));
        }

        Node currentNode = head;

        for(int i = 0; i < input.length(); i++) {
            Character chars = input.charAt(i);
            //A
            if(currentNode.children.containsKey(chars)) {
                currentNode = currentNode.children.get(chars);
                if(i == input.length() - 1) {
                    currentNode.isLast = true;
                }
            } else {
                currentNode.children.put(chars, new Node(chars));
                currentNode = currentNode.children.get(chars);
                if(i == input.length() - 1) {
                    currentNode.isLast = true;
                }
            }
        }
    }

}

class Node {
    HashMap<Character, Node> children;
    Character data;
    Boolean isLast;

    public Node(Character c) {
        this.children = new HashMap<>();
        this.data = c;
        this.isLast = false;
    }
}
