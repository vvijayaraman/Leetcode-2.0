class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        arr = []
        map = {}

        for i in range(len(nums)):
            diff = target - nums[i]

            if (diff in map):
                arr = [i, map[diff]]
            else:
                map[nums[i]] = i
                

        return arr

        
