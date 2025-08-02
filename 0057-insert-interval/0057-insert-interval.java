class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Pair> list = new ArrayList<>();

        // split the question into left half, the interval part and the right half

        // left part is added while no overlap
        int left = 0;
        while(left < intervals.length && intervals[left][1] < newInterval[0]) {
            list.add(new Pair<>(intervals[left][0], intervals[left][1]));
            left++;
        }

        // now need to start merging, figure out how far merge can go
        // do i start before the new interval ends
        while(left < intervals.length && intervals[left][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[left][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[left][1], newInterval[1]);
            left++;

        }

        // add merged element
        list.add(new Pair<>(newInterval[0], newInterval[1]));

        // add leftover to the right
        while(left < intervals.length) {
            list.add(new Pair<>(intervals[left][0], intervals[left][1]));
            left++;

        }

        int[][] arr = new int[list.size()][2];
        int pointer = 0;

        for(Pair<Integer, Integer> pair : list) {
            arr[pointer][0] = pair.getKey();
            arr[pointer][1] = pair.getValue();
            pointer++;
        }

        return arr;
        
    }
}