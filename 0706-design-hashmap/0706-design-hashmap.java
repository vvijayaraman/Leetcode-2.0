class MyHashMap {

    Node[] arr;

    public MyHashMap() {
        arr = new Node[10000001];
        
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);

        // insert new Node
        if (arr[bucket] == null) {
            arr[bucket] = new Node(key, value);
        } else {
             // repace existing Node or create new node at the end
            Node head = arr[bucket];
            Node curr = head;
            Node prev = head;

            while(curr != null) {
                if (curr.key == key) {
                    curr.val = value;
                    return;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }

            prev.next = new Node(key, value);
        }
        
    }
    
    public int get(int key) {
        int bucket = getBucket(key);

        if (arr[bucket] == null) {
            return -1;
        }

        Node head = arr[bucket];
        Node curr = head;

        while(curr != null && curr.key != key) {
            curr = curr.next;
        }

        return curr != null && curr.key == key ? curr.val : -1;

        
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);

        if (arr[bucket] == null) {
            return;
        }

        Node head = arr[bucket];
        Node curr = head;
        Node prev = head;

        // if removing head
        if (head.key == key) {
            arr[bucket] = head.next;
            return;
        }

        // if not head
        while(curr != null) {            
            if (curr.key == key) {
                prev.next = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
    }


    public int getBucket(int key) {
        int hash = Integer.hashCode(key);
        return hash % arr.length;
    }
    

    
 }

class Node {
    int key;
    int val;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */