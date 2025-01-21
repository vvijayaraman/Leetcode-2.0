class LRUCache {

    Map<Integer, Node> map;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity = 0;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            addNode(node);
            return node.val;
        }

        return -1;
        
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            map.put(key, node);

            deleteNode(node);
            addNode(node);

            return;
        }

        Node newNode = new Node(key, value);

        if (map.size() == capacity) {
            Node evict = tail.prev;
            deleteNode(evict);
            map.remove(evict.key);
        } 

        addNode(newNode);
        map.put(key, newNode);

    }

 // 1 -> 2 -> 3
    public void addNode(Node node) {
        Node currHead = head.next;
        head.next = node;
        node.prev = head;

        node.next = currHead;
        currHead.prev = node;

    }

// 1 -> 2 -> 3 -> dummy
    public void deleteNode(Node node) {
        Node currNode = map.get(node.key);

        Node currNodePrev = currNode.prev;
        Node currNodeNext = currNode.next;

        currNodePrev.next = currNodeNext;
        currNodeNext.prev = currNodePrev;

    }
}

public class Node {
    public int key;
    public int val;
    public Node next;
    public Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */