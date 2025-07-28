class MyHashMap {
    ListNode[] buckets;

    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new ListNode[10000]; // initialize hashmap, 10000 is the number of operations
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        ListNode prev = findLastNode(index, key);
        
        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        ListNode getNode = findLastNode(index, key);
        return getNode.next == null ? -1 : getNode.next.value;        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        
        ListNode getNode = findLastNode(index, key);
        if (getNode.next != null) {
            getNode.next = getNode.next.next;
        }
        
    }
    
    public int getIndex(int key) {
        int hash = Integer.hashCode(key);
        return hash % buckets.length;
    }
    
    public ListNode findLastNode(int index, int key) {
        if (buckets[index] == null) {
           return buckets[index] = new ListNode(-1, -1);
        } 
        
        ListNode prev = buckets[index];
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        
        return prev;
    }
  
    
public static class ListNode {
        int key;
        int value;
        ListNode next;
    
    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
    
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */