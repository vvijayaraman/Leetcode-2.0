class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        ans = []
        running_sum = 0
        for i in range(len(nums)):
            ans.append(running_sum + nums[i])
            running_sum += nums[i]

        return ans    


        