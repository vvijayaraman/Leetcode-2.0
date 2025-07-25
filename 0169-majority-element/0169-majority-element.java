class Solution {
    public int majorityElement(int[] nums) {
        int answer = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            if (count == 0) {
                answer = nums[i];
            }

            if (answer == nums[i]) {
                count++;
            } else {
                count--;
            }

        }

        return answer;


        
    }
}