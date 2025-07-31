class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] + currSum > nums[i]) {
                currSum = nums[i] + currSum;
            } else {
                currSum = nums[i];
            }

            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }
}