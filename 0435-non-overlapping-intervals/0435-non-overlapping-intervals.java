class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]); // sort by end time

        int currEndTime = intervals[0][1];
        int inclusion = 1;

        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < currEndTime) {
                currEndTime = Math.min(currEndTime, intervals[i][1]);  // since sorted by end time - i can just set my end time
                continue;
            } else {
                inclusion++;
                currEndTime = intervals[i][1];
            }

        }


        return intervals.length - inclusion;

        
        
    }
}