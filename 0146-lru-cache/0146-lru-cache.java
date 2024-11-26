class LRUCache {
    Map<Integer, Node> map;
    int capacity = Integer.MIN_VALUE;

    // Starting setup as head -> tail
    Node dummyHead = new Node(-1, -1);
    Node dummyTail = new Node(-1, -1);

    public LRUCache(int capacity) {
      
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;

        this.capacity = capacity;
    
        map = new HashMap<>(2);
    }
    
    public int get(int key) {
        // get node and move to head, else -1
        if (!map.containsKey(key)) {
            return -1;
        }

        Node getNode = map.get(key);
        deleteNode(getNode);
        insertNode(getNode);
        return getNode.val;
        
    }
    
    public void put(int key, int value) {
        // if map does not contains key - add at head, if it does update node and move to head

        if (!map.containsKey(key)) {
            Node node = new Node(key, value);

            // Evict if full
            if (map.size() == capacity) {
                // order is important cause deleting first will change pointers
                map.remove(dummyTail.prev.key);
                deleteNode(dummyTail.prev);
                
            }

            insertNode(node);
            map.put(key, node);
        } else {

            Node getNode = map.get(key);
            getNode.val = value;
            deleteNode(getNode);
            insertNode(getNode);
            map.put(getNode.key, getNode);
        }
        
    }

    public void insertNode(Node insert) {
        // Insertion is always in the head
        Node currHead = dummyHead.next;

        insert.prev = dummyHead;
        insert.next = currHead;
        dummyHead.next = insert;
        currHead.prev = insert;


     
    }

    public void deleteNode(Node delete) {
        // Deletion has 2 cases - deleting from tail due to capacity, or get()
        Node deletePrev = delete.prev;
        Node deleteNext = delete.next;

        deletePrev.next = deleteNext;
        deleteNext.prev = deletePrev;

    }
}

class Node {
    int key;
    int val;
    Node prev;
    Node next;

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