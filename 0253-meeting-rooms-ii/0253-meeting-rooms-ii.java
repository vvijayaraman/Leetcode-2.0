class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]); // sort by start time
        int answer = 0;

        Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        queue.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
                int[] arr = queue.remove();

                // does it overlap;
                if (intervals[i][0] < arr[1]) {
                    queue.add(intervals[i]);
                    queue.add(arr);
                } else {
                    queue.add(intervals[i]);
                }
            }

        return queue.size();
        
    }
}