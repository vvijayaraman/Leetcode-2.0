class Solution {
    String longest = "";

    public String longestPalindrome(String s) {

        if (s.length() == 1) {
            return s;
        }

        for(int i = 0; i < s.length() - 1; i++) {
            palindrome(i, i, s);
            palindrome(i, i+1, s);
        }

        return longest;
        
    }

    public void palindrome(int i, int j, String s) {

        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        String sub = s.substring(i+1, j);
        if (sub.length() > longest.length()) {
            longest = sub;
        }
    }
}