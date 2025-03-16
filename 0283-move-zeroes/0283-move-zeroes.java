class Solution {
    public void moveZeroes(int[] nums) {
        int lastPtr = 0;

        // move non zero's to last seen zeros
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastPtr] = nums[i];
                lastPtr++;
            }
        }

        for(int i = lastPtr; i < nums.length; i++) {
            nums[i] = 0;
        }

        return;
        
    }
}