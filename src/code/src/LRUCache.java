import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {

    HashMap<Integer, Integer> hashMap = new HashMap<>();
    LinkedList<Integer> linkedList = new LinkedList<>();


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.put(1,1);

    }

    public LRUCache(int capacity) {

    }

    public int get(int key) {
        return 2;
    }

    public void put(int key, int value) {

    }
}