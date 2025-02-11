class Solution {
    public int minIncrementForUnique(int[] nums) {
        // [3,2,1,2,1,7]
        // [1,1,2,2,3,7]
        // [1,2,3,4,5,7]
        
        Arrays.sort(nums);
        int moves = 0;

        for(int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1]) {
                int difference = nums[i-1] - nums[i];
                nums[i] = difference + 1 + nums[i];
                moves += difference + 1;
            }

        }

        return moves;
        
    }
}