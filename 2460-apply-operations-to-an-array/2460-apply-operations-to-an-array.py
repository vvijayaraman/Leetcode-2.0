class Solution:
    def applyOperations(self, nums: List[int]) -> List[int]:

        for i in range(0, len(nums) - 1):
            if (nums[i] == nums[i+1]):
                nums[i] = nums[i] * 2
                nums[i+1] = 0

        left = 0       

        for i in range(len(nums)):
            if (nums[i] != 0):
                nums[left] = nums[i]
                left += 1

        for i in range(left, len(nums)):
            nums[i] = 0     

        return nums       







        