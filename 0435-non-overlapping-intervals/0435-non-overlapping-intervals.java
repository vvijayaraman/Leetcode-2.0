class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]); // sort by end time

        int currEndTime = intervals[0][1];
        int inclusion = 1;

        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < currEndTime) {
              // since sorted by end time - i don't need to do anything. Simply ignore and move on
                continue;
            } else {
                inclusion++;
                currEndTime = intervals[i][1];
            }

        }


        return intervals.length - inclusion;

        
        
    }
}