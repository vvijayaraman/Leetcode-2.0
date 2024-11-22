class TimeMap {

    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            TreeMap<Integer, String> innerMap = new TreeMap<>();
            innerMap.put(timestamp, value);

            map.put(key, innerMap);
        } else {
            map.get(key).put(timestamp, value);

        }
       
    
    }
    
    public String get(String key, int timestamp) {

        if (!map.containsKey(key)) {
            return "";

        }

        Integer greatestKey = map.get(key).floorKey(timestamp);
        return greatestKey == null ? "" : map.get(key).get(greatestKey);
    
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */