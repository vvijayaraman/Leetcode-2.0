class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        maxLength = 0
        left, right = 0, 0

        hash_set = set()

        while(right < len(s)):
            if s[right] in hash_set:
                hash_set.remove(s[left])
                left += 1    
            else:
                hash_set.add(s[right])
                right += 1

            maxLength = max(maxLength, right - left)    

        return maxLength


        
        