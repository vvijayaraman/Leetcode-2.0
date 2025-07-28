class LRUCache {
    Node dummyHead = new Node(-1, -1);
    Node dummyTail = new Node(-1, -1);

    Map<Integer, Node> map;
    int capacity = 0;

    // remove from tail
    // add to start

    public LRUCache(int capacity) {
        map = new HashMap<>();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        this.capacity = capacity;
        
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node ans = map.get(key);
        removeNode(ans);
        addNode(ans);

        return ans.value;
        
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            map.put(key, node);

            removeNode(node);
            addNode(node);

            return;
        }

        if (map.size() == capacity) {
            Node node = dummyTail.prev;

            // evict Node
            removeNode(node);
            map.remove(node.key);
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addNode(newNode);
        
    }

    public void addNode(Node node) {
        Node currHead = dummyHead.next;
        Node newHead = node;
        
        newHead.prev = dummyHead;
        dummyHead.next = newHead;

        newHead.next = currHead;
        currHead.prev = newHead;

    }

    public void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

    }
}

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */