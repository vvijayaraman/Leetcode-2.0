class Solution {

    String longest = "";

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            longestPalindrome(s, i, i);
            longestPalindrome(s, i, i+1);
        }

        return longest;
        
    }

    public void longestPalindrome(String s, int left, int right) {
        while(left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        String currString = s.substring(left + 1, right);
        if (currString.length() > longest.length()) {
            longest = currString;
        }

    }
}