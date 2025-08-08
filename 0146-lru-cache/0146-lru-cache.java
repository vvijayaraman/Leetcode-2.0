class LRUCache<K,V> {

    Node<K,V> dummyHead = new Node<>(null, null);
    Node<K,V> dummyTail = new Node<>(null, null);
    int capacity = 0;
    Map<K, Node<K,V>> map;

    public LRUCache(int capacity) {
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node<K,V> getNode = map.get(key);
        removeNode(getNode);
        addNode(getNode);

        return (Integer) getNode.value;
        
    }
    
    public void put(K key, V value) {

        if (map.containsKey(key)) {
            Node<K,V> currNode = map.get(key);
            currNode.value = value;
            map.put(key, currNode);

            removeNode(currNode);
            addNode(currNode);
            return;
        }

        if (map.size() == capacity) {
            // evict
            Node<K,V> evict = dummyTail.prev;
            map.remove(evict.key);
            removeNode(evict);
        }

        Node<K, V> node = new Node<K, V>(key, value);
        map.put(key, node);
        addNode(node);

    }

    public void addNode(Node<K,V> newNode) {
        // add front
        Node<K,V> currFront = dummyHead.next;

        newNode.prev = dummyHead;
        dummyHead.next = newNode;

        newNode.next = currFront;
        currFront.prev = newNode;

    }

    public void removeNode(Node<K,V> node) {
        Node<K,V> prevNode = node.prev;
        Node<K,V> nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    class Node<K, V> {
        K key;
        V value;
        Node<K,V> next;
        Node<K,V> prev;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */