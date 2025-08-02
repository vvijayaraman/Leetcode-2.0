class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); // sort by start date
        int rooms = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> a[1] - b[1]
        );

        minHeap.add(intervals[0]);
        rooms++;

        for(int i = 1; i < intervals.length; i++) {
            // see if mine starts before the latest one ends
            if (intervals[i][0] < minHeap.peek()[1]) {
                rooms++;
            } else {
                minHeap.remove();
            }

            minHeap.add(intervals[i]);


        }

        return minHeap.size();



    }
}