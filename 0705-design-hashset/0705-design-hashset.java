class MyHashSet {

    Node[] arr;

    public MyHashSet() {
        arr = new Node[10000001];
    }
    
    public void add(int key) {
        int bucket = getBucket(key);
        
        if (arr[bucket] == null) {
            arr[bucket] = new Node(key);
        } else {
            // existing bucket -> add at the end
            Node head = arr[bucket];
            Node curr = head;
            Node prev = head;

            while(curr != null) {
                if (curr.val == key) {
                    return;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
                
            }

            prev.next = new Node(key);
   
        }
        
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
        if (head.val == key) {
            arr[bucket] = head.next;
            return;
        }

        // not a head
        while (curr != null) {
            if (curr.val == key) {
                prev.next = curr.next;
                return;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);

        if (arr[bucket] == null) {
            return false;
        }

        Node head = arr[bucket];
        Node curr = head;

        while(curr != null) {
            if (curr.val == key) {
                return true;
            }

            curr = curr.next;

        }

        return false;

    }

    public int getBucket(int key) {
        int hash = Integer.hashCode(key);
        return hash % arr.length;

    }
}
 

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */