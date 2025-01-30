class Solution {

    String max = "";

    public String longestPalindrome(String s) {
        // odd = 1 centre
        // even = 2 centres

        for (int i = 0; i < s.length(); i++) {
            palindrome(i, i, s); // odd
            palindrome(i, i+1, s); // odd
        }

        return max;

        
    }

    public void palindrome(int start, int end, String s) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++; 
        }

        String substring = s.substring(start + 1, end); // end is excluded

        if (max.length() < substring.length()) {
            max = substring;
        }

    }
}