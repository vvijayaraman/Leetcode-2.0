class MyHashSet {
    int[] arr;

    public MyHashSet() {
        arr = new int[100001]; 
        Arrays.fill(arr, -1);
    }
    
    public void add(int key) {
       int bucket = getBucket(key);
       arr[bucket] = key;
        
    }
    
    public void remove(int key) {
        if (contains(key)) {
            int bucket = getBucket(key);
            arr[bucket] = -1;
        }
        
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        if (arr[bucket] == -1) {
            return false;
        }

        return true;
        
    }

    public int getBucket(int key) {
        int hash = Integer.hashCode(key);
        int bucket = hash % arr.length;

        return bucket;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */