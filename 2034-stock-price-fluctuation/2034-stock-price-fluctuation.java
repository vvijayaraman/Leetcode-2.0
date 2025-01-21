class StockPrice {

    Map<Integer, Integer> map; // timestamp to price
    TreeMap<Integer, Integer> treeMap; // price to timestamp
    int latestTimeStamp = 0;

    int current = 0;

    public StockPrice() {
        map = new HashMap<>();
        treeMap = new TreeMap<>(Collections.reverseOrder());

    }
    
    public void update(int timestamp, int price) {

        if (timestamp >= latestTimeStamp) {
            latestTimeStamp = timestamp;
            current = price;
        }


        if (map.containsKey(timestamp)) {
            treeMap.remove(map.get(timestamp)); // evict that price

            map.put(timestamp, price);
            treeMap.put(price, timestamp);

        } else {
            map.put(timestamp, price);
            treeMap.put(price, timestamp);
        }
    }
    
    public int current() {
        return current;
        
    }
    
    public int maximum() {
        return treeMap.firstKey();
        
    }
    
    public int minimum() {
        return treeMap.lastKey();
        
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */