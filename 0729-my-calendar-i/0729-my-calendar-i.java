class MyCalendar {

    TreeMap<Integer, Integer> map; // sorted by start times


    public MyCalendar() {
        map = new TreeMap<>();
        
    }
    
    public boolean book(int startTime, int endTime) {
        if (map.isEmpty()) {
            map.put(startTime, endTime);
            return true;
        }

        // is my startTime greater than previous end time ?
        Integer prevStart = map.floorKey(startTime);
        if (prevStart != null && map.get(prevStart) > startTime) {
            return false;
        }

        // is my end time lesser than next start time
        Integer nextStart = map.ceilingKey(startTime);
        if (nextStart != null && nextStart < endTime) {
            return false;
        }

        map.put(startTime, endTime);
        return true;
 
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */