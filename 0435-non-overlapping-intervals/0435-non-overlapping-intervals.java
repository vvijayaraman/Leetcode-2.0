class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int remove = 0;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // min heap
        queue.add(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < queue.peek()) { // overlapping
                int currEnd = queue.remove();
                queue.add(Math.min(currEnd, intervals[i][1]));
            } else {
                queue.add(intervals[i][1]);
            }

        }

        return intervals.length - queue.size();

        
    }
}