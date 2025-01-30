class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int minRooms = 1;

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        Queue<Integer> queue = new PriorityQueue<>(); // min heap
        queue.add(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++) {
        
            // [2,4], [7,10] -> [4,7] - 
            // keep track of earliest end times using min heap

            if (intervals[i][0] >= queue.peek()) { // not overlapping
                queue.remove();
            } else {
                minRooms++;
            }

            queue.add(intervals[i][1]);
        }

        return minRooms;

        
    }
}