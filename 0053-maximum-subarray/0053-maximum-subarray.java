class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int runningSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if (runningSum + nums[i] > nums[i]) {
                runningSum += nums[i];
            } else {
                runningSum = nums[i];
            }

            maxSum = Math.max(maxSum, runningSum);

        }
        
        return maxSum;
        
    }
}