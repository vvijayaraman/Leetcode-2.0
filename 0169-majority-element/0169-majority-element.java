class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ans = nums[0];

        for(int num : nums) {
            if (count == 0) {
                ans = num;
            }

            if (ans == num) {
                count++;
            } else {
                count--;
            }
            

        }

        return ans;
        
        
    }
}