class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) { // left is always at minimal k satisfying this condition
                right = mid; // mid maybe the answer but still haven't found
            } else {
                left = mid + 1; // mid cannot be the answer
            }
        }

        return -1;
        
    }
}