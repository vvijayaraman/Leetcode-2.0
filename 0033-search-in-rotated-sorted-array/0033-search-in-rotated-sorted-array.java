class Solution {
    public int search(int[] nums, int target) {
        // 1. First identify which half is sorted. There is always one half sorted
        // 2. Use that half to figure out if your target lies in that half, otherwise eliminate it.
        // 3. So, basically you will have nested if else blocks.

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) { // if left is sorted
                if (target >= nums[left] && target <= nums[mid]) { // Target lies between left and mid, you can conclude this only because they are sorted
                    right = mid - 1;
                } else {
                    left = mid + 1; 
                }
            } else { // if right is sorted
                if (target >= nums[mid] && target <= nums[right]) { // target lies between mid and right, you can conclude this only because they are sorted
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }

        return -1;
    }
}

