class TimeMap {

    TreeMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new TreeMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).put(timestamp, value);
        } else {
            map.put(key, new TreeMap<>());
            map.get(key).put(timestamp, value);
        }
        
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        TreeMap<Integer, String> tMap = map.get(key);
        Integer floorKey = tMap.floorKey(timestamp);

        return floorKey == null ? "" : tMap.get(floorKey);
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */