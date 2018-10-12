import java.util.ArrayList;
import java.util.HashMap;

class Trie {
    public static void main(String[] args) {
        Tries tries = new Tries();
        tries.insert("a");
        System.out.print(tries.search("a"));
        System.out.print(tries.startsWith("a"));
    }
}

class Tries {

    Node head = new Node();

    class Node {
        HashMap<Character, Node> childs = new HashMap<>();
        Character character;
        boolean isEnd = false;
    }

    public Tries() {

    }

    public void insert(String word) {
        Node pointer;
        pointer = this.head;
        for (int i = 0; i < word.length(); i++) {
            if (pointer.childs.containsKey(word.charAt(i))) {
                if (i == word.length() - 1) {
                    pointer.childs.get(word.charAt(i)).isEnd = true;
                } else {
                    pointer = pointer.childs.get(word.charAt(i));
                }
            } else {
                Node node = new Node();
                node.character = word.charAt(i);
                pointer.childs.put(word.charAt(i), node);
                pointer = pointer.childs.get(word.charAt(i));

                if (i == word.length() - 1) {
                    node.isEnd = true;
                }
            }
        }
    }

    public boolean search(String word) {
        Node pointer;
        pointer = this.head;

        for (int i = 0; i < word.length(); i++) {
            if (pointer.childs.containsKey(word.charAt(i))) {
                if (i == word.length() - 1 && pointer.childs.get(word.charAt(i)).isEnd) {
                    return true;
                }
                pointer = pointer.childs.get(word.charAt(i));
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean startsWith(String word) {
        Node pointer;
        pointer = this.head;

        for (int i = 0; i < word.length(); i++) {
            if (pointer.childs.containsKey(word.charAt(i))) {
                if (i == word.length() - 1) {
                    return true;
                }
                pointer = pointer.childs.get(word.charAt(i));
            } else {
                return false;
            }
        }
        return false;

    }
}

