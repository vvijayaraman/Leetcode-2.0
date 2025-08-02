class Solution {
    public int[][] merge(int[][] intervals) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(intervals[0][0], intervals[0][1]));

        for(int i = 1; i < intervals.length; i++) {
            // need to merge
            if (intervals[i][0] <= stack.peek().getValue()) {
                Pair<Integer, Integer>  pop = stack.pop();
                int left = Math.min(intervals[i][0], pop.getKey());
                int right = Math.max(intervals[i][1], pop.getValue());
                stack.push(new Pair<>(left, right));
            } else {
                stack.push(new Pair<>(intervals[i][0], intervals[i][1]));

            }
        }

        int[][] arr = new int[stack.size()][2];
        int pointer = arr.length - 1;

        while(!stack.isEmpty()) {
            Pair<Integer, Integer> pair = stack.pop();
            arr[pointer][0] = pair.getKey();
            arr[pointer][1] = pair.getValue();
            pointer--;
        }

        return arr;

        
    }
}