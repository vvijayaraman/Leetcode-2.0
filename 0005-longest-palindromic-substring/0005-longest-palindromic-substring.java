// TC - O(N^2)
// SC - O(n) - string created
class Solution {

    String longestStr = "";

    public String longestPalindrome(String s) {
        // 1. Start from the centre and loop outside
        // 2. You could have 2 centres, odd and even so handle both cases.

        for(int i = 0; i < s.length(); i++) {

            findPalindrome(i, i, s); // Left and right start in the centre
            findPalindrome(i, i+1, s); // Left and right start next to each other, 2 middles
        }

        return longestStr;
        
    }

    public void findPalindrome(int left, int right, String s) {
        String currStr = "";

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        currStr = s.substring(left + 1, right);

        if (currStr.length() > longestStr.length()) {
            longestStr = currStr;
        }

    }
}