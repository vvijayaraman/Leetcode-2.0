class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxL = 0;

        int left = 0;
        int right = 0;

        while(right < s.length()) {
            char curr = s.charAt(right);
            if (!set.contains(s.charAt(right))) {
                set.add(curr);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }

            maxL = Math.max(maxL, set.size());
        }

        return maxL;
        
    }
}