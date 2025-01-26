class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        // Use a stack to keep track of pevious intervals
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(intervals[0][0], intervals[0][1]));

        for(int i = 1; i < intervals.length; i++) {
            Pair pair = stack.pop(); // prev interval

            if (pair.right >= intervals[i][0]) { // overlapping
                Pair newPair = new Pair(pair.left, intervals[i][1]);
                stack.push(newPair);
            } else {
                stack.push(pair);
                stack.push(new Pair(intervals[i][0], intervals[i][1]));
            }
        }

        int[][] ans = new int[stack.size()][2];
        int pointer = stack.size() - 1;

        while(!stack.isEmpty()) {
            Pair pr = stack.pop();
            int[] arr = new int[2];
            arr[0] = pr.left;
            arr[1] = pr.right;

            ans[pointer] = arr;
            pointer--;
        }

        return ans;

        
    }
}

class Pair {
    public int left;
    public int right;

    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }

}

