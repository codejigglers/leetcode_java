package code.src;

import java.util.HashMap;

public class AddandSearchWord {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search(".ad"));
    }


    private static class WordDictionary {

        Node root = new Node();

        public WordDictionary() {


        }

        public void addWord(String word) {
            Node pointer = root;

            for (int i = 0; i < word.length(); i++) {
                if (pointer.hashMap.containsKey(word.charAt(i))) {
                    pointer = pointer.hashMap.get(word.charAt(i));
                    if (i == word.length() - 1) {
                        pointer.isEnd = true;
                    }
                } else {
                    Node node = new Node();
                    node.Value = word.charAt(i);
                    if (i == word.length() - 1) {
                        node.isEnd = true;
                    }
                    pointer.hashMap.put(word.charAt(i), node);
                    pointer = pointer.hashMap.get(word.charAt(i));
                }
            }
        }

        public boolean search(String word) {

            return searchs(word, true, root);
        }

        public boolean searchs(String word, boolean isStart, Node start) {
            Node pointer;

            if (isStart) {
                pointer = root;
            } else {
                pointer = start;
            }

            boolean answer = false;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == '.') {
                    for (Character c : pointer.hashMap.keySet()) {
                        Node p = pointer.hashMap.get(c);
                        if (i == word.length() - 1 && pointer.hashMap.get(c).isEnd == true) {
                            return true;
                        }
                        answer = answer || searchs(word.substring(i + 1, word.length()), false, p);
                    }
                    break;
                } else {
                    if (pointer.hashMap.containsKey(word.charAt(i))) {
                        if(i == word.length() - 1 && pointer.hashMap.get(word.charAt(i)).isEnd) {
                            return true;
                        }
                        pointer = pointer.hashMap.get(word.charAt(i));

                    } else {
                        return false;
                    }
                }
            }
            return answer;
        }
    }

    private static class Node {

        char Value;
        boolean isEnd;
        HashMap<Character, Node> hashMap = new HashMap<>();

        public Node() {
        }
    }

}
