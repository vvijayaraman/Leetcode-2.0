class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        replace = 0
        pointer = 0

        while(pointer < len(nums) and replace < len(nums)):
            if (nums[pointer] != val):
                nums[replace] = nums[pointer]
                replace += 1

            pointer += 1    

        return replace        